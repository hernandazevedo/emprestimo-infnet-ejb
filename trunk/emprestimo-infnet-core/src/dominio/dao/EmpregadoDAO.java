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
			EmpregadoDTO e1 = new EmpregadoDTO();
			//TODO preencher os dados do empregado
			empregados.add(e1);
			
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
