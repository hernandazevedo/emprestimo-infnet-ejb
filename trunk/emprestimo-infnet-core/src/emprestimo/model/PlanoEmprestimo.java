package emprestimo.model;


//Ainda modelelando a Classe! NAO CONCLUIDO!
public class PlanoEmprestimo {

	private int id_plano;
	private Boolean status;
	private InstituicaoFinanceira instituicao;
	
	public PlanoEmprestimo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PlanoEmprestimo(int id_plano, Boolean status,
			InstituicaoFinanceira instituicao) {
		super();
		this.id_plano = id_plano;
		this.status = status;
		this.instituicao = instituicao;
	}


	public int getId_plano() {
		return id_plano;
	}

	public void setId_plano(int id_plano) {
		this.id_plano = id_plano;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public InstituicaoFinanceira getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoFinanceira instituicao) {
		this.instituicao = instituicao;
	}
	
	
}
