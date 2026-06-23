package gui;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dto.HospedagemDTO;
import dto.ReservaDTO;
import enums.StatusReserva;
import service.HospedagemService;
import service.ReservaService;

public class HospedagemWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<ReservaDTO> cbReservas;
	private JTextField txtCodigoHospedagem;
	private JTable tblHospedagens;

	private HospedagemService hospedagemService;
	private ReservaService reservaService;
	private SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public HospedagemWindow() {
		hospedagemService = new HospedagemService();
		reservaService = new ReservaService();
		inicializarComponentes();
		carregarReservas();
		buscarHospedagens();
	}

	private void inicializarComponentes() {

		setTitle("Gerenciamento de Hospedagem");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelCheckin = new JPanel();
		panelCheckin.setBorder(new TitledBorder("Check-in"));
		panelCheckin.setBounds(10, 10, 860, 80);
		panelCheckin.setLayout(null);
		contentPane.add(panelCheckin);

		JLabel lblReserva = new JLabel("Reserva Ativa:");
		lblReserva.setBounds(10, 30, 90, 20);
		panelCheckin.add(lblReserva);

		cbReservas = new JComboBox<>();
		cbReservas.setBounds(100, 30, 400, 20);
		panelCheckin.add(cbReservas);

		JButton btnCheckin = new JButton("Realizar Check-in");
		btnCheckin.setBounds(520, 30, 150, 25);
		btnCheckin.addActionListener(e -> realizarCheckin());
		panelCheckin.add(btnCheckin);

		JPanel panelCheckout = new JPanel();
		panelCheckout.setBorder(new TitledBorder("Check-out"));
		panelCheckout.setBounds(10, 100, 860, 80);
		panelCheckout.setLayout(null);
		contentPane.add(panelCheckout);

		JLabel lblHospedagem = new JLabel("Codigo Hospedagem:");
		lblHospedagem.setBounds(10, 30, 130, 20);
		panelCheckout.add(lblHospedagem);

		txtCodigoHospedagem = new JTextField();
		txtCodigoHospedagem.setBounds(140, 30, 100, 20);
		panelCheckout.add(txtCodigoHospedagem);

		JButton btnCheckout = new JButton("Realizar Check-out");
		btnCheckout.setBounds(260, 30, 150, 25);
		btnCheckout.addActionListener(e -> realizarCheckout());
		panelCheckout.add(btnCheckout);

		JButton btnAtualizar = new JButton("Atualizar Lista");
		btnAtualizar.setBounds(430, 30, 130, 25);
		btnAtualizar.addActionListener(e -> {
			carregarReservas();
			buscarHospedagens();
		});
		panelCheckout.add(btnAtualizar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 860, 260);
		contentPane.add(scrollPane);

		tblHospedagens = new JTable();
		tblHospedagens.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Codigo", "Reserva", "Cliente", "Quarto", "Check-in", "Check-out", "Diarias",
						"Valor Total", "Status" }));
		scrollPane.setViewportView(tblHospedagens);
	}

	private void carregarReservas() {
		try {
			cbReservas.removeAllItems();
			for (ReservaDTO reserva : reservaService.buscarTodos()) {
				if (reserva.getStatus() == StatusReserva.ATIVA) {
					cbReservas.addItem(reserva);
				}
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarHospedagens() {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tblHospedagens.getModel();
			modelo.setRowCount(0);

			List<HospedagemDTO> lista = hospedagemService.buscarTodos();
			for (HospedagemDTO hospedagem : lista) {
				modelo.addRow(new Object[] {
						hospedagem.getCodigo(),
						hospedagem.getReservaDTO().getCodigo(),
						hospedagem.getReservaDTO().getClienteDTO().getNome(),
						hospedagem.getReservaDTO().getQuartoDTO().getNumero(),
						hospedagem.getDataHoraCheckin() != null
								? sdfDataHora.format(hospedagem.getDataHoraCheckin())
								: "",
						hospedagem.getDataHoraCheckout() != null
								? sdfDataHora.format(hospedagem.getDataHoraCheckout())
								: "",
						hospedagem.getQtdDiarias(),
						hospedagem.getValorTotal(),
						hospedagem.getStatus()
				});
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void realizarCheckin() {
		ReservaDTO reserva = (ReservaDTO) cbReservas.getSelectedItem();
		if (reserva == null) {
			JOptionPane.showMessageDialog(this, "Selecione uma reserva ativa.",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			String erro = hospedagemService.realizarCheckin(reserva.getCodigo());
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this,
						"Check-in realizado com sucesso para reserva " + reserva.getCodigo() + "!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				carregarReservas();
				buscarHospedagens();
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void realizarCheckout() {
		if (txtCodigoHospedagem.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o codigo da hospedagem.",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			int codigo = Integer.parseInt(txtCodigoHospedagem.getText().trim());

			String erro = hospedagemService.realizarCheckout(codigo);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				HospedagemDTO depois = hospedagemService.buscarPorChave(codigo);
				JOptionPane.showMessageDialog(this,
						"Check-out realizado!\nDiarias: " + depois.getQtdDiarias()
								+ "\nValor total: R$ " + String.format("%.2f", depois.getValorTotal()),
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				txtCodigoHospedagem.setText("");
				carregarReservas();
				buscarHospedagens();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Codigo invalido.", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
