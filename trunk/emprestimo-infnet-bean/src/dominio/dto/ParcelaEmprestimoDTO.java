package dominio.dto;

import java.sql.Date;

public class ParcelaEmprestimoDTO {

	
	private int id_parcela;
	private Double valor;
	private Boolean status;
	private Date vencimento;
	
	public ParcelaEmprestimoDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getId_parcela() {
		return id_parcela;
	}

	public void setId_parcela(int id_parcela) {
		this.id_parcela = id_parcela;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	
	
	
}
