package sgedu.negocios.excecoes;

/**
 * Class DisciplinaJaCadastradaException
 * @author laisy
 * Classe para tratar o erro de Disciplina já cadastrada.
 * (Extensão da classe Exception (exceção)).
 */
public class DisciplinaJaCadastradaException extends Exception{
	public DisciplinaJaCadastradaException(String mensagem) {
		super(mensagem);
	}
	
	public DisciplinaJaCadastradaException() {
		super("Disciplina já cadastrada! ");
	}
}
