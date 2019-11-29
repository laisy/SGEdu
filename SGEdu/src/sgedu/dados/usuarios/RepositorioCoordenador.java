package sgedu.dados.usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sgedu.negocios.entidade.usuarios.Coordenador;

/**
 * Class RepositorioCoordenador
 * @author laisy
 * Abaixo temos a classe para o repositório de Coordenador que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados dos Coordenadores adicionados no sistema; e a implementação da interface IRepositorioCoordenador.
 * 
 */

public class RepositorioCoordenador implements IRepositorioCoordenador {
	ArrayList <Coordenador> coordenadores;
	
	public RepositorioCoordenador() {
		coordenadores = new ArrayList<Coordenador>();
	}
	
	
	public ArrayList<Coordenador> getCoordenadores() {
		return coordenadores;
	}

	/**
	 * Metodo para criar a salvar o arquivo de Coordenadores.
	 */

	public void salvarArquivoCoordenador() throws IOException {
		FileOutputStream file = new FileOutputStream("Coordenadores.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(coordenadores);
		os.close();

	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */

	public void buscarArquivoCoordenador() throws IOException{
		try{
			FileInputStream file = new FileInputStream("Coordenadores.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			coordenadores = (ArrayList<Coordenador>) is.readObject();
			is.close();
			salvarArquivoCoordenador();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoCoordenador();
		}
		
	}
	
	public void addCoordenador(Coordenador c) throws IOException {
		coordenadores.add(c);
		salvarArquivoCoordenador();
	}
	
	/**
	 * Metodo para remover Coordenador passando so o nome
	 * @param nome do Coordenador
	 */
	public void removerCoordenadorNome(String nome) throws IOException {
		Coordenador c = buscarCoordenadorNome(nome);
		
		coordenadores.remove(c);
		salvarArquivoCoordenador();
	}
	
	/**
	 * Metodo para remover Coordenador passando o login
	 * @param login do Coordenador
	 */
	public void removerCoordenadorLogin(String login) throws IOException{
		Coordenador c = buscarCoordenadorLogin(login);
		
		coordenadores.remove(c);
		salvarArquivoCoordenador();
	}
	
	/**
	 * Metodo para buscar Coordenador pelo nome
	 * @param nome do Coordenador
	 * @return retorna o Coordenador buscado, caso nao encontre retorna null;
	 */
	public Coordenador buscarCoordenadorNome(String nome) {
		for(int i=0; i<coordenadores.size(); i++) {
			if(coordenadores.get(i).getNome().contentEquals(nome)) {
				return coordenadores.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para buscar Coordenador pelo login
	 * @param login do Coordenador
	 * @return retorna o Coordenador buscado, caso nao encontre retorna null;
	 */
	public Coordenador buscarCoordenadorLogin(String login) {
		for(int i=0; i<coordenadores.size(); i++) {
			if(coordenadores.get(i).getLogin().contentEquals(login)) {
				return coordenadores.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para alterar senha do Coordenador
	 * @param objeto Coordenador alterado
	 */
	public void alterarSenhaCoordenador(Coordenador coordenador) throws IOException{ 
		Coordenador c = buscarCoordenadorLogin(coordenador.getLogin());
		
		coordenador.setSenha(c.getSenha());
		salvarArquivoCoordenador();
	}
	
	/**
	 * Metodo para alterar nome do Coordenador
	 * @param objeto Coordenador alterado
	 */
	public void alterarNomeCoordenador(Coordenador coordenador) throws IOException{ 
		Coordenador c = buscarCoordenadorLogin(coordenador.getLogin());
		 
		coordenador.setNome(c.getNome());
		salvarArquivoCoordenador();
	}

}
