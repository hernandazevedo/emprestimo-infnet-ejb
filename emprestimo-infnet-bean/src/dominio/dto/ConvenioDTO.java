package dominio.dto;

import java.io.Serializable;

public class ConvenioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmpresaConvenenteDTO empresaConvenenteDTO;
	private InstituicaoFinanceiraDTO instituicaoFinanceiraDTO;
	
	
	public EmpresaConvenenteDTO getEmpresaConvenenteDTO() {
		return empresaConvenenteDTO;
	}
	public void setEmpresaConvenenteDTO(EmpresaConvenenteDTO empresaConvenenteDTO) {
		this.empresaConvenenteDTO = empresaConvenenteDTO;
	}
	public InstituicaoFinanceiraDTO getInstituicaoFinanceiraDTO() {
		return instituicaoFinanceiraDTO;
	}
	public void setInstituicaoFinanceiraDTO(
			InstituicaoFinanceiraDTO instituicaoFinanceiraDTO) {
		this.instituicaoFinanceiraDTO = instituicaoFinanceiraDTO;
	}
	
	
	
}
