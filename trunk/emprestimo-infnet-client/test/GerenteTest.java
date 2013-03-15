import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.jboss.logging.Logger;
import org.junit.Test;

import servicos.bean.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import servicos.enums.EnumPerfilFuncionario;
import servicos.enums.EnumStatusAnalise;
import servicos.interfaces.Gerente;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
import dominio.dto.FuncionarioDTO;
import dominio.dto.PerfilFuncionarioDTO;


public class GerenteTest {

	private Logger log = Logger.getLogger(GerenteTest.class);
	private InitialContext initialContext;
	
	private String url = "emprestimo-infnet/emprestimo-infnet-ejb/GerenteBean!servicos.interfaces.Gerente";
	
	
	@Test
	public void listarPropostasPendenteAnaliseOK(){
		List<ContratoEmprestimoDTO> retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Gerente remote = (Gerente) initialContext.lookup(url);
			
			FuncionarioDTO funcionarioRequerente = new FuncionarioDTO();
			funcionarioRequerente.setPerfil(new PerfilFuncionarioDTO(EnumPerfilFuncionario.GERENTE));
			
		    retorno  = remote.listarPropostasPendenteAnalise(funcionarioRequerente);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			log.error("Erro :", e);
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertTrue(!retorno.isEmpty());
	}
	
	@Test
	public void listarPropostasPendenteAnaliseFalhaRegraNegocioUM(){
		
		String msgExeption = null;
		try {
	 		
			 
			initialContext = new InitialContext();
			 
			Gerente remote = (Gerente) initialContext.lookup(url);
			
			FuncionarioDTO funcionarioRequerente = new FuncionarioDTO();
			funcionarioRequerente.setPerfil(new PerfilFuncionarioDTO(EnumPerfilFuncionario.OPERADOR_CALLCENTER));
			
		    remote.listarPropostasPendenteAnalise(funcionarioRequerente);
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			msgExeption = e.getMessage();
			log.error("Erro :", e);
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("Funcionario não é gerente. Apenas um funcionário gerente pode realizar essa atividade.", msgExeption);
	}
	
	@Test
	public void analisarPropostaPreAprovadoOK(){
		MensagemRetornoBeanWS retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Gerente remote = (Gerente) initialContext.lookup(url);
			
			FuncionarioDTO funcionarioRequerente = new FuncionarioDTO();
			funcionarioRequerente.setPerfil(new PerfilFuncionarioDTO(EnumPerfilFuncionario.GERENTE));
			ContratoEmprestimoDTO emprestimoDTO = new ContratoEmprestimoDTO();
			emprestimoDTO.setStatusAnalise(EnumStatusAnalise.ANALISADA);
			
		    retorno  = remote.analisarProposta(emprestimoDTO,funcionarioRequerente);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			log.error("Erro :", e);
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertEquals(EnumMensagemRetorno.OK.getCodigo(), retorno.getCodigo());
	}
	
	@Test
	public void analisarPropostaRejeitadaOK(){
		MensagemRetornoBeanWS retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Gerente remote = (Gerente) initialContext.lookup(url);
			
			FuncionarioDTO funcionarioRequerente = new FuncionarioDTO();
			funcionarioRequerente.setPerfil(new PerfilFuncionarioDTO(EnumPerfilFuncionario.GERENTE));
			ContratoEmprestimoDTO emprestimoDTO = new ContratoEmprestimoDTO();
			emprestimoDTO.setStatusAnalise(EnumStatusAnalise.REJEITADA);
			EmpregadoDTO empregado = new EmpregadoDTO();
			empregado.setNome("Hernand");
			empregado.setEmail("hernand.azevedo@gmail.com");
			emprestimoDTO.setEmpregado(empregado);
			emprestimoDTO.setId_contrato(1122457);
			
		    retorno  = remote.analisarProposta(emprestimoDTO,funcionarioRequerente);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			log.error("Erro :", e);
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertEquals(EnumMensagemRetorno.OK.getCodigo(), retorno.getCodigo());
	}
	
	@Test
	public void analisarPropostaStatusInvalido(){
		MensagemRetornoBeanWS retorno = null;
		 try {
			 		
			 
			initialContext = new InitialContext();
			 
			Gerente remote = (Gerente) initialContext.lookup(url);
			
			FuncionarioDTO funcionarioRequerente = new FuncionarioDTO();
			funcionarioRequerente.setPerfil(new PerfilFuncionarioDTO(EnumPerfilFuncionario.GERENTE));
			ContratoEmprestimoDTO emprestimoDTO = new ContratoEmprestimoDTO();
			
			//STATUS invalido para analise, neste caso deve retornar "NOK"
			emprestimoDTO.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			
		    retorno  = remote.analisarProposta(emprestimoDTO,funcionarioRequerente);
			
			
		} catch (NamingException e) {
			log.error("Erro :", e);
		} catch(Exception e){
			log.error("Erro :", e);
		}
		 
		 Assert.assertTrue(retorno != null);
		 Assert.assertEquals(EnumMensagemRetorno.NOK.getCodigo(), retorno.getCodigo());
	}
	
}
