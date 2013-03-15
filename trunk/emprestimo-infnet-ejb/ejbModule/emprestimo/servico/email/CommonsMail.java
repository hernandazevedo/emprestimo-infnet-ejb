package emprestimo.servico.email;

import java.net.MalformedURLException;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import emprestimo.util.Util;
public class CommonsMail {
	  
    private static ConfiguracoesEmail configInstance = new ConfiguracoesEmail();
	public CommonsMail()  {
//		if(configInstance == null){
//			lookUpEmailConfig();
//		}
	}
	
//	private void lookUpEmailConfig() throws NamingException {
//		System.out.println("Buscando configuracoes de email no enviroment");
//		configInstance = new ConfiguracoesEmail();
//		InitialContext ctx = new InitialContext();
//		Context envContext = (Context) ctx.lookup("java:/comp/env");
//		 configInstance.setSmtpPort((Integer)doLookup(envContext,"email/smtpPort"));
//		 configInstance.setDebug((Boolean)doLookup(envContext,"email/debug"));
//		 configInstance.setSmtpHost((String)doLookup(envContext,"email/smtpHost"));
//		 configInstance.setTo((String)doLookup(envContext,"email/to"));
//		 configInstance.setNameTo((String)doLookup(envContext,"email/nameTo"));
//		 configInstance.setCharSet((String)doLookup(envContext,"email/charSet"));
//		 configInstance.setSsl((Boolean)doLookup(envContext,"email/ssl"));
//		 configInstance.setTls((Boolean)doLookup(envContext,"email/tls"));
//		 configInstance.setAuthLogin((String)doLookup(envContext,"email/authLogin"));
//		 configInstance.setAuthPassword((String)doLookup(envContext,"email/authPassword"));
//		 configInstance.setStyle((String)doLookup(envContext,"email/style"));
//		 configInstance.setMensagem((String)doLookup(envContext,"email/mensagem"));
//		 System.out.println("Configuracoes: "+XStreamUtil.getIntance().toXml(configInstance));
//	}
	
//	private Object doLookup(Context envContext,String name){
//		try{
//			return envContext.lookup(name);
//		}catch(Exception e){
//			System.out.println("Variavel "+name+" nao encontrada no enviroment");
//		}
//		
//		return null;
//	}

	/**
	* Envia email no formato HTML
	* @throws EmailException
	* @throws MalformedURLException
	*/
	@SuppressWarnings("deprecation")
	public void enviaEmailFormatoHtml(MensagemHtmlEmailDTO dto) throws EmailException, MalformedURLException {
		
		
		 StringBuilder sb = new StringBuilder();
		 
		if (!Util.isEmptyOrNull(configInstance.getStyle())) {
			sb.append("<span style=\"" + configInstance.getStyle() + "\">");
		} else {
			sb.append("<span>");
		}
		
		sb.append("<h3>").append(configInstance.getMensagem()).append("</h3>");
		sb.append("<hr/>");
		sb.append("<br />");
		sb.append("<b>Nome: </b>").append(dto.getNome()).append("<br />");
		sb.append("<b>Assunto: </b>").append(dto.getAssunto()).append("<br />");
		sb.append("<b>Email: </b>").append(dto.getEmail()).append("<br />");
		sb.append("<hr/>");
		sb.append("<br />");
		sb.append(dto.getMensagem());
		sb.append("<hr/>");
		sb.append("</span>");
		
		
		HtmlEmail email = new HtmlEmail();
		// configura a mensagem
		email.setSmtpPort(configInstance.getSmtpPort());
		email.setDebug(configInstance.getDebug());
		email.setHostName(configInstance.getSmtpHost());
		email.addTo(dto.getEmail(), dto.getNome()); // destinatário
		email.setCharset(configInstance.getCharSet());
		email.setTLS(configInstance.isTls());
		email.setSSL(configInstance.isSsl());

		if (!Util.isEmptyOrNull(configInstance.getAuthLogin())
				&& !Util.isEmptyOrNull(configInstance.getAuthPassword()))
			email.setAuthentication(configInstance.getAuthLogin(),
					configInstance.getAuthPassword());

		// Dados
		email.setFrom("noreply@email.com", "Mensageiro");
		email.setSubject(dto.getAssunto()); // assunto do e-mail
		email.setMsg(sb.toString());// Conteudo

		email.send();  
		
	}
	
}
