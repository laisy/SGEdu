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

public class RepositorioAvaliacao implements IRepositorioAvaliacao{
	
	ArrayList <Avaliacao> avaliacoes;
	
	public RepositorioAvaliacao() {
		this.avaliacoes = new ArrayList<Avaliacao>();
	}

	public void salvarArquivoAvaliacao() throws IOException {
		FileOutputStream file = new FileOutputStream("Avaliacao.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(avaliacoes);
		os.close();
	}
	
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
	
	public Avaliacao buscaAvaliacaoAluno(Aluno aluno, Disciplina disciplina, int ano) {
		for(int i=0; i<avaliacoes.size(); i++) {
			if(avaliacoes.get(i).getAluno() == aluno && avaliacoes.get(i).getAno() == ano && avaliacoes.get(i).getDisciplina() == disciplina) {
				return avaliacoes.get(i);
			}
		}
		return null;
	}
	
	public void removerAvaliacao(Aluno aluno, Disciplina disciplina, int ano) throws IOException {
		Avaliacao a = buscaAvaliacaoAluno(aluno, disciplina, ano);
		avaliacoes.remove(a);
		salvarArquivoAvaliacao();
	}

}
