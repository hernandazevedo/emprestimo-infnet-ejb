package servicos.interfaces;

import java.util.List;

import javax.ejb.Remote;

import servicos.bean.MensagemRetornoBeanWS;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;

@Remote
public interface Emprestimo {

	/**
	 * Solicia um emprestimo e devolve uma mensagem.
	 * @param emprestimoDTO
	 * @return
	 */
	MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO) throws Exception;
	/**
	 * Solicia um refinanciamento de emprestimo e devolve uma mensagem.
	 * @param emprestimoDTO
	 * @return
	 */
	MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(ContratoEmprestimoDTO emprestimoDTO) throws Exception;
	
	
	
	
	public List<ContratoEmprestimoDTO> listaContratoEmprestimo(EmpregadoDTO empregado) throws Exception;
}
