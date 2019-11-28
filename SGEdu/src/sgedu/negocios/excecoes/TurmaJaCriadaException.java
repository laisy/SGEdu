package sgedu.negocios.excecoes;

public class TurmaJaCriadaException extends Exception{
	
	public TurmaJaCriadaException(String mensagem) {
		super(mensagem);
	}
	
	public TurmaJaCriadaException() {
		super("Turma já criada! ");
	}
}
