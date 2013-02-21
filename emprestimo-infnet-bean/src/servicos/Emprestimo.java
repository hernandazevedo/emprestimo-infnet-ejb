package servicos;

import javax.ejb.Remote;

import dominio.dto.ContratoEmprestimoDTO;

@Remote
public interface Emprestimo {

	/**
	 * Solicia um emprestimo e devolve uma mensagem.
	 * @param emprestimoDTO
	 * @return
	 */
	MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO);
	MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(ContratoEmprestimoDTO emprestimoDTO);
}
