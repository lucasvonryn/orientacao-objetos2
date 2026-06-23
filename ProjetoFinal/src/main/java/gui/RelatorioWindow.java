package gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dto.HospedagemDTO;
import service.RelatorioService;

public class RelatorioWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblResumo;
	private JTable tblHospedagens;

	private RelatorioService relatorioService;
	private SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public RelatorioWindow() {
		relatorioService = new RelatorioService();
		inicializarComponentes();
		carregarRelatorio();
	}

	private void inicializarComponentes() {

		setTitle("Relatorio de Hospedagens");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 520);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelResumo = new JPanel();
		panelResumo.setBorder(new TitledBorder("Resumo"));
		panelResumo.setBounds(10, 10, 860, 80);
		panelResumo.setLayout(null);
		contentPane.add(panelResumo);

		lblResumo = new JLabel("Carregando...");
		lblResumo.setBounds(10, 25, 840, 40);
		panelResumo.add(lblResumo);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(10, 100, 120, 25);
		btnAtualizar.addActionListener(e -> carregarRelatorio());
		contentPane.add(btnAtualizar);

		JButton btnExportar = new JButton("Exportar XLS");
		btnExportar.setBounds(140, 100, 150, 25);
		btnExportar.addActionListener(e -> exportar());
		contentPane.add(btnExportar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 860, 340);
		contentPane.add(scrollPane);

		tblHospedagens = new JTable();
		tblHospedagens.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "Codigo", "Hospede", "Quarto", "Check-in", "Check-out", "Diarias", "Valor", "Status" }));
		scrollPane.setViewportView(tblHospedagens);
	}

	private void carregarRelatorio() {
		try {
			List<HospedagemDTO> hospedagens = relatorioService.buscarHospedagens();
			double totalArrecadado = relatorioService.buscarTotalArrecadado();
			int quartosOcupados = relatorioService.contarQuartosOcupados(hospedagens);
			Map<Integer, Double> faturamento = relatorioService.agruparFaturamentoPorQuarto(hospedagens);

			lblResumo.setText("<html>Hospedagens: " + hospedagens.size()
					+ " | Quartos ocupados: " + quartosOcupados
					+ " | Total arrecadado: R$ " + String.format("%.2f", totalArrecadado)
					+ " | Quartos com faturamento: " + faturamento.size() + "</html>");

			DefaultTableModel modelo = (DefaultTableModel) tblHospedagens.getModel();
			modelo.setRowCount(0);

			for (HospedagemDTO hospedagem : hospedagens) {
				modelo.addRow(new Object[] {
						hospedagem.getCodigo(),
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
			JOptionPane.showMessageDialog(this, "Erro ao carregar relatorio: " + e.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void exportar() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Salvar relatorio");
		fileChooser.setSelectedFile(new File("relatorio_hospedagens.xls"));

		int resultado = fileChooser.showSaveDialog(this);
		if (resultado != JFileChooser.APPROVE_OPTION) {
			return;
		}

		File arquivo = fileChooser.getSelectedFile();
		if (!arquivo.getName().toLowerCase().endsWith(".xls")) {
			arquivo = new File(arquivo.getAbsolutePath() + ".xls");
		}

		try {
			relatorioService.exportarRelatorio(arquivo);
			JOptionPane.showMessageDialog(this, "Relatorio exportado com sucesso!\n" + arquivo.getAbsolutePath(),
					"Sucesso", JOptionPane.INFORMATION_MESSAGE);

			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(arquivo);
			}
		} catch (SQLException | IOException e) {
			JOptionPane.showMessageDialog(this, "Erro ao exportar: " + e.getMessage(),
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
