package sgedu.negocios.excecoes;

/**
 * Class UsuarioJaCadastradoException
 * @author laisy
 * Classe para tratar o erro de Usuario já cadastrado.
 * (Extensão da classe Exception (exceção)).
 */
public class UsuarioJaCadastradoException extends Exception{
	
	public UsuarioJaCadastradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioJaCadastradoException() {
		super("Usuario já cadastrado! ");
	}
}
