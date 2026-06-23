package gui;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dto.ClienteDTO;
import dto.QuartoDTO;
import dto.ReservaDTO;
import enums.StatusQuarto;
import service.ClienteService;
import service.QuartoService;
import service.ReservaService;

public class ReservaWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<ClienteDTO> cbCliente;
	private JComboBox<QuartoDTO> cbQuarto;
	private JFormattedTextField txtCheckin;
	private JFormattedTextField txtCheckout;
	private JSpinner spHospedes;
	private JTextField txtCodigoReserva;
	private JTable tblReservas;

	private ReservaService reservaService;
	private ClienteService clienteService;
	private QuartoService quartoService;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ReservaWindow() {
		reservaService = new ReservaService();
		clienteService = new ClienteService();
		quartoService = new QuartoService();
		criarMascaras();
		inicializarComponentes();
		carregarCombos();
		buscarReservas();
	}

	private void criarMascaras() {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			txtCheckin = new JFormattedTextField(mascara);
			txtCheckout = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			txtCheckin = new JFormattedTextField();
			txtCheckout = new JFormattedTextField();
		}
	}

	private void inicializarComponentes() {

		setTitle("Gerenciamento de Reservas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 520);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelForm = new JPanel();
		panelForm.setBorder(new TitledBorder("Nova Reserva"));
		panelForm.setBounds(10, 10, 810, 150);
		panelForm.setLayout(null);
		contentPane.add(panelForm);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 25, 60, 20);
		panelForm.add(lblCliente);

		cbCliente = new JComboBox<>();
		cbCliente.setBounds(70, 25, 250, 20);
		panelForm.add(cbCliente);

		JLabel lblQuarto = new JLabel("Quarto:");
		lblQuarto.setBounds(340, 25, 50, 20);
		panelForm.add(lblQuarto);

		cbQuarto = new JComboBox<>();
		cbQuarto.setBounds(390, 25, 200, 20);
		panelForm.add(cbQuarto);

		JLabel lblCheckin = new JLabel("Check-in:");
		lblCheckin.setBounds(10, 55, 60, 20);
		panelForm.add(lblCheckin);

		txtCheckin.setBounds(70, 55, 100, 20);
		panelForm.add(txtCheckin);

		JLabel lblCheckout = new JLabel("Check-out:");
		lblCheckout.setBounds(190, 55, 70, 20);
		panelForm.add(lblCheckout);

		txtCheckout.setBounds(260, 55, 100, 20);
		panelForm.add(txtCheckout);

		JLabel lblHospedes = new JLabel("Hospedes:");
		lblHospedes.setBounds(390, 55, 60, 20);
		panelForm.add(lblHospedes);

		spHospedes = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		spHospedes.setBounds(450, 55, 50, 20);
		panelForm.add(spHospedes);

		JButton btnCadastrar = new JButton("Registrar Reserva");
		btnCadastrar.setBounds(10, 95, 150, 25);
		btnCadastrar.addActionListener(e -> cadastrar());
		panelForm.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar Reserva");
		btnCancelar.setBounds(170, 95, 150, 25);
		btnCancelar.addActionListener(e -> cancelar());
		panelForm.add(btnCancelar);

		JLabel lblCodigo = new JLabel("Codigo Reserva:");
		lblCodigo.setBounds(340, 95, 100, 20);
		panelForm.add(lblCodigo);

		txtCodigoReserva = new JTextField();
		txtCodigoReserva.setBounds(440, 95, 80, 20);
		panelForm.add(txtCodigoReserva);

		JButton btnAtualizarLista = new JButton("Atualizar Lista");
		btnAtualizarLista.setBounds(540, 95, 130, 25);
		btnAtualizarLista.addActionListener(e -> buscarReservas());
		panelForm.add(btnAtualizarLista);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 810, 300);
		contentPane.add(scrollPane);

		tblReservas = new JTable();
		tblReservas.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Codigo", "Cliente", "Quarto", "Check-in", "Check-out", "Hospedes", "Status" }));
		scrollPane.setViewportView(tblReservas);
	}

	private void carregarCombos() {
		try {
			cbCliente.removeAllItems();
			for (ClienteDTO cliente : clienteService.buscarTodos()) {
				cbCliente.addItem(cliente);
			}

			cbQuarto.removeAllItems();
			for (QuartoDTO quarto : quartoService.buscarTodos()) {
				if (quarto.getStatus() == StatusQuarto.DISPONIVEL) {
					cbQuarto.addItem(quarto);
				}
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarReservas() {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tblReservas.getModel();
			modelo.setRowCount(0);

			for (ReservaDTO reserva : reservaService.buscarTodos()) {
				modelo.addRow(new Object[] {
						reserva.getCodigo(),
						reserva.getClienteDTO().getNome(),
						reserva.getQuartoDTO().getNumero(),
						sdf.format(reserva.getDataCheckin()),
						sdf.format(reserva.getDataCheckout()),
						reserva.getQtdHospedes(),
						reserva.getStatus()
				});
			}

			carregarCombos();
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cadastrar() {
		try {
			ClienteDTO cliente = (ClienteDTO) cbCliente.getSelectedItem();
			QuartoDTO quarto = (QuartoDTO) cbQuarto.getSelectedItem();

			if (cliente == null || quarto == null) {
				JOptionPane.showMessageDialog(this, "Selecione cliente e quarto.",
						"Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			ReservaDTO reserva = new ReservaDTO();
			reserva.setClienteDTO(cliente);
			reserva.setQuartoDTO(quarto);
			reserva.setDataCheckin(new Date(sdf.parse(txtCheckin.getText().trim()).getTime()));
			reserva.setDataCheckout(new Date(sdf.parse(txtCheckout.getText().trim()).getTime()));
			reserva.setQtdHospedes((Integer) spHospedes.getValue());

			String erro = reservaService.cadastrar(reserva);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Reserva registrada! Codigo: " + reserva.getCodigo(),
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				txtCheckin.setText("");
				txtCheckout.setText("");
				buscarReservas();
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Datas invalidas.", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelar() {
		if (txtCodigoReserva.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o codigo da reserva.",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int confirmacao = JOptionPane.showConfirmDialog(this,
				"Deseja realmente cancelar esta reserva?", "Confirmacao", JOptionPane.YES_NO_OPTION);

		if (confirmacao != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			String erro = reservaService.cancelar(Integer.parseInt(txtCodigoReserva.getText().trim()));
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Reserva cancelada com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				txtCodigoReserva.setText("");
				buscarReservas();
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
