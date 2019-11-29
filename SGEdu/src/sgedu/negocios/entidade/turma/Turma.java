package sgedu.negocios.entidade.turma;

import java.io.Serializable;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class Turma
 * @author Laisy
 */

public class Turma implements Serializable {
    private String nome;
    private int ano;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Aluno> alunos;

    public Turma(String nome, int ano){
        this.nome = nome; 
        this.ano = ano;		
        this.disciplinas = new ArrayList<Disciplina>();
        this.alunos = new ArrayList<Aluno>();
        
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void addDisciplinaTurma(Disciplina disciplina) {
		disciplinas.add(disciplina);
	}
	

	public void removeDisciplinaTurma(Disciplina disciplina) {
		int index = disciplinas.indexOf(disciplina);
		if(index > -1) {
			disciplinas.remove(disciplina);
		}
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void addAlunosTurma(Aluno aluno) {
		alunos.add(aluno);
	}
	
	public void removeAlunoTurma(Aluno aluno) {
		int index = alunos.indexOf(aluno);
		if(index > -1) {
			alunos.remove(aluno);
		}
	}

	@Override
	public String toString() {
		return "TURMA " + nome + ano + "\n" + 
				" DISCIPLINAS: " + disciplinas + "\n" + 
				" ALUNOS: " + alunos;
	}
    
}