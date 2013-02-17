package servicos.enums;

public enum EnumMensagemRetorno {

	
	OK(0,"Sucesso"),
	NOK(1,"ERRO");
	
	
	private Integer codigo;
	private String mensagem;
	
	EnumMensagemRetorno(Integer codigo,String mensagem){
		
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	
}
