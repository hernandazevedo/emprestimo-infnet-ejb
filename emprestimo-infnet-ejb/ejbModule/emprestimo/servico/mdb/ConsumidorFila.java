package emprestimo.servico.mdb;


import java.net.MalformedURLException;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.commons.mail.EmailException;

import emprestimo.servico.email.CommonsMail;
import emprestimo.servico.email.MensagemHtmlEmailDTO;
import emprestimo.util.XStreamUtil;

/**
 * Message-Driven Bean implementation class for: ConsumidorTest
 *
 */

@MessageDriven( activationConfig = {
		@ActivationConfigProperty(propertyName="destination", propertyValue="jms/queue/filaTeste")
})	 
public class ConsumidorFila implements MessageListener {

    /**
     * Default constructor. 
     */
    public ConsumidorFila() {
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
      try {
    	if( message instanceof TextMessage ){
    		TextMessage txtMsg = (TextMessage) message;
    		System.out.println("(Consumidor 1) Chegou mensagem na fila: "+ txtMsg.getText());
    	}else if ( message instanceof ObjectMessage ){
    		ObjectMessage objectMessage = (ObjectMessage) message;
    		MensagemHtmlEmailDTO email = (MensagemHtmlEmailDTO) objectMessage.getObject();
    		System.out.println("Recebendo mensagem para enviar email: "+XStreamUtil.getIntance().toXml(email));
    		CommonsMail commons;
			try {
				commons = new CommonsMail();
				commons.enviaEmailFormatoHtml(email);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (EmailException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    	}
    	
		
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        
    }

}
