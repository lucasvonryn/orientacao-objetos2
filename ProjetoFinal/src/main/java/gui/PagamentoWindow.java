package gui;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;

import dto.HospedagemDTO;
import dto.PagamentoDTO;
import enums.FormaPagamento;
import service.HospedagemService;
import service.PagamentoService;

public class PagamentoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<HospedagemDTO> cbHospedagem;
	private JTextField txtValor;
	private JFormattedTextField txtData;
	private JComboBox<FormaPagamento> cbFormaPagamento;
	private JTable tblPagamentos;

	private PagamentoService pagamentoService;
	private HospedagemService hospedagemService;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public PagamentoWindow() {
		pagamentoService = new PagamentoService();
		hospedagemService = new HospedagemService();
		criarMascaraData();
		inicializarComponentes();
		carregarHospedagens();
		buscarPagamentos();
	}

	private void criarMascaraData() {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			txtData = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			txtData = new JFormattedTextField();
		}
	}

	private void inicializarComponentes() {

		setTitle("Registro de Pagamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 480);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelForm = new JPanel();
		panelForm.setBorder(new TitledBorder("Novo Pagamento"));
		panelForm.setBounds(10, 10, 710, 150);
		panelForm.setLayout(null);
		contentPane.add(panelForm);

		JLabel lblHospedagem = new JLabel("Hospedagem:");
		lblHospedagem.setBounds(10, 25, 80, 20);
		panelForm.add(lblHospedagem);

		cbHospedagem = new JComboBox<>();
		cbHospedagem.setBounds(90, 25, 300, 20);
		panelForm.add(cbHospedagem);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(10, 55, 50, 20);
		panelForm.add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(90, 55, 100, 20);
		panelForm.add(txtValor);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(210, 55, 40, 20);
		panelForm.add(lblData);

		txtData.setBounds(250, 55, 100, 20);
		panelForm.add(txtData);

		JLabel lblForma = new JLabel("Forma:");
		lblForma.setBounds(370, 55, 50, 20);
		panelForm.add(lblForma);

		cbFormaPagamento = new JComboBox<>(FormaPagamento.values());
		cbFormaPagamento.setBounds(420, 55, 150, 20);
		panelForm.add(cbFormaPagamento);

		JButton btnRegistrar = new JButton("Registrar Pagamento");
		btnRegistrar.setBounds(10, 100, 180, 25);
		btnRegistrar.addActionListener(e -> registrar());
		panelForm.add(btnRegistrar);

		JButton btnAtualizar = new JButton("Atualizar Lista");
		btnAtualizar.setBounds(200, 100, 150, 25);
		btnAtualizar.addActionListener(e -> {
			carregarHospedagens();
			buscarPagamentos();
		});
		panelForm.add(btnAtualizar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 710, 260);
		contentPane.add(scrollPane);

		tblPagamentos = new JTable();
		tblPagamentos.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Codigo", "Hospedagem", "Valor", "Data", "Forma Pagamento" }));
		scrollPane.setViewportView(tblPagamentos);
	}

	private void carregarHospedagens() {
		try {
			cbHospedagem.removeAllItems();
			List<HospedagemDTO> lista = hospedagemService.buscarTodos();
			for (HospedagemDTO hospedagem : lista) {
				cbHospedagem.addItem(hospedagem);
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarPagamentos() {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tblPagamentos.getModel();
			modelo.setRowCount(0);

			for (PagamentoDTO pagamento : pagamentoService.buscarTodos()) {
				modelo.addRow(new Object[] {
						pagamento.getCodigo(),
						pagamento.getHospedagemDTO().getCodigo(),
						pagamento.getValor(),
						pagamento.getData() != null ? sdf.format(pagamento.getData()) : "",
						pagamento.getFormaPagamento()
				});
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void registrar() {
		try {
			HospedagemDTO hospedagem = (HospedagemDTO) cbHospedagem.getSelectedItem();
			if (hospedagem == null) {
				JOptionPane.showMessageDialog(this, "Selecione uma hospedagem.",
						"Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			PagamentoDTO pagamento = new PagamentoDTO();
			pagamento.setHospedagemDTO(hospedagem);
			pagamento.setValor(Double.parseDouble(txtValor.getText().trim().replace(",", ".")));
			pagamento.setData(new Date(sdf.parse(txtData.getText().trim()).getTime()));
			pagamento.setFormaPagamento((FormaPagamento) cbFormaPagamento.getSelectedItem());

			String erro = pagamentoService.cadastrar(pagamento);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Pagamento registrado! Codigo: " + pagamento.getCodigo(),
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				txtValor.setText("");
				txtData.setText("");
				buscarPagamentos();
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Data invalida.", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Valor invalido.", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
