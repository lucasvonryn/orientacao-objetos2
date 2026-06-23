package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArquivoUtil {

	private static final String DIRETORIO_LOGS = "logs";
	private static final String ARQUIVO_LOG = DIRETORIO_LOGS + "/sistema.log";
	private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void gravarLinha(String linha) throws IOException {

		File diretorio = new File(DIRETORIO_LOGS);
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_LOG, true))) {
			writer.write(linha);
			writer.newLine();
		}
	}

	public static String formatarDataHoraAtual() {
		return LocalDateTime.now().format(FORMATADOR);
	}

	public static String getCaminhoLog() {
		return ARQUIVO_LOG;
	}
}
