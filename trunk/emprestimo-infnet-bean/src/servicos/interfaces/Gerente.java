package servicos.interfaces;

import java.util.List;

import javax.ejb.Remote;

import servicos.bean.MensagemRetornoBeanWS;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.FuncionarioDTO;

@Remote
public interface Gerente {

	/**
	 * Gerente lista as propostas pendentes de analise.
	 * @param funcionarioRequerente
	 * @return
	 */
	List<ContratoEmprestimoDTO> listarPropostasPendenteAnalise(FuncionarioDTO funcionarioRequerente) throws Exception;
	
	/**
	 * Gerente analisa a proposta e pode "Aprovar" ou "Reprovar", dependendo do parametro de entrada "statusAnalise".
	 * @param emprestimoDTO
	 * @param funcionarioRequerente
	 * @return
	 */
	MensagemRetornoBeanWS analisarProposta(ContratoEmprestimoDTO emprestimoDTO,FuncionarioDTO funcionarioRequerente) throws Exception;
	
}
