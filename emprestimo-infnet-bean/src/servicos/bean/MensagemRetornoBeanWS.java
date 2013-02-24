package servicos.bean;

import java.io.Serializable;

import servicos.enums.EnumMensagemRetorno;

public class MensagemRetornoBeanWS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7310818013634444422L;
	
	public MensagemRetornoBeanWS(EnumMensagemRetorno enumMensagemRetorno){
		this.codigo = enumMensagemRetorno.getCodigo();
		this.mensagem = enumMensagemRetorno.getMensagem();
	}

	private Integer codigo;
	
	private String mensagem;

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
