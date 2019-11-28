package sgedu.negocios.entidade.diario;

import java.util.Calendar;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

public class Avaliacao{
	
	private Aluno aluno;
	private Disciplina disciplina;
	private int ano;
	
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double mediaFinal;
	
	public Avaliacao(Aluno aluno, Disciplina disciplina){
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.ano = pegarAno();
	}

	public int pegarAno() {
    	Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        return ano;
    }
    
    public int getAno() {
    	return ano;
    }

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	public double getNota4() {
		return nota4;
	}

	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	
	public void setMediaFinal() {
		this.mediaFinal = (nota1 + nota2 + nota3 + nota4)/4;
	}
	
	public double getMediaFinal() {
		return mediaFinal;
	}

	@Override
	public String toString() {
		return "DISCIPLINA: " + disciplina 
				+ "\n" + " NOTA 1º Bim: " + nota1
				+ "\n" + " NOTA 2º Bim: " + nota2 
				+ "\n" + " NOTA 3º Bim: " + nota3 
				+ "\n" + " NOTA 4º Bim: " + nota4 
				+ "\n" +" MEDIA FINAL: " + mediaFinal;
	}
}
