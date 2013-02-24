import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Test;

import servicos.interfaces.Empregado;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;


public class EmpregadoTest {

	
	private InitialContext initialContext;
	
	private String url = "emprestimo-infnet/emprestimo-infnet-ejb/EmpregadoBean!servicos.interfaces.Empregado";
	
	public EmpregadoTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void consultarHistoricoRelacionamentoOK(){
		List<ContratoEmprestimoDTO> retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Empregado remote = (Empregado) initialContext.lookup(url);
			
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			EmpregadoDTO empregadoRequerente = new EmpregadoDTO();
			
		    retorno  = remote.consultarHistoricoRelacionamento(empregadoRequerente);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertTrue(!retorno.isEmpty());
	}
	
	@Test
	public void consultarHistoricoRelacionamentoFalhaRegraNegocioUM(){
		
		String msgExeption = null;
		 try {
		 		
			 
				initialContext = new InitialContext();
				 
				Empregado remote = (Empregado) initialContext.lookup(url);
				
				//TODO setar os dados de modo que os mocks retornem o resultado esperado.
				EmpregadoDTO empregadoRequerente = new EmpregadoDTO();
				
			    remote.consultarHistoricoRelacionamento(empregadoRequerente);
				
			} catch (NamingException e) {
				e.printStackTrace();
			} catch(Exception e){
				msgExeption = e.getMessage();
				e.printStackTrace();
			}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("Cliente não possui cadastro ativo no sistema", msgExeption);
	}
	
	
//	private static InitialContext configuraContext() throws NamingException {
//		Properties props = new Properties();
//		props.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
//		props.put(Context.PROVIDER_URL, "remote://localhost:4447");
//		props.put(Context.SECURITY_PRINCIPAL, "usuarioRemoto");
//		props.put(Context.SECURITY_CREDENTIALS, "infnet123");
//		//props.put(Context.SECURITY_PRINCIPAL, "");
//		//props.put(Context.SECURITY_CREDENTIALS, "");
//		props.put("jboss.naming.client.ejb.context", true);
//		InitialContext initialContext = new InitialContext(props);
//		return initialContext;
//	}


}
