package sgedu.negocios.entidade.diario;

import java.util.Calendar;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class Frequencia
 * @author laisy
 * Classe Frequencia representa a frequencia do aluno nas aulas, a partir da quantidade de faltas e 
 * quantidades de aula da disciplina.
 * O objeto frequencia possui um aluno, uma disciplina, faltas e frequencias dos bimestres representado como:
 * falta1 = faltas do 1º bimestre, frequencia1 = frequencias do 1º bimestre. Possui também a quantidade de faltas anual
 * e de frequencia total anual.
 */
public class Frequencia{

	private Aluno aluno;
	private Disciplina disciplina;
	private int faltas1;
	private int frequencia1;
	
	private int faltas2;
	private int frequencia2;
	
	private int faltas3;
	private int frequencia3;
	
	private int faltas4;
	private int frequencia4;
	private int ano;
	
	private int frequenciaTotal;
	private int faltasTotal;

    public Frequencia(Aluno aluno, Disciplina disciplina){
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

	public int getFaltas1() {
		return faltas1;
	}

	public void setFaltas1() {
		this.faltas1 ++;
	}
	
	public int getFrequencia1() {
		return frequencia1;
	}

	public void setFrequencia1() {
		this.frequencia1 = disciplina.getQuantAulasBimestre() - getFaltas1();
	}

	public int getFaltas2() {
		return faltas2;
	}

	public void setFaltas2() {
		this.faltas2 ++;
	}

	public int getFrequencia2() {
		return frequencia2;
	}

	public void setFrequencia2() {
		this.frequencia2 = disciplina.getQuantAulasBimestre() - getFaltas2();;
	}

	public int getFaltas3() {
		return faltas3;
	}

	public void setFaltas3() {
		this.faltas3++;
	}

	public int getFrequencia3() {
		return frequencia3;
	}

	public void setFrequencia3() {
		this.frequencia3 = disciplina.getQuantAulasBimestre() - getFaltas3();
	}

	public int getFaltas4() {
		return faltas4;
	}

	public void setFaltas4() {
		this.faltas4++;
	}

	public int getFrequencia4() {
		return frequencia4;
	}

	public void setFrequencia4() {
		this.frequencia4 = disciplina.getQuantAulasBimestre() - getFaltas4();;
	}

	public int getFrequenciaTotal() {
		return frequenciaTotal;
	}

	public void setFrequenciaTotal() {
		this.frequenciaTotal = frequencia1 + frequencia2 + frequencia3 + frequencia4;
	}

	public int getFaltasTotal() {
		return faltasTotal;
	}

	public void setFaltasTotal() {
		this.faltasTotal = faltas1 + faltas2 + faltas3 + faltas4;
	}

	@Override
	public String toString() {
		return "DISCIPLINA: " + disciplina 
				+ "\n" + " FALTAS 1ºBim: " + faltas1 + " FREQUENCIA 1ºBim: " + frequencia1
				+ "\n" + " FALTAS 2ºBim: " + faltas2 + " FREQUENCIA 2ºBim: " + frequencia2 
				+ "\n" + " FALTAS 3ºBim: " + faltas3 + " FREQUENCIA 3ºBim: " + frequencia3 
				+ "\n" + " FALTAS 4ºBim: " + faltas4 + " FREQUENCIA 4ºBim: " + frequencia4
				+ "\n" + " FALTAS TOTAL: " + faltasTotal + " FREQUENCIA TOTAL: " + frequenciaTotal;
	}
	
	
}