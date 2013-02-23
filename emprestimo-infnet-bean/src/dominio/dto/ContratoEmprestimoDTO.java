package dominio.dto;

import java.io.Serializable;

public class ContratoEmprestimoDTO implements Serializable{
	
	
	private int id_contrato;
	private Boolean ativo;
	
	
	
	public ContratoEmprestimoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ContratoEmprestimoDTO(int id_contrato, Boolean ativo) {
		super();
		this.id_contrato = id_contrato;
		this.ativo = ativo;
	}

	public int getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}



	private static final long serialVersionUID = 1L;

	//TODO colocar os campos de emprestimo
	
}
