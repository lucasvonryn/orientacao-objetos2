package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dto.AlunoDTO;
import dto.CursoDTO;
import service.AlunoService;
import service.CursoService;

public class AlunoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRegistroAcademico;
	private JTextField txtNome;
	
	private JRadioButton rbNaoInformar;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	
	private JFormattedTextField txtDataIngresso;
	private JSpinner spPeriodo;
	private JTextField txtCoeficiente;
	private JTable tblAlunos;
	private JComboBox<CursoDTO> cbCurso;
	
	private MaskFormatter mascaraData;
	private ButtonGroup bgSexo;
	
	private CursoService cursoService;
	private AlunoService alunoService;
	
	public AlunoWindow() {		
		this.criarMascaraData();
		this.inicializarComponentes();
		
		this.cursoService = new CursoService();
		this.alunoService = new AlunoService();
		
		this.buscarCursos();
		this.buscarAlunos();
		this.limparComponentes();
	}
	
	private void limparComponentes() {
		
		this.txtRegistroAcademico.setText("");
		this.txtNome.setText("");
		this.rbNaoInformar.setSelected(true);
		this.cbCurso.setSelectedIndex(0);
		this.txtDataIngresso.setText("");
		this.spPeriodo.setValue(1);
		this.txtCoeficiente.setText("");
	}
	
	private void buscarCursos() {
		
		try {
			
			List<CursoDTO> listaCursos = this.cursoService.buscarTodos();
			
			for (CursoDTO cursoDTO : listaCursos) {
				this.cbCurso.addItem(cursoDTO);
			}
		} catch (SQLException | IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void buscarAlunos() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			List<AlunoDTO> listaAlunos = this.alunoService.buscarTodos();
			
			DefaultTableModel modelo = (DefaultTableModel) tblAlunos.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
			
			for (AlunoDTO alunoDTO : listaAlunos) {
				modelo.addRow(new Object[] {
						alunoDTO.getRegistroAcademico(),
						alunoDTO.getNome(),
						alunoDTO.getSexo(),
						alunoDTO.getCursoDTO().getNome(),
						sdf.format(alunoDTO.getDataIngresso()),
						alunoDTO.getPeriodo(),
						alunoDTO.getCoeficiente()
				});
			}
		} catch (SQLException | IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void criarMascaraData() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void inicializarComponentes() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// MENU
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 591, 22);
		contentPane.add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarAplicacao();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirJanelaSobre();
			}
		});
		mnAjuda.add(mntmSobre);
		
		// NOME
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 59, 37, 16);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(59, 54, 526, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		// REGISTRO ACADEMICO
		JLabel lblRegistroAcademico = new JLabel("Registro Acadêmico");
		lblRegistroAcademico.setBounds(10, 34, 125, 16);
		contentPane.add(lblRegistroAcademico);
		
		txtRegistroAcademico = new JTextField();
		txtRegistroAcademico.setBounds(147, 29, 131, 26);
		contentPane.add(txtRegistroAcademico);
		txtRegistroAcademico.setColumns(10);
		
		// SEXO
		JPanel pSexo = new JPanel();
		pSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSexo.setBounds(10, 87, 209, 119);
		contentPane.add(pSexo);
		pSexo.setLayout(null);
		
		this.rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(9, 20, 90, 23);
		pSexo.add(rbFeminino);
		
		this.rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(9, 49, 96, 23);
		pSexo.add(rbMasculino);
		
		this.rbNaoInformar = new JRadioButton("Não Informar");
		rbNaoInformar.setBounds(9, 76, 115, 23);
		pSexo.add(rbNaoInformar);
		
		// criar o grupo de botoes
		this.bgSexo = new ButtonGroup();
		this.bgSexo.add(this.rbNaoInformar);
		this.bgSexo.add(this.rbMasculino);
		this.bgSexo.add(this.rbFeminino);		
		
		// CURSO
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(231, 92, 37, 16);
		contentPane.add(lblCurso);
		
		cbCurso = new JComboBox<>();
		cbCurso.setBounds(280, 88, 305, 27);
		contentPane.add(cbCurso);
		
		// DATA INGRESSO
		JLabel lblDataIngresso = new JLabel("Data de Ingresso");
		lblDataIngresso.setBounds(231, 131, 106, 16);
		contentPane.add(lblDataIngresso);
		
		this.txtDataIngresso = new JFormattedTextField(this.mascaraData);
		txtDataIngresso.setBounds(349, 126, 95, 26);
		contentPane.add(txtDataIngresso);
		
		// PERIODO
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(461, 131, 47, 16);
		contentPane.add(lblPeriodo);
		
		this.spPeriodo = new JSpinner();
		spPeriodo.setModel(new SpinnerNumberModel(1, 1, 10, 1)); // valor de inicio, valor minimo, valor maximo, incremento
		spPeriodo.setBounds(520, 126, 65, 26);
		contentPane.add(spPeriodo);
		
		// COEFICIENTE
		JLabel lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setBounds(231, 179, 71, 16);
		contentPane.add(lblCoeficiente);
		
		txtCoeficiente = new JTextField();
		txtCoeficiente.setBounds(314, 174, 130, 26);
		contentPane.add(txtCoeficiente);
		txtCoeficiente.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 207, 575, 12);
		contentPane.add(separator);
		
		// BOTOES
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarAluno();
			}
		});
		btnCadastrar.setBounds(10, 216, 117, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparComponentes();
			}
		});
		btnLimparCampos.setBounds(429, 216, 156, 29);
		contentPane.add(btnLimparCampos);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarAluno();
			}
		});
		btnAtualizar.setBounds(128, 216, 117, 29);
		contentPane.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAluno();
			}
		});
		btnExcluir.setBounds(241, 216, 117, 29);
		contentPane.add(btnExcluir);
		
		// TABELA ALUNOS
		JPanel pAlunos = new JPanel();
		pAlunos.setBorder(new TitledBorder(null, "Alunos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAlunos.setBounds(10, 247, 575, 169);
		contentPane.add(pAlunos);
		pAlunos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 19, 563, 144);
		pAlunos.add(scrollPane);
		
		tblAlunos = new JTable();
		tblAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"RA", "Nome", "Sexo", "Curso", "Data de Ingresso", "Período", "Coeficiente"
			}
		));
		scrollPane.setViewportView(tblAlunos);
	}	

	private String verificarSexoSelecionado() {
		if (this.rbMasculino.isSelected()) {
			return this.rbMasculino.getText().trim();
		} else if (this.rbFeminino.isSelected()) {
			return this.rbFeminino.getText().trim();
		} else {
			return this.rbNaoInformar.getText().trim();
		}
	}
	
	private void cadastrarAluno() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			AlunoDTO alunoDTO = new AlunoDTO();
			
			alunoDTO.setRegistroAcademico(Integer.parseInt(this.txtRegistroAcademico.getText().trim()));
			alunoDTO.setNome(this.txtNome.getText().trim());
			alunoDTO.setSexo(this.verificarSexoSelecionado());
			alunoDTO.setCursoDTO((CursoDTO) this.cbCurso.getSelectedItem());
			alunoDTO.setDataIngresso(new java.sql.Date(sdf.parse(this.txtDataIngresso.getText()).getTime()));
			alunoDTO.setPeriodo(Integer.parseInt(this.spPeriodo.getValue().toString()));
			alunoDTO.setCoeficiente(Double.parseDouble(this.txtCoeficiente.getText().trim().replace(',', '.')));
			
			int resultado = this.alunoService.cadastrar(alunoDTO);
			
			if (resultado > 0) {
				System.out.println("Cadastro realizado com sucesso.");
			} else {
				System.out.println("Não foi possível cadastrar um novo aluno.");
			}
		} catch (SQLException | IOException | ParseException e) {
			System.err.println(e.getMessage());
		} finally {
			this.buscarAlunos();
			this.limparComponentes();
		}
	}
	
	private void atualizarAluno() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			AlunoDTO alunoDTO = new AlunoDTO();
			
			alunoDTO.setRegistroAcademico(Integer.parseInt(this.txtRegistroAcademico.getText().trim()));
			alunoDTO.setNome(this.txtNome.getText().trim());
			alunoDTO.setSexo(this.verificarSexoSelecionado());
			alunoDTO.setCursoDTO((CursoDTO) this.cbCurso.getSelectedItem());
			alunoDTO.setDataIngresso(new java.sql.Date(sdf.parse(this.txtDataIngresso.getText()).getTime()));
			alunoDTO.setPeriodo(Integer.parseInt(this.spPeriodo.getValue().toString()));
			alunoDTO.setCoeficiente(Double.parseDouble(this.txtCoeficiente.getText().trim().replace(',', '.')));
			
			int resultado = this.alunoService.atualizar(alunoDTO);
			
			if (resultado > 0) {
				System.out.println("Cadastro atualizado com sucesso.");
			} else {
				System.out.println("Não foi possível atualizar o registro do aluno.");
			}
		} catch (SQLException | IOException | ParseException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			this.buscarAlunos();
		}
	}
	
	private void excluirAluno() {
		try {
			int resultado = this.alunoService.excluir(Integer.parseInt(this.txtRegistroAcademico.getText()));
			
			if (resultado > 0) {
				System.out.println("Cadastro excuído com sucesso.");
			} else {
				System.out.println("Não foi possível excluir um aluno.");
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			this.buscarAlunos();
		}
	}
	
	private void finalizarAplicacao() {
		System.exit(0);
	}
	
	private void abrirJanelaSobre() {
		SobreWindow janelaSobre = new SobreWindow(this);
		janelaSobre.setVisible(true);
		
		this.setVisible(false);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoWindow frame = new AlunoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
