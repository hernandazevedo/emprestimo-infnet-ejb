package servicos.enums;

public enum EnumStatusAnalise {

	
	/*
	 * Status e Descricao que devem ser mostradas para o cliente
	 * na busca do historico de relacionamento com a ATIVA. 
	 */
	PENDENTE_ANALISE(0,"Análise"),
	ANALISADA(1,"Pré-Aprovada"),
	
	REJEITADA(2,"Rejeitada"),
	APROVADA(3,"Aprovada"),
	REPROVADA(4,"Reprovada");
	
	
	private Integer statusAnalise;
	private String descricaoAnalise;
	
	EnumStatusAnalise(Integer statusAnalise,String descricaoAnalise){
		
		this.statusAnalise = statusAnalise;
		this.descricaoAnalise = descricaoAnalise;
	}

	public Integer getStatusAnalise() {
		return statusAnalise;
	}

	public String getDescricaoAnalise() {
		return descricaoAnalise;
	}
	
}
