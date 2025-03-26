package aulas.aula01.ex03;

public enum UnidadeFederativa {
	
	PR("Paraná", "Curitiba"),
	SC("Santa Catarina", "Florianópolis"),
	RS("Rio Grande do Sul", "Porto Alegre");
	
	private String nomeUnidadeFederativa;
	private String nomeCapital;
	
	private UnidadeFederativa(String nomeUnidadeFederativa, String nomeCapital) {
		
		this.nomeUnidadeFederativa = nomeUnidadeFederativa;
		this.nomeCapital = nomeCapital;
	}

	public String getNomeUnidadeFederativa() {
		return nomeUnidadeFederativa;
	}

	public String getNomeCapital() {
		return nomeCapital;
	}
}
