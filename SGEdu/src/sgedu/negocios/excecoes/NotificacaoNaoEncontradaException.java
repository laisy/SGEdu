package sgedu.negocios.excecoes;

public class NotificacaoNaoEncontradaException extends Exception{

	public NotificacaoNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public NotificacaoNaoEncontradaException() {
		super("Notificação não encontrada! ");
	}
}
