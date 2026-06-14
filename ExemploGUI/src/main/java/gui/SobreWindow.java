package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SobreWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private AlunoWindow alunoWindow;
	
	public SobreWindow() {
		
	}

	public SobreWindow(AlunoWindow alunoWindow) {
		this.alunoWindow = alunoWindow;
		this.inicializarComponentes();
	}
	
	private void fecharJanela() {
		this.dispose();
		this.alunoWindow.setVisible(true);
	}
	
	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Exemplo GUI");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(167, 73, 101, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fecharJanela();
			}
		});
		btnNewButton.setBounds(167, 120, 101, 29);
		contentPane.add(btnNewButton);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobreWindow frame = new SobreWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
