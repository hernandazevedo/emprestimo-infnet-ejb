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
		if(isEmprestivoAtivoMesmaInstituicao()){
			throw new BusinessException("Cliente n�o pode solicitar um novo empr�stimo, possui emprestimo ativo na institui��o");
		}
		
		
		
		
		//TODO realizar a solicita��o de emprestimo
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
	 * Valida se o cliente possui emprestimo ativo nesta institui��o
	 * @return
	 */
	private boolean isEmprestivoAtivoMesmaInstituicao() {
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
	 * @return
	 */
	private boolean isClienteCadastroAtivo() {
		boolean flag = false;
		for(EmpregadoDTO em:empregadoDAO.getEmpregados()){
			
			if(1==1){
				flag = true;
			}
		}
		
		return flag;
	}

	
	
	
	public MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(
			ContratoEmprestimoDTO emprestimoDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}

