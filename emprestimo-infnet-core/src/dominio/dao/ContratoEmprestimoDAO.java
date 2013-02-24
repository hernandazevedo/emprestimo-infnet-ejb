package dominio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import servicos.enums.EnumStatusAnalise;

import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;

public class ContratoEmprestimoDAO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3450244970210084606L;
	
	private static ContratoEmprestimoDAO instance = null;
	
	private List<ContratoEmprestimoDTO> contratoEmprestimos = mockContratoEmprestimos();
	
	private ContratoEmprestimoDAO(){
		
	}
	
	/**
	 * Mock da lista inicial de emprestimos contratados 
	 * @return
	 */
	
	
	private List<ContratoEmprestimoDTO> mockContratoEmprestimos() {
		
		if(contratoEmprestimos == null){
			contratoEmprestimos = new ArrayList<ContratoEmprestimoDTO>();
			//TODO SETAR OS ATRIBUTOS EM CADA um
			ContratoEmprestimoDTO c1 = new ContratoEmprestimoDTO();
			c1.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			ContratoEmprestimoDTO c2 = new ContratoEmprestimoDTO();
			EmpregadoDTO e = new EmpregadoDTO();
			e.setAtivo(true);
			e.setCpf("05823562705");
			c2.setEmpregado(e);
			ContratoEmprestimoDTO c3 = new ContratoEmprestimoDTO();
			ContratoEmprestimoDTO c4 = new ContratoEmprestimoDTO();
			
			//TODO preencher os dados do empregado
			contratoEmprestimos.add(c1);
			contratoEmprestimos.add(c2);
			contratoEmprestimos.add(c3);
			contratoEmprestimos.add(c4);
			
		}
		return contratoEmprestimos;
	}
	
	
	
	public static ContratoEmprestimoDAO getInstance(){
		if(instance == null){
			instance = new ContratoEmprestimoDAO();
		}
		return instance;
	}
	
	/**
	 * Retorna os emprestimos
	 * @return
	 */
	public List<ContratoEmprestimoDTO> getContratoEmprestimos() {
		return contratoEmprestimos;
	}
	
	/**
	 * Retorna os emprestimos realizados pelo empregado passado.
	 * @param empregadoRequerente
	 * @return
	 */
	public List<ContratoEmprestimoDTO> getContratoEmprestimos(EmpregadoDTO empregadoRequerente) {
		List<ContratoEmprestimoDTO> emprestimosCliente = new ArrayList<ContratoEmprestimoDTO>();
		
		for(ContratoEmprestimoDTO contrato : getContratoEmprestimos()){
			if( contrato.getEmpregado() != null &&
				(contrato.getEmpregado().getCpf() != null &&  empregadoRequerente.getCpf() != null) &&	
				contrato.getEmpregado().getCpf().equals(empregadoRequerente.getCpf())){
				emprestimosCliente.add(contrato);
				
			}
		}
		
		return emprestimosCliente;
	}
	
	
	public void salvarContratoEmprestimo(ContratoEmprestimoDTO contrato){
		getContratoEmprestimos().add(contrato);
	}
	
	public void salvarContratoEmprestimoRefinanciamento(ContratoEmprestimoDTO contrato){
		
		//Setando o status do emprestimo anterior para inativo pois ele foi refinanciado.
		for(ContratoEmprestimoDTO c:getContratoEmprestimos()){
			if(c.getId_contrato() == contrato.getContratoEmprestimoAnterior().getId_contrato()){
				c.setStatusAtivo(false);
			}
		}
		
		getContratoEmprestimos().add(contrato);
	}

	public List<ContratoEmprestimoDTO> getContratoEmprestimos(
			EnumStatusAnalise enumStatusAnalise) {
		List<ContratoEmprestimoDTO> contratosRetorno = new ArrayList<ContratoEmprestimoDTO>();
		for(ContratoEmprestimoDTO contrato : getContratoEmprestimos()){
			if(contrato.getStatusAnalise() == enumStatusAnalise.getStatusAnalise()){
				contratosRetorno.add(contrato);
			}
			
		}
		return contratosRetorno;
	}

	public void atualizarContratoEmprestimo(ContratoEmprestimoDTO emprestimoDTO) {
		
		for(ContratoEmprestimoDTO c:getContratoEmprestimos()){
			if(
				emprestimoDTO.getId_contrato() > 0 &&
				c.getId_contrato() == emprestimoDTO.getId_contrato()){
				
				getContratoEmprestimos().remove(c);
				getContratoEmprestimos().add(emprestimoDTO);
				break;
			}
		}
		
	}
	
}
