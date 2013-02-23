package emprestimo.servico;

import javax.ejb.Stateful;

import servicos.Emprestimo;
import servicos.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import dominio.dao.ContratoEmprestimoDAO;
import dominio.dao.EmpregadoDAO;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
@Stateful
public class EmprestimoBean implements Emprestimo {

	//Singletons que mantem os dados mockados
	private static ContratoEmprestimoDAO contratosDAO = ContratoEmprestimoDAO.getInstance();
	private static EmpregadoDAO empregadoDAO = EmpregadoDAO.getInstance();
	
	
	/*
	Solicitar Empr�stimo via Site	Como: Cliente sem empr�stimo ativo
	Quero: Solicitar um Empr�stimo.
	Hist�ria: 
	1- Preencher dados de uma solicita��o de empr�stimo e enviar	- 
	RN1 - Cliente deve possuir um cadastrado na Ativa.
	RN2 - N�o pode solicitar um novo empr�stimo, se j� possuir um ativo numa mesma institui��o financeira.

	 * (non-Javadoc)
	 * @see servicos.Emprestimo#solicitarEmprestimo(dominio.dto.ContratoEmprestimoDTO)
	 */
	public MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO)  throws Exception{
		MensagemRetornoBeanWS retorno = null;
		
		//RN1 
		if(!isClienteCadastroAtivo(emprestimoDTO)){
			throw new Exception("Cliente n�o possui cadastro ativo no sistema");
		}
		
		//RN2 
		if(isEmprestivoAtivoMesmaInstituicao(emprestimoDTO)){
			throw new Exception("Cliente n�o pode solicitar um novo empr�stimo, possui emprestimo ativo na institui��o");
		}
		

		try{
			
			salvarEmprestimo(emprestimoDTO);
			
			
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
	 * @param emprestimoDTO 
	 * @return
	 */
		//utilizar a lista
	private boolean isEmprestivoAtivoMesmaInstituicao(ContratoEmprestimoDTO emprestimoDTO) {
		boolean flag = false;
		
		for(ContratoEmprestimoDTO c :contratosDAO.getContratoEmprestimos()){
			if (c.isStatus()) {
				if (emprestimoDTO.getEmpregado().getCpf().equals(c.getEmpregado().getCpf())){
					flag =(c.getPlano().getId_plano() == emprestimoDTO.getPlano().getId_plano() && c.getInstituicao().getId_instituicao() == emprestimoDTO.getInstituicao().getId_instituicao());
				}
				
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
			if (em.getAtivo()){
				flag = true;
			}
		}
		return flag;
	}
	
	
	/*
	 * 
	Solicitar Refinanciamento via Site	Como: Cliente com empr�stimo ativo
	Quero: Solicitar um Refinaciamento.
	Hist�ria: Preencher dados de uma solicita��o de refinanciamento e enviar	
	RN1 - Cliente deve possuir pelo menos um empr�stimo ativo.
	RN2 - O empr�stimo a ser refinanciado deve estar habilitado a ser refinanciado.
	
	 * (non-Javadoc)
	 * @see servicos.Emprestimo#solicitarRefinanciamentoEmprestimo(dominio.dto.ContratoEmprestimoDTO)
	 */ 
	public MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(ContratoEmprestimoDTO emprestimoDTO)  throws Exception {
		MensagemRetornoBeanWS retorno = null;
		
		//RN1
		if(!isEmprestivoAtivoMesmaInstituicao(emprestimoDTO)){
			throw new Exception("Cliente n�o pode solicitar um novo refinanciamento, n�o possui emprestimo ativo na institui��o");
		}
		
		//RN2
		if(!isRefinanciamentoEmprestimoHabilitado(emprestimoDTO)){
			throw new Exception("O emprestimo n�o est� habilitado para refinanciamento");
		}
		
		//TODO realizar a solicita��o de emprestimo/refinanciamento
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

