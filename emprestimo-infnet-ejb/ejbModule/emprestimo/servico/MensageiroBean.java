package emprestimo.servico;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import emprestimo.util.XStreamUtil;

import servicos.interfaces.Mensageiro;

/**
 * Session Bean implementation class MensageiroBean
 */
@Stateless
@Remote(Mensageiro.class)
public class MensageiroBean implements  Mensageiro{

    /**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:/ConnectionFactory")
	private static ConnectionFactory factory;
	
	@Resource(mappedName = "java:/jms/queue/filaTeste")
	private  Queue queue;
		
	/**
     * Default constructor. 
     */
    public MensageiroBean() {
        // TODO Auto-generated constructor stub
    }

    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private TextMessage message;
    private ObjectMessage objMessage;
    
    @PostConstruct
    public void metodoEntrada(){
    	try {
			connection = factory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	/**
     * @see Mensageiro#enviarMensagemTextoParaFila(String)
     */
    public void enviarMensagemTextoParaFila(String mensagem) {
        
    	try {
    		System.out.println("Chegou mensagem no SB, repassando para Fila");
			message = session.createTextMessage("SB: "+mensagem);
			producer.send(message);			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * @see Mensageiro#enviarMensagemTextoParaFila(String)
     */
    public void enviarMensagemObjetoParaFila(Serializable object) {
        
    	try {
    		System.out.println("Enviando objeto para fila "+XStreamUtil.getIntance().toXml(object));
    		objMessage = session.createObjectMessage(object);
			producer.send(objMessage);			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
    }
    
    @PreDestroy
    public void encerraConcexao(){
    	try {
			session.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
