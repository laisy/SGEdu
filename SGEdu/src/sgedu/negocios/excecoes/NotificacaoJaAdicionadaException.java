package sgedu.negocios.excecoes;

public class NotificacaoJaAdicionadaException extends Exception{
	
	public NotificacaoJaAdicionadaException(String mensagem) {
		super(mensagem);
	}
	
	public NotificacaoJaAdicionadaException() {
		super("Notificação já adicionada! ");
	}
}
