package sgedu.dados.diario;

import java.io.IOException;
import sgedu.negocios.entidade.diario.Avaliacao;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Interface IRepositorioAvaliacao
 * @author laisy
 * Abaixo temos a interface a ser implementada no repositório de Avaliacao, 
 * com suas assinaturas de métodos.
 * 
 */
public interface IRepositorioAvaliacao {
	
	void salvarArquivoAvaliacao() throws IOException;
	
	void buscarArquivoAvaliacao() throws IOException;
	
	void addAvaliacao(Avaliacao a) throws IOException;
	
	Avaliacao buscaAvaliacaoAluno(Aluno aluno, Disciplina disciplina, int ano);
	
	void removerAvaliacao(Aluno aluno, Disciplina disciplina, int ano) throws IOException;
	
	void editarAvaliacao(Avaliacao ava) throws IOException;

}
