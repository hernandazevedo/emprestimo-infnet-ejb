package servicos.enums;

public enum EnumPerfilFuncionario {

	
	/*
	 * Status e Descricao que devem ser mostradas para o cliente
	 * na busca do historico de relacionamento com a ATIVA. 
	 */
	CORRETOR(0,"Corretor"),
	OPERADOR_CALLCENTER(1,"Operador de CallCenter"),
	SUPERVISOR_CALLCENTER(2,"Supervisor de CallCenter"),
	GERENTE(3,"Gerente"),
	FUNCIONARIO_BALCAO(4,"Funcionário Balcão");
	
	
	private Integer idPerfil;
	private String nomePerfil;
	
	EnumPerfilFuncionario(Integer idPerfil,String nomePerfil){
		
		this.idPerfil = idPerfil;
		this.nomePerfil = nomePerfil;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}
	
	public String getNomePerfil() {
		return nomePerfil;
	}
	
}
