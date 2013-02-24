import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Test;

import servicos.enums.EnumPerfilFuncionario;
import servicos.interfaces.Gerente;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.FuncionarioDTO;
import dominio.dto.PerfilFuncionarioDTO;


public class GerenteTest {


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
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
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
			e.printStackTrace();
		} catch(Exception e){
			msgExeption = e.getMessage();
			e.printStackTrace();
		}
		 
		 Assert.assertTrue(msgExeption != null);
		 Assert.assertEquals("Funcionario não é gerente. Apenas um funcionário gerente pode realizar essa atividade.", msgExeption);
	}
	
}
