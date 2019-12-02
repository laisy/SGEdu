package sgedu.negocios;

import java.io.IOException;
import java.util.ArrayList;

import sgedu.dados.turma.IRepositorioDisciplina;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Professor;

public class NegocioDisciplina {
	
	private IRepositorioDisciplina repositorio;
	
	public NegocioDisciplina(IRepositorioDisciplina repositorio) {
		this.repositorio=repositorio;
	}
	
	public void adicionar(String nome, int aulas) {
		Disciplina disciplina=new Disciplina(nome,aulas);
		try {
			repositorio.buscarArquivoDisciplina();
			Disciplina busca=repositorio.buscarDisciplina(disciplina.getNome());
			if(busca==null) {
				repositorio.addDisciplina(disciplina);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Disciplina> getDisciplinas(){
		return repositorio.getDisciplinas();
	}
	
	public void remover(String nome) {
		try {
			repositorio.removerDisciplina(nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addProfessorTurma(String nome,Professor professor) {	
		try {
			repositorio.buscarDisciplina(nome).setProfessor(professor);
			repositorio.salvarArquivoDisciplina();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Disciplina buscar(String nome) {
		return repositorio.buscarDisciplina(nome);
	}
	
	public IRepositorioDisciplina getRepositorio() {
		return repositorio;
	}
	
	
}
