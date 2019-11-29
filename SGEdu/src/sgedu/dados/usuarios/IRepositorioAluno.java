package sgedu.dados.usuarios;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Abaixo temos a interface a ser implementada no repositório de Aluno, 
 * com suas assinaturas de métodos.
 * @author laisy
 */
public interface IRepositorioAluno {
	
	void salvarArquivoAluno() throws IOException;
	
	void buscarArquivoAluno() throws IOException;
	
	void addAluno(Aluno a) throws IOException;
	
	void removerAlunoNome(String nome) throws IOException;
	
	void removerAlunoLogin(String login) throws IOException;
	
	Aluno buscarAlunoNome(String nome);
	
	Aluno buscarAlunoLogin(String login);
	
	void alterarNomeAluno(Aluno aluno) throws IOException;
	
	void alterarSenhaAluno(Aluno aluno) throws IOException;
	
	public ArrayList<Aluno> getAlunos() ;
	
}
