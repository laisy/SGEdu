package sgedu.dados.turma;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.negocios.entidade.turma.Disciplina;

/**
 * Abaixo temos a interface a ser implementada no repositório de Disciplina, 
 * com suas assinaturas de métodos.
 * @author laisy
 */

public interface IRepositorioDisciplina {
	
	void salvarArquivoDisciplina() throws IOException;
	
	void buscarArquivoDisciplina() throws IOException;
	
	void addDisciplina(Disciplina d) throws IOException;
	
	void removerDisciplina(String nome) throws IOException;
	
	Disciplina buscarDisciplina(String nome);
	
	void alterarDisciplina(Disciplina disciplina) throws IOException;
	
	ArrayList<Disciplina> getDisciplinas() ;
	
}
