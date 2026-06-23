package gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import dto.QuartoDTO;
import enums.StatusQuarto;
import enums.TipoQuarto;
import service.QuartoService;

public class QuartoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNumero;
	private JComboBox<TipoQuarto> cbTipo;
	private JSpinner spCapacidade;
	private JTextField txtValorDiaria;
	private JComboBox<StatusQuarto> cbStatus;
	private JTextField txtBuscaNumero;
	private JComboBox<TipoQuarto> cbBuscaTipo;
	private JComboBox<StatusQuarto> cbBuscaStatus;
	private JTable tblQuartos;

	private QuartoService quartoService;

	public QuartoWindow() {
		quartoService = new QuartoService();
		inicializarComponentes();
		buscarQuartos();
		limparCampos();
	}

	private void inicializarComponentes() {

		setTitle("Cadastro de Quartos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 520);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelForm = new JPanel();
		panelForm.setBorder(new TitledBorder("Dados do Quarto"));
		panelForm.setBounds(10, 10, 760, 180);
		panelForm.setLayout(null);
		contentPane.add(panelForm);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 25, 60, 20);
		panelForm.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(70, 25, 80, 20);
		panelForm.add(txtCodigo);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(170, 25, 60, 20);
		panelForm.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(230, 25, 80, 20);
		panelForm.add(txtNumero);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(330, 25, 40, 20);
		panelForm.add(lblTipo);

		cbTipo = new JComboBox<>(TipoQuarto.values());
		cbTipo.setBounds(370, 25, 150, 20);
		panelForm.add(cbTipo);

		JLabel lblCapacidade = new JLabel("Capacidade:");
		lblCapacidade.setBounds(10, 55, 80, 20);
		panelForm.add(lblCapacidade);

		spCapacidade = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		spCapacidade.setBounds(90, 55, 60, 20);
		panelForm.add(spCapacidade);

		JLabel lblValor = new JLabel("Valor Diaria:");
		lblValor.setBounds(170, 55, 80, 20);
		panelForm.add(lblValor);

		txtValorDiaria = new JTextField();
		txtValorDiaria.setBounds(250, 55, 100, 20);
		panelForm.add(txtValorDiaria);

		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(370, 55, 50, 20);
		panelForm.add(lblStatus);

		cbStatus = new JComboBox<>(StatusQuarto.values());
		cbStatus.setBounds(420, 55, 150, 20);
		panelForm.add(cbStatus);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 100, 100, 25);
		btnCadastrar.addActionListener(e -> cadastrar());
		panelForm.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(120, 100, 100, 25);
		btnAtualizar.addActionListener(e -> atualizar());
		panelForm.add(btnAtualizar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(230, 100, 100, 25);
		btnExcluir.addActionListener(e -> excluir());
		panelForm.add(btnExcluir);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(340, 100, 100, 25);
		btnLimpar.addActionListener(e -> limparCampos());
		panelForm.add(btnLimpar);

		JPanel panelBusca = new JPanel();
		panelBusca.setBorder(new TitledBorder("Busca por Numero, Tipo ou Status"));
		panelBusca.setBounds(10, 200, 760, 70);
		panelBusca.setLayout(null);
		contentPane.add(panelBusca);

		txtBuscaNumero = new JTextField();
		txtBuscaNumero.setBounds(10, 30, 80, 20);
		panelBusca.add(txtBuscaNumero);

		cbBuscaTipo = new JComboBox<>();
		cbBuscaTipo.addItem(null);
		for (TipoQuarto tipo : TipoQuarto.values()) {
			cbBuscaTipo.addItem(tipo);
		}
		cbBuscaTipo.setBounds(100, 30, 150, 20);
		panelBusca.add(cbBuscaTipo);

		cbBuscaStatus = new JComboBox<>();
		cbBuscaStatus.addItem(null);
		for (StatusQuarto status : StatusQuarto.values()) {
			cbBuscaStatus.addItem(status);
		}
		cbBuscaStatus.setBounds(260, 30, 150, 20);
		panelBusca.add(cbBuscaStatus);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(420, 30, 100, 20);
		btnBuscar.addActionListener(e -> buscar());
		panelBusca.add(btnBuscar);

		JButton btnListarTodos = new JButton("Listar Todos");
		btnListarTodos.setBounds(530, 30, 120, 20);
		btnListarTodos.addActionListener(e -> buscarQuartos());
		panelBusca.add(btnListarTodos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 760, 190);
		contentPane.add(scrollPane);

		tblQuartos = new JTable();
		tblQuartos.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Codigo", "Numero", "Tipo", "Capacidade", "Valor Diaria", "Status" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tblQuartos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblQuartos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					preencherFormularioDaTabela();
				}
			}
		});
		scrollPane.setViewportView(tblQuartos);
	}

	private void preencherFormularioDaTabela() {

		int linha = tblQuartos.getSelectedRow();
		if (linha < 0) {
			return;
		}

		txtCodigo.setText(String.valueOf(tblQuartos.getValueAt(linha, 0)));
		txtNumero.setText(String.valueOf(tblQuartos.getValueAt(linha, 1)));
		cbTipo.setSelectedItem(tblQuartos.getValueAt(linha, 2));
		spCapacidade.setValue(tblQuartos.getValueAt(linha, 3));
		txtValorDiaria.setText(String.valueOf(tblQuartos.getValueAt(linha, 4)));
		cbStatus.setSelectedItem(tblQuartos.getValueAt(linha, 5));
	}

	private void buscarQuartos() {
		try {
			preencherTabela(quartoService.buscarTodos());
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void preencherTabela(List<QuartoDTO> quartos) {
		DefaultTableModel modelo = (DefaultTableModel) tblQuartos.getModel();
		modelo.setRowCount(0);

		for (QuartoDTO quarto : quartos) {
			modelo.addRow(new Object[] {
					quarto.getCodigo(),
					quarto.getNumero(),
					quarto.getTipo(),
					quarto.getCapacidadeMaxima(),
					quarto.getValorDiaria(),
					quarto.getStatus()
			});
		}

		if (quartos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nenhum quarto encontrado.",
					"Aviso", JOptionPane.WARNING_MESSAGE);
		}
	}

	private QuartoDTO montarQuartoDoFormulario() {
		QuartoDTO quarto = new QuartoDTO();
		if (!txtCodigo.getText().trim().isEmpty()) {
			quarto.setCodigo(Integer.parseInt(txtCodigo.getText().trim()));
		}
		quarto.setNumero(Integer.parseInt(txtNumero.getText().trim()));
		quarto.setTipo((TipoQuarto) cbTipo.getSelectedItem());
		quarto.setCapacidadeMaxima((Integer) spCapacidade.getValue());
		quarto.setValorDiaria(Double.parseDouble(txtValorDiaria.getText().trim().replace(",", ".")));
		quarto.setStatus((StatusQuarto) cbStatus.getSelectedItem());
		return quarto;
	}

	private void cadastrar() {
		try {
			QuartoDTO quarto = montarQuartoDoFormulario();
			String erro = quartoService.cadastrar(quarto);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Quarto cadastrado! Codigo: " + quarto.getCodigo(),
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				buscarQuartos();
				limparCampos();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Numero ou valor da diaria invalido.",
					"Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void atualizar() {
		try {
			QuartoDTO quarto = montarQuartoDoFormulario();
			String erro = quartoService.atualizar(quarto);
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Quarto atualizado com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				buscarQuartos();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Numero ou valor da diaria invalido.",
					"Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void excluir() {
		if (txtCodigo.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Selecione um quarto na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int confirmacao = JOptionPane.showConfirmDialog(this,
				"Deseja realmente excluir este quarto?", "Confirmacao", JOptionPane.YES_NO_OPTION);

		if (confirmacao != JOptionPane.YES_OPTION) {
			return;
		}

		try {
			String erro = quartoService.excluir(Integer.parseInt(txtCodigo.getText().trim()));
			if (erro != null) {
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Quarto excluido com sucesso!",
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				buscarQuartos();
				limparCampos();
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void buscar() {
		try {
			TipoQuarto tipo = (TipoQuarto) cbBuscaTipo.getSelectedItem();
			StatusQuarto status = (StatusQuarto) cbBuscaStatus.getSelectedItem();
			String numero = txtBuscaNumero.getText().trim();

			List<QuartoDTO> quartos = quartoService.buscar(
					numero.isEmpty() ? null : numero, tipo, status);
			preencherTabela(quartos);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Numero do quarto invalido.",
					"Erro", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void limparCampos() {
		tblQuartos.clearSelection();
		txtCodigo.setText("");
		txtNumero.setText("");
		cbTipo.setSelectedIndex(0);
		spCapacidade.setValue(1);
		txtValorDiaria.setText("");
		cbStatus.setSelectedItem(StatusQuarto.DISPONIVEL);
	}
}
