import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.jboss.logging.Logger;
import org.junit.Test;

import servicos.bean.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import servicos.enums.EnumStatusAnalise;
import servicos.interfaces.Emprestimo;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
import dominio.dto.InstituicaoFinanceiraDTO;
import dominio.dto.ParcelaEmprestimoDTO;
import dominio.dto.PlanoEmprestimoDTO;


public class EmprestimoTest {

	private Logger log = Logger.getLogger(EmprestimoTest.class);
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
			EmpregadoDTO e = new EmpregadoDTO(113, "Hernand solicitarEmprestimoOK", true);
			e.setCpf("64675653715");
			
			contrato.setEmpregado(e);
			InstituicaoFinanceiraDTO i = new InstituicaoFinanceiraDTO();
			i.setId_instituicao(999);
			i.setNome("Fininvest");
			contrato.setInstituicao(i);
			contrato.setStatusAtivo(true);
			contrato.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			PlanoEmprestimoDTO plano = new PlanoEmprestimoDTO(223, "Fininvest Platinum", 12, 60,  0.50D, 0.23D);
			contrato.setPlano(plano);
			contrato.setId_contrato(113344);
			contrato.setRefinanciamentoHabilitado(true);
			//TODO setar os dados de modo que os mocks retornem o resultado esperado.
			
			
		    retorno  = remote.solicitarEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			log.error("Erro :", e);
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
			EmpregadoDTO e = new EmpregadoDTO(8754, "Jose inativo", false);
			e.setCpf("20098547813");
			
			InstituicaoFinanceiraDTO i = new InstituicaoFinanceiraDTO();
			i.setId_instituicao(999);
			i.setNome("Fininvest");
			contrato.setInstituicao(i);
			contrato.setStatusAtivo(true);
			contrato.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			PlanoEmprestimoDTO plano = new PlanoEmprestimoDTO(223, "Fininvest Platinum", 12, 60,  0.50D, 0.23D);
			contrato.setPlano(plano);
			contrato.setEmpregado(e);
			contrato.setId_contrato(113344);
		    remote.solicitarEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			log.error("Erro :", e);
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
			EmpregadoDTO e = new EmpregadoDTO(113, "Hernand solicitarEmprestimoOK", true);
			e.setCpf("64675653715");
			
			contrato.setEmpregado(e);
			InstituicaoFinanceiraDTO i = new InstituicaoFinanceiraDTO();
			i.setId_instituicao(999);
			i.setNome("Fininvest");
			contrato.setInstituicao(i);
			contrato.setStatusAtivo(true);
			contrato.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			PlanoEmprestimoDTO plano = new PlanoEmprestimoDTO(223, "Fininvest Platinum", 12, 60,  0.50D, 0.23D);
			contrato.setPlano(plano);
			contrato.setId_contrato(113344);
			
		    remote.solicitarEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			log.error("Erro :", e);
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
			EmpregadoDTO e = new EmpregadoDTO(113, "Hernand solicitarEmprestimoOK", true);
			e.setCpf("64675653715");
			
			contrato.setEmpregado(e);
			InstituicaoFinanceiraDTO i = new InstituicaoFinanceiraDTO();
			i.setId_instituicao(999);
			i.setNome("Fininvest");
			contrato.setInstituicao(i);
			contrato.setStatusAtivo(true);
			contrato.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			PlanoEmprestimoDTO plano = new PlanoEmprestimoDTO(224, "Fininvest BASIC", 12, 60,  0.50D, 0.23D);
			contrato.setPlano(plano);
			contrato.setId_contrato(113355);
			//IMPORTANTE O CONTRATO ANTERIOR
			contrato.setContratoEmprestimoAnterior(new ContratoEmprestimoDTO(113344, e, i));
			contrato.setRefinanciamentoHabilitado(false);
			
			
		    retorno  = remote.solicitarRefinanciamentoEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			log.error("Erro :", e);
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
			log.error("Erro :", e);
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			log.error("Erro :", e);
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
			EmpregadoDTO e = new EmpregadoDTO(113, "Hernand solicitarEmprestimoOK", true);
			e.setCpf("64675653715");
			
			contrato.setEmpregado(e);
			InstituicaoFinanceiraDTO i = new InstituicaoFinanceiraDTO();
			i.setId_instituicao(999);
			i.setNome("Fininvest");
			contrato.setInstituicao(i);
			contrato.setStatusAtivo(true);
			contrato.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			PlanoEmprestimoDTO plano = new PlanoEmprestimoDTO(224, "Fininvest BASIC", 12, 60,  0.50D, 0.23D);
			contrato.setPlano(plano);
			contrato.setId_contrato(113366);
			//IMPORTANTE O CONTRATO ANTERIOR
			contrato.setContratoEmprestimoAnterior(new ContratoEmprestimoDTO(113355, e, i));
			contrato.setRefinanciamentoHabilitado(false);
			
		    remote.solicitarRefinanciamentoEmprestimo(contrato);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		}
		catch(Exception e){
			msgExeption = e.getMessage();
			log.error("Erro :", e);
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("O emprestimo não está habilitado para refinanciamento", msgExeption);
	}
	
	
	@Test
	public void listarEmprestimosPagosValidosStprint3() {
		
		try {
			
			initialContext = new InitialContext();
			Emprestimo remote = (Emprestimo) initialContext.lookup(url);
	
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			EmpregadoDTO empregado = new EmpregadoDTO(112,"William Vinco",true);
			contrato.setValorEmprestimo(500.0);
			contrato.setCarteiraOperador(true);
			
			List<ParcelaEmprestimoDTO> parcelas = new ArrayList<ParcelaEmprestimoDTO>();
			for (int i = 0; i < 10; i++) {
				ParcelaEmprestimoDTO p1 = new ParcelaEmprestimoDTO();
				p1.setId_parcela(i);
				p1.setStatus(true);
				p1.setValor(50.0);
				p1.setVencimento(new Date(2012, i+1, 5));
				parcelas.add(p1);
			}
			
			List<ContratoEmprestimoDTO> contratos = remote.listaContratoEmprestimo(empregado);
			
			for (ContratoEmprestimoDTO contratoEmprestimoDTO : contratos) {
				/*Verifica se o contrato tem refinanciamento habilitado */
				Assert.assertEquals(true,contratoEmprestimoDTO.getRefinanciamentoHabilitado());
				//verifica se o contrato emprestimo est� na carteira de operador
				Assert.assertEquals(true, contratoEmprestimoDTO.getCarteiraOperador());
				
				
				/*valor total do contrato = 350.0
				 * 30% = 105
				 * 
				 * Verifica se o emprestimo teve 30% ou mais do valor pago
				*/
				Double valorPago = 0.0;
				for (ParcelaEmprestimoDTO parcela : contratoEmprestimoDTO.getParcelas()) {
					if (parcela.getStatus()) {
						valorPago = valorPago + parcela.getValor();
					}
				}
				Assert.assertEquals(true, contratoEmprestimoDTO.getValorEmprestimo() * 0.3 >= valorPago);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
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
