package emprestimo.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import servicos.Emprestimo;
import servicos.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;
import emprestimo.exeptions.BusinessException;
@Stateful
public class EmprestimoBean implements Emprestimo {

	private static List<ContratoEmprestimoDTO> contratoEmprestimos = mockContratoEmprestimos();
	private static List<EmpregadoDTO> empregadosCadastrados = mockEmpregados();
	
	
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
		if(isEmprestivoAtivoMesmaInstituicao()){
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
		contratoEmprestimos.add(contrato);
		
	}


	/**
	 * Mock da lista inicial de empregados
	 * @return
	 */
	private static List<EmpregadoDTO> mockEmpregados() {
		if(empregadosCadastrados == null){
			empregadosCadastrados = new ArrayList<EmpregadoDTO>();
			EmpregadoDTO e1 = new EmpregadoDTO();
			//TODO preencher os dados do empregado
			empregadosCadastrados.add(e1);
			
		}
		return empregadosCadastrados;
	}
	/**
	 * Mock da lista inicial de emprestimos contratados 
	 * @return
	 */
	private static List<ContratoEmprestimoDTO> mockContratoEmprestimos() {
		
		if(contratoEmprestimos == null){
			contratoEmprestimos = new ArrayList<ContratoEmprestimoDTO>();
			ContratoEmprestimoDTO c1 = new ContratoEmprestimoDTO();
			//TODO preencher os dados do empregado
			contratoEmprestimos.add(c1);
			
		}
		return contratoEmprestimos;
	}

	/**
	 * Valida se o cliente possui emprestimo ativo nesta instituição
	 * @return
	 */
	private boolean isEmprestivoAtivoMesmaInstituicao() {
		//utilizar a lista
		boolean flag = false;
		for(ContratoEmprestimoDTO c :contratoEmprestimos){
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
		for(EmpregadoDTO em:empregadosCadastrados){
			
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

