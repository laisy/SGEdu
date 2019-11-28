package sgedu.negocios.excecoes;

public class UsuarioNaoEncontradoException extends Exception{
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException() {
		super("Usuario não encontrado! ");
	}

}
