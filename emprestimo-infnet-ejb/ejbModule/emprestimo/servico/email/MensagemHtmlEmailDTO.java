package emprestimo.servico.email;

import java.io.Serializable;

public class MensagemHtmlEmailDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6890529102566435978L;
	
	private String nome;
	private String email;
	private String assunto;
	private String mensagem;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
