package dominio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dominio.dto.ContratoEmprestimoDTO;

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
			ContratoEmprestimoDTO c2 = new ContratoEmprestimoDTO();
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
	
	
	public List<ContratoEmprestimoDTO> getContratoEmprestimos() {
		return contratoEmprestimos;
	}
	
	
	public void salvarContratoEmprestimo(ContratoEmprestimoDTO contrato){
		getContratoEmprestimos().add(contrato);
	}
	
}
