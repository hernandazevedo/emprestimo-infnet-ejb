package dominio.dto;

import java.io.Serializable;
import java.util.List;

public class InstituicaoFinanceiraDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private int id_instituicao;
	private List<PlanoEmprestimoDTO> planosEmprestimos;
	private String nome;
	
	//Muitos para muitos... ver EmpresaConvenente
	private List<ConvenioDTO> convenios;
	
	public InstituicaoFinanceiraDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public InstituicaoFinanceiraDTO(int id_instituicao,
			List<PlanoEmprestimoDTO> planosEmprestimos,
			List<ConvenioDTO> convenios) {
		super();
		this.id_instituicao = id_instituicao;
		this.planosEmprestimos = planosEmprestimos;
		this.convenios = convenios;
	}

	


	public InstituicaoFinanceiraDTO(int id_instituicao) {
		super();
		this.id_instituicao = id_instituicao;
	}



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
	public int getId_instituicao() {
		return id_instituicao;
	}
	public void setId_instituicao(int id_instituicao) {
		this.id_instituicao = id_instituicao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
