package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class AlunoGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRegistroAcademico;
	private JTextField txtNome;
	private JTextField txtCoeficiente;
	private JTable tblAlunos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlunoGUI frame = new AlunoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AlunoGUI() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 591, 22);
		contentPane.add(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		
		JLabel lblRegistroAcademico = new JLabel("Registro Acadêmico");
		lblRegistroAcademico.setBounds(10, 34, 125, 16);
		contentPane.add(lblRegistroAcademico);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 59, 37, 16);
		contentPane.add(lblNome);
		
		txtRegistroAcademico = new JTextField();
		txtRegistroAcademico.setBounds(147, 29, 131, 26);
		contentPane.add(txtRegistroAcademico);
		txtRegistroAcademico.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(59, 54, 526, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel pSexo = new JPanel();
		pSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSexo.setBounds(10, 87, 209, 119);
		contentPane.add(pSexo);
		pSexo.setLayout(null);
		
		JRadioButton rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setBounds(9, 20, 90, 23);
		pSexo.add(rbFeminino);
		
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setBounds(9, 49, 96, 23);
		pSexo.add(rbMasculino);
		
		JRadioButton rbNaoInformar = new JRadioButton("Não Informar");
		rbNaoInformar.setBounds(9, 76, 115, 23);
		pSexo.add(rbNaoInformar);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(231, 92, 37, 16);
		contentPane.add(lblCurso);
		
		JLabel lblDataIngresso = new JLabel("Data de Ingresso");
		lblDataIngresso.setBounds(231, 131, 106, 16);
		contentPane.add(lblDataIngresso);
		
		JLabel lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setBounds(231, 179, 71, 16);
		contentPane.add(lblCoeficiente);
		
		JComboBox cbCurso = new JComboBox();
		cbCurso.setBounds(280, 88, 305, 27);
		contentPane.add(cbCurso);
		
		JFormattedTextField txtDataIngresso = new JFormattedTextField();
		txtDataIngresso.setBounds(349, 126, 95, 26);
		contentPane.add(txtDataIngresso);
		
		JLabel lblPeriodo = new JLabel("Período");
		lblPeriodo.setBounds(461, 131, 47, 16);
		contentPane.add(lblPeriodo);
		
		JSpinner spPeriodo = new JSpinner();
		spPeriodo.setBounds(520, 126, 65, 26);
		contentPane.add(spPeriodo);
		
		txtCoeficiente = new JTextField();
		txtCoeficiente.setBounds(314, 174, 130, 26);
		contentPane.add(txtCoeficiente);
		txtCoeficiente.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 207, 575, 12);
		contentPane.add(separator);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(314, 216, 117, 29);
		contentPane.add(btnCadastrar);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.setBounds(429, 216, 156, 29);
		contentPane.add(btnLimparCampos);
		
		JPanel pAlunos = new JPanel();
		pAlunos.setBorder(new TitledBorder(null, "Alunos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pAlunos.setBounds(10, 247, 575, 169);
		contentPane.add(pAlunos);
		pAlunos.setLayout(null);
		
		tblAlunos = new JTable();
		tblAlunos.setBounds(6, 19, 563, 144);
		pAlunos.add(tblAlunos);

	}
}
