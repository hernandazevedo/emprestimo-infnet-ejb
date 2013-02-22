package dominio.dto;

import java.io.Serializable;

public class FuncionarioDTO  implements Serializable{

	
	private int id_funcionario;
	private String nome;
	private PerfilFuncionarioDTO perfil;
	
	
	
	
	public PerfilFuncionarioDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilFuncionarioDTO perfil) {
		this.perfil = perfil;
	}
	public int getId_funcionario() {
		return id_funcionario;
	}



	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	private static final long serialVersionUID = 1L;

}
