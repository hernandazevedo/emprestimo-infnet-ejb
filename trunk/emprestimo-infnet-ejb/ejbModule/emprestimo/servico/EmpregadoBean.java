package emprestimo.servico;

import java.util.List;

import javax.ejb.Stateful;

import servicos.interfaces.Empregado;
import dominio.dao.ContratoEmprestimoDAO;
import dominio.dao.EmpregadoDAO;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
@Stateful
public class EmpregadoBean implements Empregado {

	//Singletons que mantem os dados mockados
	private static ContratoEmprestimoDAO contratosDAO = ContratoEmprestimoDAO.getInstance();
	private static EmpregadoDAO empregadoDAO = EmpregadoDAO.getInstance();
	
	/*
	Acompanhar análise de solicitação feita via site	Como: Cliente com proposta de empréstimo realizada
	Quero: Consultar o histórico de relacionamento com a ativa
	História: Localizar propostas, empréstimos e refinanciamentos realizados 	
	RN1 - O cliente deve possuir um cadastrado na Ativa.
	RN2 - Para um cliente, os estados possíveis de uma proposta são: Análise, Rejeitada, Pré-Aprovada, Aprovada e Reprovada

	 * @see servicos.interfaces.Empregado#consultarHistoricoRelacionamento(dominio.dto.EmpregadoDTO)
	 */
	
	@Override
	public List<ContratoEmprestimoDTO> consultarHistoricoRelacionamento(
			EmpregadoDTO empregadoRequerente) throws Exception {
		//RN1 
		if(!isClienteCadastroAtivo(empregadoRequerente)){
			throw new Exception("Cliente não possui cadastro ativo no sistema");
		}
		
		/**RN2 foi implementada usando um enum de statusAnalise @see servicos.enums.EnumStatusAnalise**/ 
		
		
		
		return contratosDAO.getContratoEmprestimos(empregadoRequerente);
	}
	
	
	/**
	 * Verifica se cliente possui cadastro ativo
	 * @param emprestimoDTO 
	 * @return
	 */
	private boolean isClienteCadastroAtivo(EmpregadoDTO empregadoDTO) {
		boolean flag = false;
		for(EmpregadoDTO em:empregadoDAO.getEmpregados()){
			if (em.getAtivo() &&
					empregadoDTO != null &&
					empregadoDTO.getCpf() != null &&
					empregadoDTO.getCpf().equals(em.getCpf())){
					flag = true;
				}
		}
		return flag;
	}
	
	
}

