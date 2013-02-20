package dominio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dominio.dto.EmpregadoDTO;

public class EmpregadoDAO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3450244970210084606L;
	
	private static EmpregadoDAO instance = null;
	
	private List<EmpregadoDTO> empregados = mockEmpregados();
	
	private EmpregadoDAO(){
		
	}
	
	/**
	 * Mock da lista inicial de emprestimos contratados 
	 * @return
	 */
	private List<EmpregadoDTO> mockEmpregados() {

		if(empregados == null){
			empregados = new ArrayList<EmpregadoDTO>();
			//TODO SETAR OS ATRIBUTOS EM CADA
			EmpregadoDTO e1 = new EmpregadoDTO();
			EmpregadoDTO e2 = new EmpregadoDTO();
			EmpregadoDTO e3 = new EmpregadoDTO();
			EmpregadoDTO e4 = new EmpregadoDTO();
			//TODO preencher os dados do empregado
			empregados.add(e1);
			empregados.add(e2);
			empregados.add(e3);
			empregados.add(e4);
			
		}
		return empregados;
	}
	
	
	
	public static EmpregadoDAO getInstance(){
		if(instance == null){
			instance = new EmpregadoDAO();
		}
		return instance;
	}
	
	
	public List<EmpregadoDTO> getEmpregados() {
		return empregados;
	}
	
	
	public void salvarContratoEmprestimo(EmpregadoDTO e){
		getEmpregados().add(e);
	}
	
}
