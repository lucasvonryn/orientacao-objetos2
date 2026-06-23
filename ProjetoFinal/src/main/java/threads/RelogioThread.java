package threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RelogioThread extends Thread {

	private final JLabel labelRelogio;
	private volatile boolean executando = true;
	private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public RelogioThread(JLabel labelRelogio) {
		this.labelRelogio = labelRelogio;
		setDaemon(true);
	}

	@Override
	public void run() {

		while (executando) {

			final String dataHora = LocalDateTime.now().format(FORMATADOR);

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					labelRelogio.setText("Data/Hora: " + dataHora);
				}
			});

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}

	public void parar() {
		executando = false;
		interrupt();
	}
}
