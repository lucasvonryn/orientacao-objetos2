package threads;

import service.LogService;
import service.ReservaService;

public class MonitorReservasThread extends Thread {

	private volatile boolean executando = true;
	private final ReservaService reservaService = new ReservaService();
	private final LogService logService = new LogService();

	public MonitorReservasThread() {
		setDaemon(true);
	}

	@Override
	public void run() {

		while (executando) {

			try {
				int total = reservaService.processarReservasExpiradas();
				if (total > 0) {
					logService.registrar(enums.TipoLog.CANCELAMENTO, "SUCESSO",
							total + " reserva(s) expirada(s) processada(s) automaticamente");
				}
			} catch (Exception e) {
				logService.registrarErro("Erro no monitoramento de reservas: " + e.getMessage());
			}

			try {
				Thread.sleep(60000);
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
