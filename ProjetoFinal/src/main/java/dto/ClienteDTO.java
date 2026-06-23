package dto;

import java.sql.Date;

public class ClienteDTO {

	private Integer codigo;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Date dataNascimento;

	public ClienteDTO() {
	}

	public ClienteDTO(Integer codigo, String nome, String cpf, String telefone, String email, Date dataNascimento) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		if (codigo != null) {
			return codigo + " - " + nome;
		}
		return nome;
	}
}
