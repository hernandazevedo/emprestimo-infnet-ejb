package dominio.dto;

import java.io.Serializable;

public class PerfilFuncionarioDTO implements Serializable {

	private int id_perfil;
	private String nome_perfil;
	
	
	
	
	
	public int getId_perfil() {
		return id_perfil;
	}





	public void setId_perfil(int id_perfil) {
		this.id_perfil = id_perfil;
	}





	public String getNome_perfil() {
		return nome_perfil;
	}





	public void setNome_perfil(String nome_perfil) {
		this.nome_perfil = nome_perfil;
	}





	private static final long serialVersionUID = 1L;

}
