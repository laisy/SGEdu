package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import sgedu.dados.usuarios.RepositorioProfessor;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.turma.Turma;

/**
 * Class Professor
 * @author 
 */

public class Professor extends Usuario implements Serializable {
    private Disciplina disciplina;
    private ArrayList <Turma> turmas;
    
    public Professor(String login,String nome, String senha, Disciplina disciplina) {
        super(login,nome, senha);
        this.disciplina = disciplina;
        this.turmas = new ArrayList<Turma>();
    }

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void addTurma(Turma turma){
		turmas.add(turma);
	}

	
}