package servicos.interfaces;

import java.io.Serializable;

public interface Mensageiro extends Serializable {
	
	void enviarMensagemTextoParaFila(String mensagem);
	void enviarMensagemObjetoParaFila(Serializable object);
}
