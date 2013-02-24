package dominio.dto;

import java.io.Serializable;
import java.util.Date;

import servicos.enums.EnumStatusAnalise;

public class ContratoEmprestimoDTO implements Serializable{
	
	//Informacao necessaria ao refinanciamento.
	private ContratoEmprestimoDTO contratoEmprestimoAnterior;
	
	private int id_contrato;
	private EmpregadoDTO empregado;
	private InstituicaoFinanceiraDTO instituicao;
	private PlanoEmprestimoDTO plano;
	private String nome_corretor;
	private boolean statusAtivo;	
	private boolean refinanciamentoHabilitado;
	private Integer statusAnalise;
	private String descricaoStatusAnalise;
	private Date dataStatusAnalise;
	private FuncionarioDTO funcionarioAnalise;
	
	
	public ContratoEmprestimoDTO(int id_contrato, EmpregadoDTO empregado,
			InstituicaoFinanceiraDTO instituicao, PlanoEmprestimoDTO plano) {
		super();
		this.id_contrato = id_contrato;
		this.empregado = empregado;
		this.instituicao = instituicao;
		this.plano = plano;
	}

	public PlanoEmprestimoDTO getPlano() {
		return plano;
	}

	public void setPlano(PlanoEmprestimoDTO plano) {
		this.plano = plano;
	}

	public ContratoEmprestimoDTO(int id_contrato, EmpregadoDTO empregado,
			InstituicaoFinanceiraDTO instituicao) {
		super();
		this.id_contrato = id_contrato;
		this.empregado = empregado;
		this.instituicao = instituicao;
	}

	public EmpregadoDTO getEmpregado() {
		return empregado;
	}

	public void setEmpregado(EmpregadoDTO empregado) {
		this.empregado = empregado;
	}

	public InstituicaoFinanceiraDTO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoFinanceiraDTO instituicao) {
		this.instituicao = instituicao;
	}

	public ContratoEmprestimoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(int id_contrato) {
		this.id_contrato = id_contrato;
	}


	public String getNome_corretor() {
		return nome_corretor;
	}

	public void setNome_corretor(String nome_corretor) {
		this.nome_corretor = nome_corretor;
	}

	

	public boolean isStatusAtivo() {
		return statusAtivo;
	}

	public void setStatusAtivo(boolean statusAtivo) {
		this.statusAtivo = statusAtivo;
	}
	

	private static final long serialVersionUID = 1L;

	//TODO colocar os campos de emprestimo
	
	
	public ContratoEmprestimoDTO getContratoEmprestimoAnterior() {
		return contratoEmprestimoAnterior;
	}
	
	public void setContratoEmprestimoAnterior(
			ContratoEmprestimoDTO contratoEmprestimoAnterior) {
		this.contratoEmprestimoAnterior = contratoEmprestimoAnterior;
	}
	
	public boolean getRefinanciamentoHabilitado() {
		return refinanciamentoHabilitado;
	}
	
	public void setRefinanciamentoHabilitado(boolean refinanciamentoHabilitado) {
		this.refinanciamentoHabilitado = refinanciamentoHabilitado;
	}
	
	public Integer getStatusAnalise() {
		return statusAnalise;
	}
	
	public void setStatusAnalise(Integer statusAnalise) {
		this.statusAnalise = statusAnalise;
	}
	
	public void setStatusAnalise(EnumStatusAnalise enumStatusAnalise) {
		this.statusAnalise = enumStatusAnalise.getStatusAnalise();
		this.descricaoStatusAnalise = enumStatusAnalise.getDescricaoAnalise();
	}
	
	public String getDescricaoStatusAnalise() {
		if(descricaoStatusAnalise == null){
			if(statusAnalise != null){
				for(EnumStatusAnalise e : EnumStatusAnalise.values()){
					if(e.getStatusAnalise().intValue() == statusAnalise){
						descricaoStatusAnalise = e.getDescricaoAnalise();
						break;
					}
				}
			}
		}
		return descricaoStatusAnalise;
	}
	public Date getDataStatusAnalise() {
		return dataStatusAnalise;
	}
	
	public void setDataStatusAnalise(Date dataStatusAnalise) {
		this.dataStatusAnalise = dataStatusAnalise;
	}	
	
	public FuncionarioDTO getFuncionarioAnalise() {
		return funcionarioAnalise;
	}
	
	public void setFuncionarioAnalise(FuncionarioDTO funcionarioAnalise) {
		this.funcionarioAnalise = funcionarioAnalise;
	}
}
