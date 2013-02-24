package dominio.entidades;

import java.util.List;

public class Cliente {
	
	private int id_cliente;
	private String nome;
	List<PlanoEmprestimo> planoEmprestimo;
	
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}


	
	public Cliente(int id_cliente, String nome,
			List<PlanoEmprestimo> planoEmprestimo) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.planoEmprestimo = planoEmprestimo;
	}

	
	


	public Cliente(int id_cliente, String nome) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
	}



	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<PlanoEmprestimo> getPlanoEmprestimo() {
		return planoEmprestimo;
	}


	public void setPlanoEmprestimo(List<PlanoEmprestimo> planoEmprestimo) {
		this.planoEmprestimo = planoEmprestimo;
	}
	
	

}
