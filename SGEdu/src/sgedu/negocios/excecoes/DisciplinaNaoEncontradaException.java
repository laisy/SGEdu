package sgedu.negocios.excecoes;

/**
 * Class DisciplinaNaoEncontradaException
 * @author laisy
 * Classe para tratar o erro de Disciplina não encontrada nos dados.
 * (Extensão da classe Exception (exceção)).
 */

public class DisciplinaNaoEncontradaException extends Exception{
	
	public DisciplinaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public DisciplinaNaoEncontradaException() {
		super("Disciplina não encontrada! ");
	}


}
