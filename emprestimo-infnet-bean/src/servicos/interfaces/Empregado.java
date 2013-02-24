package servicos.interfaces;

import java.util.List;

import javax.ejb.Remote;

import dominio.dto.ContratoEmprestimoDTO;
import dominio.dto.EmpregadoDTO;

@Remote
public interface Empregado {

	/**
	 * Gerente lista as propostas pendentes de analise.
	 * @param empregadoRequerente
	 * @return
	 */
	List<ContratoEmprestimoDTO> consultarHistoricoRelacionamento(EmpregadoDTO empregadoRequerente) throws Exception;
	
		
}
