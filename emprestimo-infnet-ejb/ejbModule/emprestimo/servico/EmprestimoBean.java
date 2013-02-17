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
	Solicitar Empr�stimo via Site	Como: Cliente sem empr�stimo ativo
	Quero: Solicitar um Empr�stimo.
	Hist�ria: 
	1- Preencher dados de uma solicita��o de empr�stimo e enviar	- 
	RN1 - Cliente deve possuir um cadastrado na Ativa.
	RN2 - N�o pode solicitar um novo empr�stimo, se j� possuir um ativo numa mesma institui��o financeira.

	 */
	public MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO) {
		MensagemRetornoBeanWS retorno = null;
		
		//RN1 TODO colocar os parametros no metodo de valida��o abaixo conforme a necessidade
		if(!isClienteCadastroAtivo()){
			throw new BusinessException("Cliente n�o possui cadastro ativo no sistema");
		}
		
		
		//RN2 TODO colocar os parametros no metodo de valida��o abaixo conforme a necessidade
		if(!isEmprestivoAtivoMesmaInstituicao()){
			throw new BusinessException("Cliente n�o pode solicitar um novo empr�stimo, possui emprestimo ativo na institui��o");
		}
		
		
		
		
		//TODO realizar a solicita��o de emprestimo
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
	 * Valida se o cliente possui emprestimo ativo nesta institui��o
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

