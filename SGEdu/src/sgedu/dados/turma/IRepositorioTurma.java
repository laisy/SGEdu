package sgedu.dados.turma;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.negocios.entidade.turma.Turma;

/**
 * Interface IRepositorioTurma
 * @author laisy
 * Abaixo temos a interface a ser implementada no repositório de Turma, 
 * com suas assinaturas de métodos.
 * 
 */

public interface IRepositorioTurma {
	
	void salvarArquivoTurma() throws IOException;
	
	void buscarArquivoTurma() throws IOException;
	
	void addTurma(Turma t) throws IOException;
	
	void removerTurma(String nome, int ano) throws IOException;
	
	Turma buscarTurma(String nome, int ano);
	
	void alterarTurma(Turma turma) throws IOException;
	
	ArrayList<Turma> getTurmas();
}
