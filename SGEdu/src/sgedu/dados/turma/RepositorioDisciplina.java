package sgedu.dados.turma;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.turma.Disciplina;

public class RepositorioDisciplina implements IRepositorioDisciplina {
	
	ArrayList <Disciplina> disciplinas;
	
	public RepositorioDisciplina() {
		disciplinas = new ArrayList<Disciplina>();
	}
	
	public void salvarArquivoDisciplina() throws IOException {
		FileOutputStream file = new FileOutputStream("Disciplinas.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(disciplinas);
		os.close();
	}
	
	public void buscarArquivoDisciplina() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Disciplinas.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			disciplinas = (ArrayList<Disciplina>) is.readObject();
			is.close();
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
	
	public Disciplina buscarDisciplina(String nome) {
		for(int i=0; i<disciplinas.size(); i++) {
			if(disciplinas.get(i).getNome().contentEquals(nome)) {
				return disciplinas.get(i);
			}
		}
		return null;
	}
	
	public void alterarDisciplina(Disciplina disciplina) throws IOException{ 
		Disciplina d = buscarDisciplina(disciplina.getNome());
		disciplina.setNome(d.getNome());
		salvarArquivoDisciplina();
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}
