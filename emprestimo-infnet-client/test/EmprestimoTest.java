import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Test;

import servicos.bean.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import servicos.interfaces.Emprestimo;
import dominio.dto.ContratoEmprestimoDTO;


public class EmprestimoTest {

	
	private InitialContext initialContext;
	
	private String url = "emprestimo-infnet/emprestimo-infnet-ejb/EmprestimoBean!servicos.interfaces.Emprestimo";
	
	public EmprestimoTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void solicitarEmprestimoOK(){
		MensagemRetornoBeanWS retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
			
		    retorno  = remote.solicitarEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertEquals(EnumMensagemRetorno.OK.getCodigo(), retorno.getCodigo());
	}
	
	@Test
	public void solicitarEmprestimoFalhaRegraNegocioUM(){
		
		String msgExeption = null;
		 try {
			 
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
		    remote.solicitarEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("Cliente não possui cadastro ativo no sistema", msgExeption);
	}
	
	@Test
	public void solicitarEmprestimoFalhaRegraNegocioDOIS(){
		
		String msgExeption = null;
		 try {
			 		
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
		    remote.solicitarEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("Cliente não pode solicitar um novo empréstimo, possui emprestimo ativo na instituição", msgExeption);
	}
	
	@Test
	public void solicitarRefinanciamentoEmprestimoOK(){
		MensagemRetornoBeanWS retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
			
		    retorno  = remote.solicitarRefinanciamentoEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertEquals(EnumMensagemRetorno.OK.getCodigo(), retorno.getCodigo());
	}
	
	@Test
	public void solicitarRefinanciamentoEmprestimoFalhaRegraNegocioUM(){
		
		String msgExeption = null;
		 try {
			 
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
		    remote.solicitarRefinanciamentoEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("Cliente não pode solicitar um novo refinanciamento, não possui emprestimos ativos", msgExeption);
	}
	
	@Test
	public void solicitarRefinanciamentoEmprestimoFalhaRegraNegocioDOIS(){
		
		String msgExeption = null;
		 try {
			 		
			initialContext = new InitialContext();
			 
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
			
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
		    remote.solicitarRefinanciamentoEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("O emprestimo não está habilitado para refinanciamento", msgExeption);
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
