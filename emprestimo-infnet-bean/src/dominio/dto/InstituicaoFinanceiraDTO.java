package dominio.dto;

import java.io.Serializable;
import java.util.List;

public class InstituicaoFinanceiraDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<PlanoEmprestimoDTO> planosEmprestimos;
	//Muitos para muitos... ver EmpresaConvenente
	private List<ConvenioDTO> convenios;
	public List<PlanoEmprestimoDTO> getPlanosEmprestimos() {
		return planosEmprestimos;
	}
	public void setPlanosEmprestimos(List<PlanoEmprestimoDTO> planosEmprestimos) {
		this.planosEmprestimos = planosEmprestimos;
	}
	public List<ConvenioDTO> getConvenios() {
		return convenios;
	}
	public void setConvenios(List<ConvenioDTO> convenios) {
		this.convenios = convenios;
	}
	
	
	
	
}
