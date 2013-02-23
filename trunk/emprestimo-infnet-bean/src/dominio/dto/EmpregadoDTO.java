package dominio.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class EmpregadoDTO implements Serializable{
	
	private int id_empregado;
	private String nome;
	private boolean ativo;
	private List<ContratoEmprestimoDTO> contratos;
	
	private String cpf;
	private String rg;
	private String filhacao;
	private Date data_nascimento;
	private String endereco;
	private String telefone;
	private EmpresaConvenenteDTO empresa;
	private String matricula;
	private double salario;
	
	
	
	
	
	public String getMatricula() {
		return matricula;
	}





	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}





	public double getSalario() {
		return salario;
	}





	public void setSalario(double salario) {
		this.salario = salario;
	}





	public String getCpf() {
		return cpf;
	}





	public void setCpf(String cpf) {
		this.cpf = cpf;
	}





	public String getRg() {
		return rg;
	}





	public void setRg(String rg) {
		this.rg = rg;
	}





	public String getFilhacao() {
		return filhacao;
	}





	public void setFilhacao(String filhacao) {
		this.filhacao = filhacao;
	}





	public Date getData_nascimento() {
		return data_nascimento;
	}





	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}





	public String getEndereco() {
		return endereco;
	}





	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}





	public String getTelefone() {
		return telefone;
	}





	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}





	public EmpresaConvenenteDTO getEmpresa() {
		return empresa;
	}





	public void setEmpresa(EmpresaConvenenteDTO empresa) {
		this.empresa = empresa;
	}





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
