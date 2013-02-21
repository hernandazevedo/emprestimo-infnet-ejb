import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Test;

import servicos.Emprestimo;
import servicos.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import dominio.dto.ContratoEmprestimoDTO;


public class EmprestimoTest {

	
	private InitialContext initialContext;
	
	private String url = "emprestimo-infnet/emprestimo-infnet-ejb/EmprestimoBean!servicos.Emprestimo";
	
	public EmprestimoTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void emprestimoOK(){
		MensagemRetornoBeanWS retorno = null;
		 try {
			 		
//			initialContext = configuraContext();
			 
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
		    retorno  = remote.solicitarEmprestimo(new ContratoEmprestimoDTO());
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertEquals(EnumMensagemRetorno.OK.getCodigo(), retorno.getCodigo());
	}
	
	private static InitialContext configuraContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
		props.put(Context.PROVIDER_URL, "remote://localhost:4447");
		props.put(Context.SECURITY_PRINCIPAL, "usuarioRemoto");
		props.put(Context.SECURITY_CREDENTIALS, "infnet123");
		//props.put(Context.SECURITY_PRINCIPAL, "");
		//props.put(Context.SECURITY_CREDENTIALS, "");
		props.put("jboss.naming.client.ejb.context", true);
		InitialContext initialContext = new InitialContext(props);
		return initialContext;
	}


}
