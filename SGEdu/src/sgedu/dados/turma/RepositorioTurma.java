package sgedu.dados.turma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.turma.Turma;

public class RepositorioTurma implements IRepositorioTurma{
	
	ArrayList <Turma> turmas;
	
	public RepositorioTurma() {
		turmas = new ArrayList<Turma>();
	}
	
	public void salvarArquivoTurma() throws IOException {
		FileOutputStream file = new FileOutputStream("Turmas.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(turmas);
		os.close();
	}
	
	public void buscarArquivoTurma() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Turmas.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			turmas = (ArrayList<Turma>) is.readObject();
			is.close();
			salvarArquivoTurma();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoTurma();
		}
	}


	public void addTurma(Turma t) throws IOException{
		turmas.add(t);
		salvarArquivoTurma();
	}
	
	public void removerTurma(String nome, int ano) throws IOException{
		Turma t = buscarTurma(nome, ano);
		turmas.remove(t);
		salvarArquivoTurma();
	}
	
	public Turma buscarTurma(String nome, int ano) {
		for(int i=0; i<turmas.size(); i++) {
			if(turmas.get(i).getNome().contentEquals(nome) && turmas.get(i).getAno() == ano) {
				return turmas.get(i);
			}
		}
		return null;
	}
	
	public void alterarTurma(Turma turma) throws IOException{ 
		Turma t = buscarTurma(turma.getNome(), turma.getAno());
		
		turma.setNome(t.getNome());
		turma.setAno(t.getAno());
		salvarArquivoTurma();
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

}
