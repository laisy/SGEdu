package sgedu.negocios;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.dados.turma.IRepositorioTurma;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.turma.Turma;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class NegocioTurma
 * @author Allysson
 * Classe Negocio Turma gerencia as regras de negócios referente a Turma.
 */

public class NegocioTurma {
	
	private IRepositorioTurma repositorio;
	
	
	public NegocioTurma(IRepositorioTurma repositorio) {
		this.repositorio=repositorio;
	}
	
	
	public void adicionar(String nome, int ano) {
		Turma turma=new Turma(nome,ano);
		
		try {
			repositorio.buscarArquivoTurma();
			Turma busca=repositorio.buscarTurma(turma.getNome(), turma.getAno());
			if(busca==null) {
				repositorio.addTurma(turma);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Turma> getTurma() {
		return repositorio.getTurmas();
	}
	
	public void remover(String nome,int ano) {
		try {
			repositorio.removerTurma(nome, ano);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionarAluno(String nome,int ano,Aluno aluno) {
		Turma turma=repositorio.buscarTurma(nome, ano);	
		turma.addAlunosTurma(aluno);
		try {
			repositorio.salvarArquivoTurma();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionarDisciplina(String nome,int ano,Disciplina disciplina) {
		Turma turma=repositorio.buscarTurma(nome, ano);	
		turma.addDisciplinaTurma(disciplina);
		try {
			repositorio.salvarArquivoTurma();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Turma buscaTurma(String nome, int ano) {
		Turma turma=repositorio.buscarTurma(nome, ano);
		if(turma!=null) {
			return turma;
		}
		return null;
	}
	
	
	
	
	
	

}
