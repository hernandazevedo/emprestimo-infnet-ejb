package dominio.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dominio.dto.ContratoEmprestimoDTO;

public class CallCenterDAO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3450244970210084606L;
	
	private static CallCenterDAO instance = null;
	
	private List<ContratoEmprestimoDTO> contratoEmprestimos = mockContratoEmprestimos();
	
	private CallCenterDAO(){
		
	}
	
	/**
	 * Mock da lista inicial de emprestimos contratados 
	 * @return
	 */
	
	
	private List<ContratoEmprestimoDTO> mockContratoEmprestimos() {
		
		contratoEmprestimos = new ArrayList<ContratoEmprestimoDTO>();
		return contratoEmprestimos;
	}
	
	
	
	public static CallCenterDAO getInstance(){
		if(instance == null){
			instance = new CallCenterDAO();
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
	
	public void enviaEmprestimoCallCenter(ContratoEmprestimoDTO contratoEmprestimo){
		getContratoEmprestimos().add(contratoEmprestimo);
	}
	
}
