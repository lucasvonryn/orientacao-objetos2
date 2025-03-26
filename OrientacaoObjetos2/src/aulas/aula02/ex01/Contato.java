package aulas.aula02.ex01;

public class Contato {

	public String nome;
	public String sobrenome;
	public String numeroTelefone;
	public String dataAniversario;
	public String nomeCompleto;
	
	public Contato(String nome, String sobrenome, String numeroTelefone, String dataAniversario) {

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroTelefone = numeroTelefone;
		this.dataAniversario = dataAniversario;
		this.nomeCompleto = this.nome + ' ' + this.sobrenome;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", sobrenome=" + sobrenome + ", numeroTelefone=" + numeroTelefone
				+ ", dataAniversario=" + dataAniversario + ", nomeCompleto=" + nomeCompleto + "]";
	}
}
