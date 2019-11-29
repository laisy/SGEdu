package sgedu.dados.usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Responsavel;

/**
 * Abaixo temos a classe para o repositório de Responsavel que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados dos Responsaveis adicionados no sistema; e a implementação da interface IRepositorioResponsavel.
 * @author laisy
 */
public class RepositorioResponsavel implements IRepositorioResponsavel{

	ArrayList <Responsavel> responsaveis;
	
	public RepositorioResponsavel() {
		responsaveis = new ArrayList<Responsavel>();
	}
	
	/**
	 * Metodo para criar a salvar o arquivo de Responsaveis.
	 */

	public void salvarArquivoResponsavel() throws IOException {
		FileOutputStream file = new FileOutputStream("Responsaveis.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(responsaveis);
		os.close();
	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */

	public void buscarArquivoResponsavel() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Responsaveis.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			responsaveis = (ArrayList<Responsavel>) is.readObject();
			is.close();
			salvarArquivoResponsavel();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoResponsavel();
		}
		
	}
	
	public void addResponsavel(Responsavel r) throws IOException {
		responsaveis.add(r);
		salvarArquivoResponsavel();
	}
	

	/**
	 * Metodo para remover responsavel passando so o nome
	 * @param nome do responsavel
	 */

	public void removerResponsavelNome(String nome) throws IOException {
		Responsavel r = buscarResponsavelNome(nome);

		responsaveis.remove(r);
		salvarArquivoResponsavel();
	}
	

	/**
	 * Metodo para remover responsavel passando o login
	 * @param login do responsavel
	 */

	public void removerResponsavelLogin(String login) throws IOException {
		Responsavel r = buscarResponsavelLogin(login);
		
		responsaveis.remove(r);
		salvarArquivoResponsavel();
	}
	

	/**
	 * Metodo para buscar Responsavel pelo nome
	 * @param nome do Responsavel
	 * @return retorna o Responsavel buscado, caso nao encontre retorna null;
	 */

	public Responsavel buscarResponsavelNome(String nome) {
		for(int i=0; i<responsaveis.size(); i++) {
			if(responsaveis.get(i).getNome().contentEquals(nome)) {
				return responsaveis.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para buscar Responsavel pelo login
	 * @param login do Responsavel
	 * @return retorna o Responsavel buscado, caso nao encontre retorna null;
	 */
	public Responsavel buscarResponsavelLogin(String login) {
		for(int i=0; i<responsaveis.size(); i++) {
			if(responsaveis.get(i).getLogin().contentEquals(login)) {
				return responsaveis.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para alterar senha do Responsavel
	 * @param objeto responsavel alterado
	 */
	public void alterarSenhaResponsavel(Responsavel responsavel) throws IOException{ 
		Responsavel r = buscarResponsavelLogin(responsavel.getLogin());
		
		responsavel.setSenha(r.getSenha());
		salvarArquivoResponsavel();
	}
	
	/**
	 * Metodo para alterar nome do Responsavel
	 * @param objeto responsavel alterado
	 */
	public void alterarNomeResponsavel(Responsavel responsavel) throws IOException{ 
		Responsavel r = buscarResponsavelLogin(responsavel.getLogin());
		
		responsavel.setNome(r.getNome());
		salvarArquivoResponsavel();
	}

	public ArrayList<Responsavel> getResponsaveis() {
		return responsaveis;
	}
}
