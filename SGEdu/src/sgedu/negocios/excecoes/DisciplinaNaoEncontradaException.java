package sgedu.negocios.excecoes;

public class DisciplinaNaoEncontradaException extends Exception{
	
	public DisciplinaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public DisciplinaNaoEncontradaException() {
		super("Disciplina não encontrada! ");
	}


}
