package sgedu.dados.usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Abaixo temos a classe para o repositório de Aluno que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados dos Alunos matriculados no sistema; e a implementação da interface IRepositórioAluno.
 * @author laisy
 */

public class RepositorioAluno implements IRepositorioAluno{
	
	ArrayList <Aluno> alunos;
	
	public RepositorioAluno() {
		alunos = new ArrayList<Aluno>();
	}
	
	/**
	 * Metodo para criar a salvar o arquivo de Alunos.
	 */
	public void salvarArquivoAluno() throws IOException {
		FileOutputStream file = new FileOutputStream("Alunos.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(alunos);
		os.close();
	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */

	public void buscarArquivoAluno() throws IOException {
		try {
			FileInputStream file = new FileInputStream("Alunos.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			alunos = (ArrayList<Aluno>) is.readObject();
			is.close();
			salvarArquivoAluno();
		} catch (IOException | ClassNotFoundException e) {
			salvarArquivoAluno();
		}
		
	}
	
	public void addAluno(Aluno a) throws IOException{
		alunos.add(a);
		salvarArquivoAluno();
		
	}
	
	/**
	 * Metodo para remover Aluno passando so o nome
	 * @param nome do Aluno
	 */
	public void removerAlunoNome(String nome) throws IOException{
		Aluno a = buscarAlunoNome(nome);
		
		alunos.remove(a);
		salvarArquivoAluno();
	}
	
	/**
	 * Metodo para remover Aluno passando o login
	 * @param login do Aluno
	 */
	public void removerAlunoLogin(String login) throws IOException{
		Aluno a = buscarAlunoLogin(login);
		
		alunos.remove(a);
		salvarArquivoAluno();
	}
	
	/**
	 * Metodo para buscar Aluno pelo nome
	 * @param nome do Aluno
	 * @return retorna o Aluno buscado, caso nao encontre retorna null;
	 */
	public Aluno buscarAlunoNome(String nome){
		for(int i=0; i<alunos.size(); i++) {
			if(alunos.get(i).getNome().contentEquals(nome)) {
				return alunos.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	/**
	 * Metodo para buscar Aluno pelo login
	 * @param login do Aluno
	 * @return retorna o Aluno buscado, caso nao encontre retorna null;
	 */
	public Aluno buscarAlunoLogin(String login){
		for(int i=0; i<alunos.size(); i++) {
			if(alunos.get(i).getLogin().contentEquals(login)) {
				return alunos.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para alterar nome do Aluno
	 * @param objeto Aluno alterado
	 */
	public void alterarNomeAluno(Aluno aluno) throws IOException{ 
		Aluno a = buscarAlunoLogin(aluno.getLogin());
		
		aluno.setNome(a.getNome());
		salvarArquivoAluno();
	}
	
	/**
	 * Metodo para alterar senha do Aluno
	 * @param objeto Aluno alterado
	 */
	public void alterarSenhaAluno(Aluno aluno) throws IOException{ 
		Aluno a = buscarAlunoLogin(aluno.getLogin());
		
		aluno.setSenha(a.getSenha());
		salvarArquivoAluno();
	}
	
}