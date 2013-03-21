package emprestimo.servico.email;

import java.io.Serializable;

public class ConfiguracoesEmail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer smtpPort = 465;
	private Boolean debug = true;
	private String smtpHost = "smtp.gmail.com";
	private String to;
	private String nameTo;
	private String charSet = "UTF-8";
	private Boolean tls = false;
	private Boolean ssl = true;
	private String authLogin = "hernand.azevedo@gmail.com";
	private String authPassword = "20092305150";
	private String style = "font-family: Arial,Helvetica,sans-serif; font-size: 12px;";
	private String mensagem = "Mensagem autmática";
	
	
	public Integer getSmtpPort() {
		return smtpPort;
	}
	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}
	public Boolean getDebug() {
		return debug;
	}
	public void setDebug(Boolean debug) {
		this.debug = debug;
	}
	public String getSmtpHost() {
		return smtpHost;
	}
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getNameTo() {
		return nameTo;
	}
	public void setNameTo(String nameTo) {
		this.nameTo = nameTo;
	}
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	public Boolean isTls() {
		return tls;
	}
	public void setTls(Boolean tls) {
		this.tls = tls;
	}
	public Boolean isSsl() {
		return ssl;
	}
	public void setSsl(Boolean ssl) {
		this.ssl = ssl;
	}
	public String getAuthLogin() {
		return authLogin;
	}
	public void setAuthLogin(String authLogin) {
		this.authLogin = authLogin;
	}
	public String getAuthPassword() {
		return authPassword;
	}
	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
