package sgedu.negocios.excecoes;

public class BoletimNaoEncontradoException extends Exception{
	
	public BoletimNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public BoletimNaoEncontradoException() {
		super("Boletim não encontrado! ");
	}

}
