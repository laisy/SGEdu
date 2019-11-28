package sgedu.negocios.excecoes;

public class TurmaNaoEncontradaException extends Exception {
	
	public TurmaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaNaoEncontradaException() {
		super("Turma não encontrada! ");
	}
}
