package sgedu.negocios.excecoes;

/**
 * Class NotificacaoJaAdicionadaException
 * @author laisy
 * Classe para tratar o erro de Notificacao já enviada.
 * (Extensão da classe Exception (exceção)).
 */

public class NotificacaoJaAdicionadaException extends Exception{
	
	public NotificacaoJaAdicionadaException(String mensagem) {
		super(mensagem);
	}
	
	public NotificacaoJaAdicionadaException() {
		super("Notificação já enviada! ");
	}
}
