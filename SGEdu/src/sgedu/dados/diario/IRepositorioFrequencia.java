package sgedu.dados.diario;

import java.io.IOException;
import sgedu.negocios.entidade.diario.Frequencia;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Abaixo temos a interface a ser implementada no repositório de Frequencia, 
 * com suas assinaturas de métodos.
 * @author laisy
 */

public interface IRepositorioFrequencia {
	
	void salvarArquivoFrequencia() throws IOException;
	
	void buscarArquivoFrequencia() throws IOException;
	
	public void addFrequencia(Frequencia f) throws IOException;
	
	Frequencia buscaFrequenciaAluno(Aluno aluno, Disciplina disciplina, int ano);
	
	public Frequencia buscaFrequencia(Frequencia f);
	
	public void removerFrequencia(Aluno aluno, Disciplina disciplina, int ano) throws IOException;

}
