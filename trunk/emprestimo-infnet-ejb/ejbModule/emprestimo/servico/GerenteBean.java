package emprestimo.servico;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;

import servicos.bean.MensagemRetornoBeanWS;
import servicos.enums.EnumMensagemRetorno;
import servicos.enums.EnumPerfilFuncionario;
import servicos.enums.EnumStatusAnalise;
import servicos.interfaces.Gerente;
import dominio.dao.CallCenterDAO;
import dominio.dao.ContratoEmprestimoDAO;
import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.FuncionarioDTO;
@Stateful
public class GerenteBean implements Gerente {

	//Singletons que mantem os dados mockados
	private static ContratoEmprestimoDAO contratosDAO = ContratoEmprestimoDAO.getInstance();
	private static CallCenterDAO callCenterDAO = CallCenterDAO.getInstance();
	
	@Override
	public List<ContratoEmprestimoDTO> listarPropostasPendenteAnalise(
			FuncionarioDTO funcionarioRequerente) throws Exception {
		
		if(!isFuncionarioGerente(funcionarioRequerente)){
			throw new Exception("Funcionario não é gerente. Apenas um funcionário gerente pode realizar essa atividade.");
		}
		
		
		
		return contratosDAO.getContratoEmprestimos(EnumStatusAnalise.PENDENTE_ANALISE);
	}
	
	
	private boolean isFuncionarioGerente(FuncionarioDTO funcionarioRequerente) {
		if( funcionarioRequerente.getPerfil() != null &&
			funcionarioRequerente.getPerfil().getIdPerfil() == EnumPerfilFuncionario.GERENTE.getIdPerfil() 	
				){
			return true;
		}
		return false;
	}

	/*
	
	Gerente analisa proposta	Como: Gerente
	Quero: Reprovar propostas de empréstimo.
	História: Localizar propostas de empréstimo pendentes de análise. As propostas devem ser analisadas individualmente. Para cada proposta que o Gerente não aprovar, ele deve aplicar o estado de “Rejeitada”.	
	RN1 - Apenas um funcionário gerente pode realizar essa atividade.
	RN2 - Deve ser possível rastrear qual gerente da Ativa analisou cada proposta, assim como a data e hora de análise.
	RN3 - As propostas rejeitadas são encaminhadas para o Call Center entrar em contato com o cliente.
	RN4	- O estado visível para o cliente é Pré-Aprovada
	RN5 - O estado visível para o cliente é Rejeitada
	 * (non-Javadoc)
	 * @see servicos.interfaces.Gerente#analisarProposta(dominio.dto.ContratoEmprestimoDTO, dominio.dto.FuncionarioDTO)
	 */
	@Override
	public MensagemRetornoBeanWS analisarProposta(
			ContratoEmprestimoDTO emprestimoDTO,
			FuncionarioDTO funcionarioRequerente) throws Exception {
		//RN1
		if(!isFuncionarioGerente(funcionarioRequerente)){
			throw new Exception("Funcionario não é gerente. Apenas um funcionário gerente pode realizar essa atividade.");
		}
		
		//RN2
		emprestimoDTO.setDataStatusAnalise(new Date());
		emprestimoDTO.setFuncionarioAnalise(funcionarioRequerente);

		//RN4
		if(emprestimoDTO.getStatusAnalise() == EnumStatusAnalise.ANALISADA.getStatusAnalise()){
			preAprovarProposta(emprestimoDTO);
		//RN5
		}else if(emprestimoDTO.getStatusAnalise() == EnumStatusAnalise.REJEITADA.getStatusAnalise()){ 
			
			rejeitarProposta(emprestimoDTO);
		}else{
			return new MensagemRetornoBeanWS(EnumMensagemRetorno.NOK);
		}
		
		
		
		return new MensagemRetornoBeanWS(EnumMensagemRetorno.OK);
	}


	private void rejeitarProposta(ContratoEmprestimoDTO emprestimoDTO) {
		emprestimoDTO.setStatusAtivo(false);
		atualizarContratoEmprestimo(emprestimoDTO);
		//RN3
		enviarPropostaCallCenter(emprestimoDTO);
		
	}


	private void atualizarContratoEmprestimo(ContratoEmprestimoDTO emprestimoDTO) {
		
		contratosDAO.atualizarContratoEmprestimo(emprestimoDTO);
	}


	private void enviarPropostaCallCenter(ContratoEmprestimoDTO emprestimoDTO) {
		callCenterDAO.enviaEmprestimoCallCenter(emprestimoDTO);
		
	}


	private void preAprovarProposta(ContratoEmprestimoDTO emprestimoDTO) {
		
		atualizarContratoEmprestimo(emprestimoDTO);
		
	}
	
	
}

