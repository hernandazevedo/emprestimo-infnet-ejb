package servicos.interfaces;

import javax.ejb.Remote;

import servicos.bean.MensagemRetornoBeanWS;
import dominio.dto.ContratoEmprestimoDTO;

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
}
