package dominio.dto;

import java.io.Serializable;

import servicos.enums.EnumPerfilFuncionario;

public class PerfilFuncionarioDTO implements Serializable {

	private int idPerfil;
	private String nomePerfil;
	private static final long serialVersionUID = 1L;
	
	public PerfilFuncionarioDTO() {
	}
	
	public PerfilFuncionarioDTO(EnumPerfilFuncionario enumPerfilFuncionario){
		this.idPerfil = enumPerfilFuncionario.getIdPerfil();
		this.nomePerfil = enumPerfilFuncionario.getNomePerfil();
	}
	
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getNomePerfil() {
		return nomePerfil;
	}
	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
	

}
