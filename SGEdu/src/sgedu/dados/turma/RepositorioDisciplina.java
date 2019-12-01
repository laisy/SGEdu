package sgedu.dados.turma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sgedu.negocios.entidade.turma.Disciplina;

/**
 * class RepositorioDisciplina
 * @author laisy
 * Abaixo temos a classe para o repositório de Disciplina que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados das Disciplinas adicionadas no sistema; e a implementação da interface IRepositórioDisciplina.
 * 
 */

public class RepositorioDisciplina implements IRepositorioDisciplina {
	
	ArrayList <Disciplina> disciplinas;
	
	public RepositorioDisciplina() {
		disciplinas = new ArrayList<Disciplina>();
	}
	
	/**
	 * Metodo para criar a salvar o arquivo de Disciplinas.
	 */
	public void salvarArquivoDisciplina() throws IOException {
		FileOutputStream file = new FileOutputStream("Disciplinas.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(disciplinas);
		os.close();
	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */
	public void buscarArquivoDisciplina() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Disciplinas.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			disciplinas = (ArrayList<Disciplina>) is.readObject();
			is.close();
			salvarArquivoDisciplina();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoDisciplina();
		}
	}
	
	public void addDisciplina(Disciplina d) throws IOException {
		disciplinas.add(d);
		salvarArquivoDisciplina();
	}
	
	
	public void removerDisciplina(String nome) throws IOException{
		Disciplina d = buscarDisciplina(nome);
		disciplinas.remove(d);
		salvarArquivoDisciplina();
	}
	
	/**
	 * Metodo para buscar Disciplina pelo nome
	 * @param nome da disciplina
	 * @return retorna a disciplina buscada, caso nao encontre retorna null;
	 */
	public Disciplina buscarDisciplina(String nome) {
		for(int i=0; i<disciplinas.size(); i++) {
			if(disciplinas.get(i).getNome().contentEquals(nome)) {
				return disciplinas.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para alterar Disciplina 
	 * @param objeto disciplina alterado
	 */
	public void alterarDisciplina(Disciplina disciplina) throws IOException{ 
		Disciplina d = buscarDisciplina(disciplina.getNome());
		disciplina.setNome(d.getNome());
		salvarArquivoDisciplina();
	}

	public ArrayList<Disciplina> getDisciplinas() {
		try {
			this.buscarArquivoDisciplina();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return disciplinas;
	}
}
