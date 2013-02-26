package dominio.dto;

import java.io.Serializable;
import java.util.List;

public class EmpresaConvenenteDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<FuncionarioDTO> funcionarios;
	private List<ConvenioDTO> convenios;
	
	public EmpresaConvenenteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public EmpresaConvenenteDTO(List<FuncionarioDTO> funcionarios,
			List<ConvenioDTO> convenios) {
		super();
		this.funcionarios = funcionarios;
		this.convenios = convenios;
	}



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
