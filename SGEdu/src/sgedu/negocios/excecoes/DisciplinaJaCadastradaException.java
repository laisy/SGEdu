package sgedu.negocios.excecoes;

public class DisciplinaJaCadastradaException extends Exception{
	public DisciplinaJaCadastradaException(String mensagem) {
		super(mensagem);
	}
	
	public DisciplinaJaCadastradaException() {
		super("Disciplina já cadastrada! ");
	}
}
