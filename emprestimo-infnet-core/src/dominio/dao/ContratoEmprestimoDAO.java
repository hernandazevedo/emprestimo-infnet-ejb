package dominio.dao;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import servicos.enums.EnumStatusAnalise;

import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.ConvenioDTO;
import dominio.dto.EmpregadoDTO;
import dominio.dto.EmpresaConvenenteDTO;
import dominio.dto.FuncionarioDTO;
import dominio.dto.InstituicaoFinanceiraDTO;
import dominio.dto.PerfilFuncionarioDTO;
import dominio.dto.PlanoEmprestimoDTO;

public class ContratoEmprestimoDAO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3450244970210084606L;
	
	private static ContratoEmprestimoDAO instance = null;
	
	private List<ContratoEmprestimoDTO> contratoEmprestimos = mockContratoEmprestimos2();
	
	private ContratoEmprestimoDAO(){
		
	}
	
	/**
	 * Mock da lista inicial de emprestimos contratados 
	 * @return
	 */
	
	
	
	
	
	private List<ContratoEmprestimoDTO> mockContratoEmprestimos2() {
		
		ContratoEmprestimoDTO c1 = new ContratoEmprestimoDTO();
		//Criano contrato 1
		c1.setDataStatusAnalise(new java.util.Date(2013, 01, 15));
			//Criando Empregado
			EmpregadoDTO e1 = new EmpregadoDTO();
			e1.setAtivo(true);
			e1.setCpf("14210417742");
			e1.setData_nascimento(new Date(1989, 9, 11));
			e1.setEmpresa(new EmpresaConvenenteDTO());
			e1.setEndereco("Avenida Teste");
			e1.setFilhacao("filhacao teste");
			e1.setId_empregado(1);
			e1.setMatricula("as12333");
			e1.setNome("William Vinco");
			e1.setRg("asd1233");
			e1.setSalario(2000);
			e1.setTelefone("2222-2222");
			
		c1.setEmpregado(e1);
			//Funcionario do contrato
			FuncionarioDTO f1 = new FuncionarioDTO();
			f1.setId_funcionario(1);
			f1.setNome("nome teste funcionario");
				//Perfil do contrato
				PerfilFuncionarioDTO p1 = new PerfilFuncionarioDTO();
				p1.setIdPerfil(1);
				p1.setNomePerfil("perfil teste");
			
			f1.setPerfil(p1);
			
		c1.setFuncionarioAnalise(f1);
		c1.setId_contrato(123);
		//Criando Instituiçação para contrato
		InstituicaoFinanceiraDTO i1 = new InstituicaoFinanceiraDTO();
			ConvenioDTO conv1 = new ConvenioDTO();
			ConvenioDTO conv2 = new ConvenioDTO();
			ConvenioDTO conv3 = new ConvenioDTO();
			ConvenioDTO conv4 = new ConvenioDTO();
				List<ConvenioDTO> convenios = new ArrayList<ConvenioDTO>();
				convenios.add(conv1);
				convenios.add(conv2);
				convenios.add(conv3);
				convenios.add(conv4);
		i1.setConvenios(convenios);
		i1.setId_instituicao(1);
			List<PlanoEmprestimoDTO> planos = new ArrayList<PlanoEmprestimoDTO>();
			PlanoEmprestimoDTO plan1 = new PlanoEmprestimoDTO();
			plan1.setComissao_correspondente_bancario(10);
			plan1.setId_plano(1);
			plan1.setNome_plano("teste plano 1");
			plan1.setNumero_max_parcelas(20);
			plan1.setNumero_min_parcelas(10);
			plan1.setTaxa_anual_juros(20);

			PlanoEmprestimoDTO plan2 = new PlanoEmprestimoDTO();
			plan2.setComissao_correspondente_bancario(5);
			plan2.setId_plano(2);
			plan2.setNome_plano("teste plano 2");
			plan2.setNumero_max_parcelas(7);
			plan2.setNumero_min_parcelas(3);
			plan2.setTaxa_anual_juros(2);
			
			PlanoEmprestimoDTO plan3 = new PlanoEmprestimoDTO();
			plan3.setComissao_correspondente_bancario(56);
			plan3.setId_plano(3);
			plan3.setNome_plano("teste plano 3");
			plan3.setNumero_max_parcelas(56);
			plan3.setNumero_min_parcelas(34);
			plan3.setTaxa_anual_juros(32);
			
			PlanoEmprestimoDTO plan4 = new PlanoEmprestimoDTO();
			plan4.setComissao_correspondente_bancario(86);
			plan4.setId_plano(4);
			plan4.setNome_plano("teste plano 4");
			plan4.setNumero_max_parcelas(76);
			plan4.setNumero_min_parcelas(23);
			plan4.setTaxa_anual_juros(23);
			
			planos.add(plan1);
			planos.add(plan2);
			planos.add(plan3);
			planos.add(plan4);
			
	i1.setPlanosEmprestimos(planos);
	c1.setInstituicao(i1);
	c1.setNome_corretor("Nome do Corretor");
	c1.setPlano(plan2);
	c1.setRefinanciamentoHabilitado(true);
	c1.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
//	c1.setStatusAnalise(1);
	c1.setStatusAtivo(true);
	//Contrato 2
	ContratoEmprestimoDTO c2 = new ContratoEmprestimoDTO();
	c2.setDataStatusAnalise(new java.util.Date(2000, 2, 11));
	
		EmpregadoDTO e2 = new EmpregadoDTO();
		e2.setAtivo(true);
		e2.setCpf("12352121");
		e2.setData_nascimento(new Date(1990, 2, 1));
		e2.setEmpresa(new EmpresaConvenenteDTO());
		e2.setEndereco("endereco teste");
		e2.setFilhacao("Filhacao teste 2");
		e2.setId_empregado(2);
		e2.setMatricula("643gsg2 matricula 2");
		e2.setNome("Empregado 2 teste");
		e2.setRg("esr23421341 rg");
		e2.setSalario(21342);
		e2.setTelefone("3333333");
		
	c2.setEmpregado(e2);
	c2.setFuncionarioAnalise(new FuncionarioDTO());
	c2.setId_contrato(2);
	
	InstituicaoFinanceiraDTO i2 = new InstituicaoFinanceiraDTO();
	convenios.remove(1);
	i2.setConvenios(convenios);
	i2.setId_instituicao(2);
	planos.remove(0);
	i2.setPlanosEmprestimos(planos);
	c2.setInstituicao(i2);
	c2.setNome_corretor("Nome corretor 2");
	c2.setPlano(plan4);
	c2.setRefinanciamentoHabilitado(true);
	c2.setStatusAnalise(EnumStatusAnalise.APROVADA);
	c2.setStatusAnalise(1);
	c2.setStatusAtivo(true);
	
	List<ContratoEmprestimoDTO> contratos = new ArrayList<ContratoEmprestimoDTO>();
	contratos.add(c1);
	contratos.add(c2);	
	
	
	
//	mockContratoEmprestimos(contratos);
	return contratos;
	}
	
	private void mockContratoEmprestimos(List<ContratoEmprestimoDTO> contratoEmprestimos) {
		
		if(contratoEmprestimos == null){
			contratoEmprestimos = new ArrayList<ContratoEmprestimoDTO>();
		}
			//TODO SETAR OS ATRIBUTOS EM CADA um
			ContratoEmprestimoDTO c1 = new ContratoEmprestimoDTO();
			c1.setStatusAnalise(EnumStatusAnalise.PENDENTE_ANALISE);
			ContratoEmprestimoDTO c2 = new ContratoEmprestimoDTO();
			EmpregadoDTO e = new EmpregadoDTO();
			e.setAtivo(true);
			e.setCpf("05823562705");
			c2.setEmpregado(e);
			ContratoEmprestimoDTO c3 = new ContratoEmprestimoDTO();
			ContratoEmprestimoDTO c4 = new ContratoEmprestimoDTO();
			
			//TODO preencher os dados do empregado
			contratoEmprestimos.add(c1);
			contratoEmprestimos.add(c2);
			contratoEmprestimos.add(c3);
			contratoEmprestimos.add(c4);
			
		
	}
	
	
	
	public static ContratoEmprestimoDAO getInstance(){
		if(instance == null){
			instance = new ContratoEmprestimoDAO();
		}
		return instance;
	}
	
	/**
	 * Retorna os emprestimos
	 * @return
	 */
	public List<ContratoEmprestimoDTO> getContratoEmprestimos() {
		return contratoEmprestimos;
	}
	
	/**
	 * Retorna os emprestimos realizados pelo empregado passado.
	 * @param empregadoRequerente
	 * @return
	 */
	public List<ContratoEmprestimoDTO> getContratoEmprestimos(EmpregadoDTO empregadoRequerente) {
		List<ContratoEmprestimoDTO> emprestimosCliente = new ArrayList<ContratoEmprestimoDTO>();
		
		for(ContratoEmprestimoDTO contrato : getContratoEmprestimos()){
			if( contrato.getEmpregado() != null &&
				(contrato.getEmpregado().getCpf() != null &&  empregadoRequerente.getCpf() != null) &&	
				contrato.getEmpregado().getCpf().equals(empregadoRequerente.getCpf())){
				emprestimosCliente.add(contrato);
				
			}
		}
		
		return emprestimosCliente;
	}
	
	
	public void salvarContratoEmprestimo(ContratoEmprestimoDTO contrato){
		getContratoEmprestimos().add(contrato);
	}
	
	public void salvarContratoEmprestimoRefinanciamento(ContratoEmprestimoDTO contrato){
		
		//Setando o status do emprestimo anterior para inativo pois ele foi refinanciado.
		for(ContratoEmprestimoDTO c:getContratoEmprestimos()){
			if(c.getId_contrato() == contrato.getContratoEmprestimoAnterior().getId_contrato()){
				c.setStatusAtivo(false);
			}
		}
		
		getContratoEmprestimos().add(contrato);
	}

	public List<ContratoEmprestimoDTO> getContratoEmprestimos(
			EnumStatusAnalise enumStatusAnalise) {
		List<ContratoEmprestimoDTO> contratosRetorno = new ArrayList<ContratoEmprestimoDTO>();
		for(ContratoEmprestimoDTO contrato : getContratoEmprestimos()){
			if(contrato.getStatusAnalise() == enumStatusAnalise.getStatusAnalise()){
				contratosRetorno.add(contrato);
			}
			
		}
		return contratosRetorno;
	}

	public void atualizarContratoEmprestimo(ContratoEmprestimoDTO emprestimoDTO) {
		
		for(ContratoEmprestimoDTO c:getContratoEmprestimos()){
			if(
				emprestimoDTO.getId_contrato() > 0 &&
				c.getId_contrato() == emprestimoDTO.getId_contrato()){
				
				getContratoEmprestimos().remove(c);
				getContratoEmprestimos().add(emprestimoDTO);
				break;
			}
		}
		
	}
	
}
