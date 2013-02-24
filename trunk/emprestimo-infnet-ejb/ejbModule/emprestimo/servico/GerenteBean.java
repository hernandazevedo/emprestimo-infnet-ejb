package emprestimo.servico;

import java.util.List;

import javax.ejb.Stateful;

import servicos.bean.MensagemRetornoBeanWS;
import servicos.enums.EnumPerfilFuncionario;
import servicos.enums.EnumStatusAnalise;
import servicos.interfaces.Gerente;
import dominio.dao.ContratoEmprestimoDAO;
import dominio.dao.EmpregadoDAO;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.FuncionarioDTO;
@Stateful
public class GerenteBean implements Gerente {

	//Singletons que mantem os dados mockados
	private static ContratoEmprestimoDAO contratosDAO = ContratoEmprestimoDAO.getInstance();
	private static EmpregadoDAO empregadoDAO = EmpregadoDAO.getInstance();
	
	@Override
	public List<ContratoEmprestimoDTO> listarPropostasPendenteAnalise(
			FuncionarioDTO funcionarioRequerente) throws Exception {
		
		if(!isFuncionarioGerente(funcionarioRequerente)){
			throw new Exception("Funcionario não é gerente. Apenas um funcionário gerente pode realizar essa atividade.");
		}
		
		
		
		return contratosDAO.getContratoEmprestimos(EnumStatusAnalise.PENDENTE_ANALISE);
	}
	
	
	private boolean isFuncionarioGerente(FuncionarioDTO funcionarioRequerente) {
		if( funcionarioRequerente.getPerfil() != null &&
			funcionarioRequerente.getPerfil().getIdPerfil() == EnumPerfilFuncionario.GERENTE.getIdPerfil() 	
				){
			return true;
		}
		return false;
	}


	@Override
	public MensagemRetornoBeanWS analisarProposta(
			ContratoEmprestimoDTO emprestimoDTO,
			FuncionarioDTO funcionarioRequerente) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

