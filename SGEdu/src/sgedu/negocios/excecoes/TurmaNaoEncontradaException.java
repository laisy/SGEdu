package sgedu.negocios.excecoes;

/**
 * Class TurmaNaoEncontradaException
 * @author laisy
 * Classe para tratar o erro de Turma não encontrada nos dados.
 * (Extensão da classe Exception (exceção)).
 */
public class TurmaNaoEncontradaException extends Exception {
	
	public TurmaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaNaoEncontradaException() {
		super("Turma não encontrada! ");
	}
}
