package sgedu.negocios.entidade.turma;

import java.io.Serializable;

import sgedu.negocios.entidade.usuarios.Professor;

/**
 * Class Disciplina
 * @author laisy
 * A classe Disciplina 
 *
 */

public class Disciplina implements Serializable{
	
	private String nome;
	private Professor professor; 
	private int quantAulas;
	
	public Disciplina(String nome, int quantAulas){
		this.nome = nome;
		this.quantAulas = quantAulas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantAulas() {
		return quantAulas;
	}
	
	public void setQuantAulas(int quantAulas) {
		this.quantAulas = quantAulas;
	}
	
	public int getQuantAulasBimestre() {
		return quantAulas/4;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Disciplina: " + nome + " PROFESSOR: " + professor + " N° DE AULAS: " + quantAulas;
	}

	
}