package listas.lista05.ex01.gui;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import listas.lista05.ex01.service.CalculadoraService;

public class CalculadoraWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private CalculadoraService calculadoraService;
	
	private JLabel lblVisor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraWindow frame = new CalculadoraWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalculadoraWindow() {
		this.calculadoraService = new CalculadoraService();
	    this.inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 410);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(6, 6, 321, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// VISOR
		this.lblVisor = new JLabel("0");
		lblVisor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVisor.setBounds(10, 6, 300, 43);
		lblVisor.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		panel.add(lblVisor);
		
		// ACOES
		JButton btnMs = new JButton("MS");
		btnMs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.memoriaSalvar();
			}
		});
		btnMs.setBounds(6, 87, 80, 46);
		contentPane.add(btnMs);
		
		JButton btnMr = new JButton("MR");
		btnMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.memoriaRecuperar();
				atualizarVisor();
			}
		});
		btnMr.setBounds(87, 87, 80, 46);
		contentPane.add(btnMr);
		
		JButton btnMc = new JButton("MC");
		btnMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.memoriaLimpar();
			}
		});
		btnMc.setBounds(167, 87, 80, 46);
		contentPane.add(btnMc);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.limpar();
				atualizarVisor();
			}
		});
		btnC.setBounds(247, 87, 80, 46);
		contentPane.add(btnC);
		
		// OPERACOES
		JButton btnDivisao = new JButton("/");
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.definirOperador("/");
				atualizarVisor();
			}
		});
		btnDivisao.setBounds(247, 157, 80, 46);
		contentPane.add(btnDivisao);
		
		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.definirOperador("*");
				atualizarVisor();
			}
		});
		btnMultiplicacao.setBounds(247, 211, 80, 46);
		contentPane.add(btnMultiplicacao);
		
		JButton btnSubtracao = new JButton("-");
		btnSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.definirOperador("-");
				atualizarVisor();
			}
		});
		btnSubtracao.setBounds(247, 269, 80, 46);
		contentPane.add(btnSubtracao);
		
		JButton btnAdicao = new JButton("+");
		btnAdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.definirOperador("+");
				atualizarVisor();
			}
		});
		btnAdicao.setBounds(247, 325, 80, 46);
		contentPane.add(btnAdicao);

		// RESULTADO
		JButton btnResultado = new JButton("=");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.calcularResultado();
				atualizarVisor();
			}
		});
		btnResultado.setBounds(167, 325, 80, 46);
		contentPane.add(btnResultado);
		
		// DIGITOS
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("7");
			}
		});
		btn7.setBounds(6, 157, 80, 46);
		contentPane.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("8");
			}
		});
		btn8.setBounds(87, 157, 80, 46);
		contentPane.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("9");
			}
		});
		btn9.setBounds(167, 157, 80, 46);
		contentPane.add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("4");
			}
		});
		btn4.setBounds(6, 211, 80, 46);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("5");
			}
		});
		btn5.setBounds(87, 211, 80, 46);
		contentPane.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("6");
			}
		});
		btn6.setBounds(167, 211, 80, 46);
		contentPane.add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("1");
			}
		});
		btn1.setBounds(6, 269, 80, 46);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("2");
			}
		});
		btn2.setBounds(87, 269, 80, 46);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("3");
			}
		});
		btn3.setBounds(167, 269, 80, 46);
		contentPane.add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aoClicarDigito("0");
			}
		});
		btn0.setBounds(6, 327, 80, 46);
		contentPane.add(btn0);
		
		// VIRGULA
		JButton btnVirgula = new JButton(",");
		btnVirgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadoraService.adicionarVirgula();
				atualizarVisor();
			}
		});
		btnVirgula.setBounds(87, 327, 80, 46);
		contentPane.add(btnVirgula);
	}
	
	private void aoClicarDigito(String digito) {
	    calculadoraService.adicionarDigito(digito);
	    atualizarVisor();
	}
	
	private void atualizarVisor() {
	    this.lblVisor.setText(calculadoraService.getVisor());
	}
}
