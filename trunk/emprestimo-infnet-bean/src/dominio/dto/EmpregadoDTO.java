package dominio.dto;

import java.io.Serializable;
import java.util.List;

public class EmpregadoDTO implements Serializable{
	
	private int id_empregado;
	private String nome;
	private List<ContratoEmprestimoDTO> contratos;
	
	
	
	
	
	
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
