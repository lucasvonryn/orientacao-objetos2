package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import threads.MonitorReservasThread;
import threads.RelogioThread;
import util.SessaoUsuario;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRelogio;
	private JLabel lblUsuario;

	private RelogioThread relogioThread;
	private MonitorReservasThread monitorReservasThread;

	public MainWindow() {
		solicitarUsuario();
		inicializarComponentes();
		iniciarThreads();
	}

	private void solicitarUsuario() {

		String usuario = JOptionPane.showInputDialog(null, "Informe o nome do usuario logado:",
				"Login", JOptionPane.QUESTION_MESSAGE);

		if (usuario == null) {
			usuario = "Atendente";
		}

		SessaoUsuario.setUsuarioLogado(usuario);
	}

	private void inicializarComponentes() {

		setTitle("Sistema de Gerenciamento de Hotel/Pousada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Hotel/Pousada - Menu Principal");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitulo.setBounds(140, 20, 320, 30);
		contentPane.add(lblTitulo);

		lblRelogio = new JLabel("Data/Hora: --/--/---- --:--:--");
		lblRelogio.setBounds(20, 60, 350, 20);
		contentPane.add(lblRelogio);

		lblUsuario = new JLabel("Usuario: " + SessaoUsuario.getUsuarioLogado());
		lblUsuario.setBounds(20, 85, 350, 20);
		contentPane.add(lblUsuario);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);

		JMenuItem itemClientes = new JMenuItem("Clientes");
		itemClientes.addActionListener(e -> abrirJanela(new ClienteWindow()));
		menuCadastros.add(itemClientes);

		JMenuItem itemQuartos = new JMenuItem("Quartos");
		itemQuartos.addActionListener(e -> abrirJanela(new QuartoWindow()));
		menuCadastros.add(itemQuartos);

		JMenu menuOperacoes = new JMenu("Operacoes");
		menuBar.add(menuOperacoes);

		JMenuItem itemReservas = new JMenuItem("Reservas");
		itemReservas.addActionListener(e -> abrirJanela(new ReservaWindow()));
		menuOperacoes.add(itemReservas);

		JMenuItem itemHospedagem = new JMenuItem("Hospedagem");
		itemHospedagem.addActionListener(e -> abrirJanela(new HospedagemWindow()));
		menuOperacoes.add(itemHospedagem);

		JMenuItem itemPagamentos = new JMenuItem("Pagamentos");
		itemPagamentos.addActionListener(e -> abrirJanela(new PagamentoWindow()));
		menuOperacoes.add(itemPagamentos);

		JMenu menuRelatorios = new JMenu("Relatorios");
		menuBar.add(menuRelatorios);

		JMenuItem itemRelatorio = new JMenuItem("Relatorio de Hospedagens");
		itemRelatorio.addActionListener(e -> abrirJanela(new RelatorioWindow()));
		menuRelatorios.add(itemRelatorio);

		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);

		JMenuItem itemSair = new JMenuItem("Sair");
		itemSair.addActionListener(e -> finalizarAplicacao());
		menuSistema.add(itemSair);

		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				finalizarAplicacao();
			}
		});
	}

	private void abrirJanela(JFrame janela) {
		janela.setVisible(true);
	}

	private void iniciarThreads() {
		relogioThread = new RelogioThread(lblRelogio);
		relogioThread.start();

		monitorReservasThread = new MonitorReservasThread();
		monitorReservasThread.start();
	}

	private void finalizarAplicacao() {

		if (relogioThread != null) {
			relogioThread.parar();
		}
		if (monitorReservasThread != null) {
			monitorReservasThread.parar();
		}

		System.exit(0);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao iniciar aplicacao: " + e.getMessage(),
							"Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
