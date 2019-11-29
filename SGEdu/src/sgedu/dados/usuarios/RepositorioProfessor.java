package sgedu.dados.usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Professor;

/**
 * Abaixo temos a classe para o repositório de Professor que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados dos Professores adicionados no sistema; e a implementação da interface IRepositorioProfessor.
 * @author laisy
 */
public class RepositorioProfessor implements IRepositorioProfessor{
	ArrayList <Professor> professores;
	
	
	public RepositorioProfessor() {
		professores = new ArrayList<Professor>();
	}
	
	/**
	 * Metodo para criar a salvar o arquivo de Professores.
	 */

	public void salvarArquivoProfessor() throws IOException {
		FileOutputStream file = new FileOutputStream("Professores.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(professores);
		os.close();
	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */

	public void buscarArquivoProfessor() throws IOException{
		try{
			FileInputStream file = new FileInputStream("Professores.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			professores = (ArrayList<Professor>) is.readObject();
			is.close();
			salvarArquivoProfessor();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoProfessor();
		}
		
	}

	public void addProfessor(Professor p) throws IOException{
		professores.add(p);
		salvarArquivoProfessor();
	}
	
	/**
	 * Metodo para remover Professor passando so o nome
	 * @param nome do Professor
	 */
	public void removerProfessorNome(String nome) throws IOException {
		Professor p = buscarProfessorNome(nome);
		
		professores.remove(p);
		salvarArquivoProfessor();
	}
	
	/**
	 * Metodo para remover Professor passando o login
	 * @param login do Professor
	 */
	public void removerProfessorLogin(String login) throws IOException {
		Professor p = buscarProfessorLogin(login);
		
		professores.remove(p);
		salvarArquivoProfessor();

	}
	
	/**
	 * Metodo para buscar Professor pelo nome
	 * @param nome do Professor
	 * @return retorna o Professor buscado, caso nao encontre retorna null;
	 */
	public Professor buscarProfessorNome(String nome) {
		for(int i=0; i<professores.size(); i++) {
			if(professores.get(i).getNome().contentEquals(nome)) {
				return professores.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para buscar Professor pelo login
	 * @param login do Professor
	 * @return retorna o Professor buscado, caso nao encontre retorna null;
	 */
	public Professor buscarProfessorLogin(String login) {
		for(int i=0; i<professores.size(); i++) {
			if(professores.get(i).getLogin().contentEquals(login)) {
				return professores.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para alterar senha do Professor
	 * @param objeto Professor alterado
	 */
	public void alterarSenhaProfessor(Professor professor) throws IOException{ 
		Professor p = buscarProfessorLogin(professor.getLogin());
		
		professor.setSenha(p.getSenha());
		salvarArquivoProfessor();
	}
	
	/**
	 * Metodo para alterar nome do Professor
	 * @param objeto Professor alterado
	 */
	public void alterarNomeProfessor(Professor professor) throws IOException{ 
		Professor p = buscarProfessorLogin(professor.getLogin());
		
		professor.setNome(p.getNome());
		salvarArquivoProfessor();
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}
}