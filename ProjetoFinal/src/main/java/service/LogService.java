package service;

import enums.TipoLog;
import util.ArquivoUtil;
import util.SessaoUsuario;

public class LogService {

	public void registrar(TipoLog acao, String status, String descricao) {

		try {

			String linha = String.format("[%s] [%s] [%s] [%s] %s",
					ArquivoUtil.formatarDataHoraAtual(),
					SessaoUsuario.getUsuarioLogado(),
					acao.name(),
					status,
					descricao);

			ArquivoUtil.gravarLinha(linha);

		} catch (Exception e) {
			System.err.println("Erro ao gravar log: " + e.getMessage());
		}
	}

	public void registrarErro(String descricao) {
		registrar(TipoLog.ERRO, "FALHA", descricao);
	}
}
