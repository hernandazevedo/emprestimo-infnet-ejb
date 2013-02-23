package dominio.dto;

import java.io.Serializable;
import java.util.List;

public class EmpresaConvenenteDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Um para muitos
	private List<FuncionarioDTO> funcionarios;
	//Muitos para muitos... ver InstituicaoFinanceira
	private List<ConvenioDTO> convenios;
	public List<FuncionarioDTO> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<FuncionarioDTO> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public List<ConvenioDTO> getConvenios() {
		return convenios;
	}
	public void setConvenios(List<ConvenioDTO> convenios) {
		this.convenios = convenios;
	}
	
	

}
