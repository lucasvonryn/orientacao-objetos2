package gui;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ListSelectionModel;

import dto.ClienteDTO;
import service.ClienteService;

public class ClienteWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JFormattedTextField txtDataNascimento;
	private JTextField txtBusca;
	private JTable tblClientes;

	private ClienteService clienteService;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ClienteWindow() {
		clienteService = new ClienteService();
		criarMascaraData();
		inicializarComponentes();
		buscarClientes();
		limparCampos();
	}

	private void criarMascaraData() {
		try {
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			txtDataNascimento = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			txtDataNascimento = new JFormattedTextField();
		}
	}

	private void inicializarComponentes() {

		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelForm = new JPanel();
		panelForm.setBorder(new TitledBorder("Dados do Cliente"));
		panelForm.setBounds(10, 10, 710, 180);
		panelForm.setLayout(null);
		contentPane.add(panelForm);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 25, 80, 20);
		panelForm.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(90, 25, 80, 20);
		panelForm.add(txtCodigo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 55, 80, 20);
		panelForm.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(90, 55, 300, 20);
		panelForm.add(txtNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(400, 25, 50, 20);
		panelForm.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setBounds(450, 25, 120, 20);
		panelForm.add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(400, 55, 60, 20);
		panelForm.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(470, 55, 120, 20);
		panelForm.add(txtTelefone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 85, 80, 20);
		panelForm.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(90, 85, 300, 20);
		panelForm.add(txtEmail);

		JLabel lblDataNasc = new JLabel("Nascimento:");
		lblDataNasc.setBounds(400, 85, 80, 20);
		panelForm.add(lblDataNasc);

		txtDataNascimento.setBounds(480, 85, 110, 20);
		panelForm.add(txtDataNascimento);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 130, 100, 25);
		btnCadastrar.addActionListener(e -> cadastrar());
		panelForm.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(120, 130, 100, 25);
		btnAtualizar.addActionListener(e -> atualizar());
		panelForm.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(230, 130, 100, 25);
		btnExcluir.addActionListener(e -> excluir());
		panelForm.add(btnExcluir);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(340, 130, 100, 25);
		btnLimpar.addActionListener(e -> limparCampos());
		panelForm.add(btnLimpar);

		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new TitledBorder("Busca por Codigo ou CPF"));
		panelBusca.setBounds(10, 200, 710, 60);
		panelBusca.setLayout(null);
		contentPane.add(panelBusca);

		txtBusca = new JTextField();
		txtBusca.setBounds(10, 25, 200, 20);
		panelBusca.add(txtBusca);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(220, 25, 100, 20);
		btnBuscar.addActionListener(e -> buscar());
		panelBusca.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 270, 710, 180);
		contentPane.add(scrollPane);

		tblClientes = new JTable();
		tblClientes.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Codigo", "Nome", "CPF", "Telefone", "E-mail", "Nascimento" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					preencherFormularioDaTabela();
				}
			}
		});
		scrollPane.setViewportView(tblClientes);
	}

	private void preencherFormularioDaTabela() {

		int linha = tblClientes.getSelectedRow();
		if (linha < 0) {
			return;
		}

		try {
			int codigo = Integer.parseInt(tblClientes.getValueAt(linha, 0).toString());
			ClienteDTO cliente = clienteService.buscarPorChave(codigo);
			if (cliente != null) {
				preencherFormulario(cliente);
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro ao carregar cliente: " + e.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscarClientes() {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
			modelo.setRowCount(0);

			for (ClienteDTO cliente : clienteService.buscarTodos()) {
				modelo.addRow(new Object[] {
						cliente.getCodigo(),
						cliente.getNome(),
						cliente.getCpf(),
						cliente.getTelefone(),
						cliente.getEmail(),
						cliente.getDataNascimento() != null ? sdf.format(cliente.getDataNascimento()) : ""
				});
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro ao listar clientes: " + e.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private ClienteDTO montarClienteDoFormulario() throws ParseException {
		ClienteDTO cliente = new ClienteDTO();
		if (!txtCodigo.getText().trim().isEmpty()) {
			cliente.setCodigo(Integer.parseInt(txtCodigo.getText().trim()));
		}
		cliente.setNome(txtNome.getText().trim());
		cliente.setCpf(txtCpf.getText().trim());
		cliente.setTelefone(txtTelefone.getText().trim());
		cliente.setEmail(txtEmail.getText().trim());
		if (!txtDataNascimento.getText().trim().isEmpty()) {
			java.util.Date data = sdf.parse(txtDataNascimento.getText().trim());
			cliente.setDataNascimento(new Date(data.getTime()));
		}
		return cliente;
	}

	private void preencherFormulario(ClienteDTO cliente) {
		txtCodigo.setText(cliente.getCodigo() != null ? cliente.getCodigo().toString() : "");
		txtNome.setText(cliente.getNome());
		txtCpf.setText(cliente.getCpf());
		txtTelefone.setText(cliente.getTelefone());
		txtEmail.setText(cliente.getEmail());
		txtDataNascimento.setText(cliente.getDataNascimento() != null ? sdf.format(cliente.getDataNascimento()) : "");
	}

	private void cadastrar() {
		try {
			ClienteDTO cliente = montarClienteDoFormulario();
			String erro = clienteService.cadastrar(cliente);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso! Codigo: " + cliente.getCodigo(),
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				buscarClientes();
				limparCampos();
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Data de nascimento invalida.", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void atualizar() {
		try {
			ClienteDTO cliente = montarClienteDoFormulario();
			String erro = clienteService.atualizar(cliente);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				buscarClientes();
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Data de nascimento invalida.", "Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void excluir() {
		if (txtCodigo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o codigo do cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int confirmacao = JOptionPane.showConfirmDialog(this,
				"Deseja realmente excluir este cliente?", "Confirmacao", JOptionPane.YES_NO_OPTION);

		if (confirmacao != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			String erro = clienteService.excluir(Integer.parseInt(txtCodigo.getText().trim()));
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Cliente excluido com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				buscarClientes();
				limparCampos();
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscar() {
		String termo = txtBusca.getText().trim();
		if (termo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe codigo ou CPF para busca.",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			ClienteDTO cliente = null;

			if (termo.matches("\\d+")) {
				try {
					int codigo = Integer.parseInt(termo);
					cliente = clienteService.buscarPorChave(codigo);
				} catch (NumberFormatException e) {
					// termo numerico maior que int (ex: CPF) - busca por CPF abaixo
				}
			}
			if (cliente == null) {
				cliente = clienteService.buscarPorCpf(termo);
			}

			if (cliente == null) {
				JOptionPane.showMessageDialog(this, "Cliente nao encontrado.",
						"Aviso", JOptionPane.WARNING_MESSAGE);
			} else {
				preencherFormulario(cliente);
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		tblClientes.clearSelection();
		txtCodigo.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtTelefone.setText("");
		txtEmail.setText("");
		txtDataNascimento.setText("");
		txtBusca.setText("");
	}
}
