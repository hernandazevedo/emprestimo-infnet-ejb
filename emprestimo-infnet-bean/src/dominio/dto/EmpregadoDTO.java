package dominio.dto;

import java.io.Serializable;
import java.util.List;

public class EmpregadoDTO implements Serializable{
	
	private int id_empregado;
	private String nome;
	private boolean ativo;
	private List<ContratoEmprestimoDTO> contratos;
	
	
	
	
	public EmpregadoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public EmpregadoDTO(int id_empregado, String nome, boolean ativo) {
		super();
		this.id_empregado = id_empregado;
		this.nome = nome;
		this.ativo = ativo;
	}





	public EmpregadoDTO(int id_empregado, String nome, boolean ativo,
			List<ContratoEmprestimoDTO> contratos) {
		super();
		this.id_empregado = id_empregado;
		this.nome = nome;
		this.ativo = ativo;
		this.contratos = contratos;
	}



	public boolean getAtivo() {
		return ativo;
	}



	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}



	public List<ContratoEmprestimoDTO> getContratos() {
		return contratos;
	}



	public void setContratos(List<ContratoEmprestimoDTO> contratos) {
		this.contratos = contratos;
	}



	public int getId_empregado() {
		return id_empregado;
	}



	public void setId_empregado(int id_empregado) {
		this.id_empregado = id_empregado;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	private static final long serialVersionUID = 1L;

}
