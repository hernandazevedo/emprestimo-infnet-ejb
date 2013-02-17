package emprestimo.exeptions;

import javax.ejb.EJBException;

import servicos.enums.EnumMensagemRetorno;

public class BusinessException extends EJBException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1544918813234214243L;
	
	

	public BusinessException() {
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String msg) {
		super(msg);
	}
	
	
	
}
