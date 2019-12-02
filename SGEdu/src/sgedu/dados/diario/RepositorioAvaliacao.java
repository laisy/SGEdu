package sgedu.dados.diario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sgedu.negocios.entidade.diario.Avaliacao;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class RepositorioAvaliacao 
 * @author laisy
 * Abaixo temos a classe para o repositório de Avaliacao que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados das Avaliacoes adicionadas no sistema; e a implementação da interface IRepositórioAvaliacao.
 * 
 */

public class RepositorioAvaliacao implements IRepositorioAvaliacao{
	
	ArrayList <Avaliacao> avaliacoes;
	
	public RepositorioAvaliacao() {
		this.avaliacoes = new ArrayList<Avaliacao>();
	}
	
	/**
	 * Metodo para criar a salvar o arquivo de Avaliacoes.
	 */
	public void salvarArquivoAvaliacao() throws IOException {
		FileOutputStream file = new FileOutputStream("Avaliacao.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(avaliacoes);
		os.close();
	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */
	public void buscarArquivoAvaliacao() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Avaliacao.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			avaliacoes = (ArrayList<Avaliacao>) is.readObject();
			is.close();
			salvarArquivoAvaliacao();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoAvaliacao();
		}
		
	}
	
	public void addAvaliacao(Avaliacao a) throws IOException {
		avaliacoes.add(a);
		salvarArquivoAvaliacao();
	}
	
	/**
	 * Metodo para buscar Avaliacao do Aluno
	 * @param aluno, disciplina e ano da avaliacao
	 * @return retorna a avaliacao buscada, caso nao encontre retorna null;
	 */
	public Avaliacao buscaAvaliacaoAluno(Aluno aluno, Disciplina disciplina, int ano) {
		for(int i=0; i<avaliacoes.size(); i++) {	
			if(avaliacoes.get(i).getAluno().getLogin().equals(aluno.getLogin())){
				Avaliacao a = avaliacoes.get(i);
				if(a.getAno() == ano) {
					if(a.getDisciplina().getNome().equals(disciplina.getNome())) {
						return a;
					}
				}
			}
		}
		return null;
	}
	
	public void removerAvaliacao(Aluno aluno, Disciplina disciplina, int ano) throws IOException {
		Avaliacao a = buscaAvaliacaoAluno(aluno, disciplina, ano);
		avaliacoes.remove(a);
		salvarArquivoAvaliacao();
	}
	
	public void editarAvaliacao(Avaliacao ava) throws IOException {
		Avaliacao a = buscaAvaliacaoAluno(ava.getAluno(), ava.getDisciplina(), ava.getAno());
		a = ava;
		salvarArquivoAvaliacao();
		
	}

}
