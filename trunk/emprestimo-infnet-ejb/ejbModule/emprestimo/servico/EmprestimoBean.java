package emprestimo.servico;

import javax.ejb.Stateful;

import servicos.bean.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import servicos.interfaces.Emprestimo;
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
	Solicitar Empréstimo via Site	Como: Cliente sem empréstimo ativo
	Quero: Solicitar um Empréstimo.
	História: 
	1- Preencher dados de uma solicitação de empréstimo e enviar	- 
	RN1 - Cliente deve possuir um cadastrado na Ativa.
	RN2 - Não pode solicitar um novo empréstimo, se já possuir um ativo numa mesma instituição financeira.

	 * (non-Javadoc)
	 * @see servicos.Emprestimo#solicitarEmprestimo(dominio.dto.ContratoEmprestimoDTO)
	 */
	public MensagemRetornoBeanWS solicitarEmprestimo(ContratoEmprestimoDTO emprestimoDTO)  throws Exception{
		MensagemRetornoBeanWS retorno = null;
		
		//RN1 
		if(!isClienteCadastroAtivo(emprestimoDTO)){
			throw new Exception("Cliente não possui cadastro ativo no sistema");
		}
		
		//RN2 
		if(isEmprestivoAtivoMesmaInstituicao(emprestimoDTO)){
			throw new Exception("Cliente não pode solicitar um novo empréstimo, possui emprestimo ativo na instituição");
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
	
	private void salvarContratoEmprestimoRefinanciamento(ContratoEmprestimoDTO contrato) {
		contratosDAO.salvarContratoEmprestimoRefinanciamento(contrato);
		
	}

	

	/**
	 * Valida se o cliente possui emprestimo ativo nesta instituição
	 * @param emprestimoDTO 
	 * @return
	 */
		//utilizar a lista
	private boolean isEmprestivoAtivoMesmaInstituicao(ContratoEmprestimoDTO emprestimoDTO) {
		boolean flag = false;
		
		for(ContratoEmprestimoDTO c :contratosDAO.getContratoEmprestimos()){
			if (c.isStatusAtivo()) {
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
			if (em.getAtivo() &&
				emprestimoDTO.getEmpregado() != null &&
				emprestimoDTO.getEmpregado().getCpf() != null &&
				emprestimoDTO.getEmpregado().getCpf().equals(em.getCpf())){
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
	public MensagemRetornoBeanWS solicitarRefinanciamentoEmprestimo(ContratoEmprestimoDTO emprestimoDTO)  throws Exception {
		MensagemRetornoBeanWS retorno = null;
		
		//RN1
		if(!isEmprestivoAtivoCliente(emprestimoDTO)){
			throw new Exception("Cliente não pode solicitar um novo refinanciamento, não possui emprestimos ativos");
		}
		
		//RN2
		if(!isRefinanciamentoEmprestimoHabilitado(emprestimoDTO)){
			throw new Exception("O emprestimo não está habilitado para refinanciamento");
		}
		
		
		try{
		
			ContratoEmprestimoDTO contrato = new ContratoEmprestimoDTO();
		
			salvarContratoEmprestimoRefinanciamento(contrato);
			
		}catch (Exception e) {
			e.printStackTrace();
			retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.NOK);
		}
		
		retorno = new MensagemRetornoBeanWS(EnumMensagemRetorno.OK);
		return retorno;
	}

	/**
	 * Verifica se o cliente possui algum emprestimo ativo
	 * @param emprestimoDTO
	 * @return
	 */
	private boolean isEmprestivoAtivoCliente(ContratoEmprestimoDTO emprestimoDTO) {
		//utilizar a lista
		boolean flag = false;
		
		for(ContratoEmprestimoDTO c :contratosDAO.getContratoEmprestimos()){

			if(c.isStatusAtivo() &&
					c.getEmpregado() != null &&
					c.getEmpregado().getCpf() != null &&
					emprestimoDTO.getEmpregado() != null &&
					c.getEmpregado().getCpf().equals(emprestimoDTO.getEmpregado().getCpf())){
				
				flag = true;
				break;
		
			}
		}
		return flag;
	}

	/**
	 * Verifica se o contrato de emprestimo a ser refinanciado esta habilitado para refinanciamento
	 * @param emprestimoDTO
	 * @return
	 */
	private boolean isRefinanciamentoEmprestimoHabilitado(ContratoEmprestimoDTO emprestimoDTO) {
		
		boolean flag = false;
		
		for(ContratoEmprestimoDTO c :contratosDAO.getContratoEmprestimos()){
			if(emprestimoDTO.getId_contrato() > 0 &&
					emprestimoDTO.getId_contrato() == c.getId_contrato()
					&& c.getRefinanciamentoHabilitado()){
				flag = true;
				break;
			}

		}
		return flag;
	}
}

