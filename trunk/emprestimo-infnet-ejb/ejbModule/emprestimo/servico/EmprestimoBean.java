package emprestimo.servico;

import javax.ejb.Stateful;

import servicos.Emprestimo;
import servicos.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import dominio.dto.ContratoEmprestimoDTO;
import emprestimo.exeptions.BusinessException;
@Stateful
public class EmprestimoBean implements Emprestimo {

	
	
	
	/**
	 * 
	Solicitar Empréstimo via Site	Como: Cliente sem empréstimo ativo
	Quero: Solicitar um Empréstimo.
	História: 
	1- Preencher dados de uma solicitação de empréstimo e enviar	- 
	RN1 - Cliente deve possuir um cadastrado na Ativa.
	RN2 - Não pode solicitar um novo empréstimo, se já possuir um ativo numa mesma instituição financeira.

	 */
	public MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO) {
		MensagemRetornoBeanWS retorno = null;
		
		//RN1 TODO colocar os parametros no metodo de validação abaixo conforme a necessidade
		if(!isClienteCadastroAtivo()){
			throw new BusinessException("Cliente não possui cadastro ativo no sistema");
		}
		
		
		//RN2 TODO colocar os parametros no metodo de validação abaixo conforme a necessidade
		if(!isEmprestivoAtivoMesmaInstituicao()){
			throw new BusinessException("Cliente não pode solicitar um novo empréstimo, possui emprestimo ativo na instituição");
		}
		
		
		
		
		//TODO realizar a solicitação de emprestimo
		try{
			//Trecho de emprestimo aqui....
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.NOK);
		}
		
		
		retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.OK);
		return retorno;
	}

	/**
	 * Valida se o cliente possui emprestimo ativo nesta instituição
	 * @return
	 */
	private boolean isEmprestivoAtivoMesmaInstituicao() {
		// TODO Auto-generated method stub
		return true;
	}


	/**
	 * Verifica se cliente possui cadastro ativo
	 * @return
	 */
	private boolean isClienteCadastroAtivo() {
		// TODO Auto-generated method stub
		
		return true;
	}

	
	
	
	public MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(
			ContratoEmprestimoDTO emprestimoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}

