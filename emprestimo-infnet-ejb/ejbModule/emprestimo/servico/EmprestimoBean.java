package emprestimo.servico;

import javax.ejb.Stateful;

import servicos.Emprestimo;
import servicos.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import dominio.dao.ContratoEmprestimoDAO;
import dominio.dao.EmpregadoDAO;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
import emprestimo.exeptions.BusinessException;
@Stateful
public class EmprestimoBean implements Emprestimo {

	//Singletons que mantem os dados mockados
	private static ContratoEmprestimoDAO contratosDAO = ContratoEmprestimoDAO.getInstance();
	private static EmpregadoDAO empregadoDAO = EmpregadoDAO.getInstance();
	
	
	/*
	Solicitar Empréstimo via Site	Como: Cliente sem empréstimo ativo
	Quero: Solicitar um Empréstimo.
	História: 
	1- Preencher dados de uma solicitação de empréstimo e enviar	- 
	RN1 - Cliente deve possuir um cadastrado na Ativa.
	RN2 - Não pode solicitar um novo empréstimo, se já possuir um ativo numa mesma instituição financeira.

	 * (non-Javadoc)
	 * @see servicos.Emprestimo#solicitarEmprestimo(dominio.dto.ContratoEmprestimoDTO)
	 */
	public MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO) {
		MensagemRetornoBeanWS retorno = null;
		
		//RN1 
		if(!isClienteCadastroAtivo(emprestimoDTO)){
			throw new BusinessException("Cliente não possui cadastro ativo no sistema");
		}
		
		//RN2 
		if(isEmprestivoAtivoMesmaInstituicao(emprestimoDTO)){
			throw new BusinessException("Cliente não pode solicitar um novo empréstimo, possui emprestimo ativo na instituição");
		}
		
		//TODO realizar a solicitação de emprestimo
		try{
			//Trecho de emprestimo aqui....
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//SETAR OS DADOS
			
			salvarEmprestimo(contrato);
			
			
		}catch (Exception e) {
			e.printStackTrace();
			retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.NOK);
		}
		
		retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.OK);
		return retorno;
	}

	
	private void salvarEmprestimo(ContratoEmprestimoDTO contrato) {
		contratosDAO.salvarContratoEmprestimo(contrato);
		
	}

	

	/**
	 * Valida se o cliente possui emprestimo ativo nesta instituição
	 * @param emprestimoDTO 
	 * @return
	 */
	private boolean isEmprestivoAtivoMesmaInstituicao(ContratoEmprestimoDTO emprestimoDTO) {
		//utilizar a lista
		boolean flag = false;
		for(ContratoEmprestimoDTO c :contratosDAO.getContratoEmprestimos()){
			//TODO validar se o emprestimo esta ativo para a mesma instituicao
			if(1 == 1){
				flag = true;
			}
		}
		return flag;
	}


	/**
	 * Verifica se cliente possui cadastro ativo
	 * @param emprestimoDTO 
	 * @return
	 */
	private boolean isClienteCadastroAtivo(ContratoEmprestimoDTO emprestimoDTO) {
		boolean flag = false;
		for(EmpregadoDTO em:empregadoDAO.getEmpregados()){
			
			if(1==1){
				flag = true;
			}
		}
		
		return flag;
	}

	
	
	
	/*
	 * 
	Solicitar Refinanciamento via Site	Como: Cliente com empréstimo ativo
	Quero: Solicitar um Refinaciamento.
	História: Preencher dados de uma solicitação de refinanciamento e enviar	
	RN1 - Cliente deve possuir pelo menos um empréstimo ativo.
	RN2 - O empréstimo a ser refinanciado deve estar habilitado a ser refinanciado.
	
	 * (non-Javadoc)
	 * @see servicos.Emprestimo#solicitarRefinanciamentoEmprestimo(dominio.dto.ContratoEmprestimoDTO)
	 */
	public MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(
			ContratoEmprestimoDTO emprestimoDTO) {
		MensagemRetornoBeanWS retorno = null;
		
		//RN1
		if(!isEmprestivoAtivoMesmaInstituicao(emprestimoDTO)){
			throw new BusinessException("Cliente não pode solicitar um novo refinanciamento, não possui emprestimo ativo na instituição");
		}
		
		//RN2
		if(!isRefinanciamentoEmprestimoHabilitado(emprestimoDTO)){
			throw new BusinessException("O emprestimo não está habilitado para refinanciamento");
		}
		
		//TODO realizar a solicitação de emprestimo/refinanciamento
		try{
			//Trecho de emprestimo aqui....
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
			//SETAR OS DADOS
			//SETAR O EMPRESTIMO ANTERIOR(Contrato anterior), que caracteriza um refinanciamento.
			
			salvarEmprestimo(contrato);
			
		}catch (Exception e) {
			e.printStackTrace();
			retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.NOK);
		}
		
		retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.OK);
		return retorno;
	}


	private boolean isRefinanciamentoEmprestimoHabilitado(
			ContratoEmprestimoDTO emprestimoDTO) {
		// TODO Auto-generated method stub
		return false;
	}

}

