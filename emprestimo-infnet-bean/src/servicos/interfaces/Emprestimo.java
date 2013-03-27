package servicos.interfaces;

import java.util.List;

import javax.ejb.Remote;

import servicos.bean.MensagemRetornoBeanWS;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
import dominio.dto.FuncionarioDTO;

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
	
	
	/**
	 * Sprint 3
	Carregar empréstimos na carteira de operadores de callcenter
	Como: Supervisor de Callcenter
	Quero: Localizar propostas passíveis de refinanciamento.
	História: Supervisor localiza propostas de empréstimos passíveis de refinanciamento
	- Apenas empréstimos com no mínimo 30% pagos devem ser exibidos.
	- Exibir apenas os empréstimos que não estejam na carteira de nenhum operador.

	 * @param empregado
	 * @return
	 * @throws Exception
	 */
	
	List<ContratoEmprestimoDTO> localizarPropostasPassiveisRefinanciamento() throws Exception;
	
	
	/**
	 * 
	 * 
	Como: Supervisor de Callcenter
	Quero: Carregar empréstimos na carteira de operadores de callcenter
	História: Supervisor localiza empréstimos passíveis de refinanciamento. Supervisor seleciona empréstimos a serem carregados na carteira de operador. Supervisor identifica o operador que receberá os empréstimos selecionados e confirma a operação
	- Apenas o Supervisor de Callcenter pode executar esta operação.
	
	- Um empréstimo não pode ser carregado em outra carteira enquanto estiver na carteira de um determinado operador

	 * @param contratosEmprestimos
	 * @param operador
	 * @return
	 */
	MensagemRetornoBeanWS carregarEmprestimosCarteiraOperador(List<ContratoEmprestimoDTO> contratosEmprestimos,FuncionarioDTO operador)  throws Exception;
}
