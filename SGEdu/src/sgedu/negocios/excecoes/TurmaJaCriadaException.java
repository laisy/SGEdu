package sgedu.negocios.excecoes;

/**
 * Class TurmaJaCriadaException
 * @author laisy
 * Classe para tratar o erro de Turma já criada.
 * (Extensão da classe Exception (exceção)).
 */

public class TurmaJaCriadaException extends Exception{
	
	public TurmaJaCriadaException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaJaCriadaException() {
		super("Turma já criada! ");
	}
}
