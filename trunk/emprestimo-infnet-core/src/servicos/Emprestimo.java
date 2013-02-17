package servicos;

import javax.ejb.Remote;

import dominio.dto.EmprestimoDTO;

@Remote
public interface Emprestimo {

	/**
	 * Solicia um emprestimo e devolve uma mensagem.
	 * @param emprestimoDTO
	 * @return
	 */
	MensagemRetornoBeanWS solicitarEmprestimo(EmprestimoDTO emprestimoDTO);
}
