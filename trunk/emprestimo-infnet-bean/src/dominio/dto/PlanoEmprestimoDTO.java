package dominio.dto;

import java.io.Serializable;

public class PlanoEmprestimoDTO  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String nome_plano;
	private int numero_min_parcelas;
	private int numero_max_parcelas;
	private double taxa_anual_juros;
	private double comissao_correspondente_bancario;
	
	public PlanoEmprestimoDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNome_plano() {
		return nome_plano;
	}

	public void setNome_plano(String nome_plano) {
		this.nome_plano = nome_plano;
	}

	public int getNumero_min_parcelas() {
		return numero_min_parcelas;
	}

	public void setNumero_min_parcelas(int numero_min_parcelas) {
		this.numero_min_parcelas = numero_min_parcelas;
	}

	public int getNumero_max_parcelas() {
		return numero_max_parcelas;
	}

	public void setNumero_max_parcelas(int numero_max_parcelas) {
		this.numero_max_parcelas = numero_max_parcelas;
	}

	public double getTaxa_anual_juros() {
		return taxa_anual_juros;
	}

	public void setTaxa_anual_juros(double taxa_anual_juros) {
		this.taxa_anual_juros = taxa_anual_juros;
	}

	public double getComissao_correspondente_bancario() {
		return comissao_correspondente_bancario;
	}

	public void setComissao_correspondente_bancario(
			double comissao_correspondente_bancario) {
		this.comissao_correspondente_bancario = comissao_correspondente_bancario;
	}
	
	

}
