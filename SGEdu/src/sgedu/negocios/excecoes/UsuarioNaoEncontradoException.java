package sgedu.negocios.excecoes;

/**
 * Class UsuarioNaoEncontradoException
 * @author laisy
 * Classe para tratar o erro de Usuario não encontrado nos dados.
 * (Extensão da classe Exception (exceção)).
 */

public class UsuarioNaoEncontradoException extends Exception{
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException() {
		super("Usuario não encontrado! ");
	}

}
