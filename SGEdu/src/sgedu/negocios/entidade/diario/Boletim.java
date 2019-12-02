package sgedu.negocios.entidade.diario;

import java.util.ArrayList;
import java.util.Calendar;
import sgedu.dados.diario.IRepositorioAvaliacao;
import sgedu.dados.diario.IRepositorioFrequencia;
import sgedu.dados.turma.IRepositorioDisciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class Boletim
 * @author laisy
 * Classe Boletim cria objetos do tipo Boletim, seus atributos e metodos.
 * Boletim possui um aluno, um ano e um ArrayList de Disciplina Boletim, que nada mais que
 * um objeto frequencia e um objeto avaliacao referente a uma disciplina. 
 */

public class Boletim{

    private Aluno aluno;
    private int ano;
    private ArrayList<DisciplinaBoletim> disciplinasBoletim;
    
    public Boletim(Aluno aluno) {
    	this.aluno = aluno;
    	this.ano = pegarAno();
    	this.disciplinasBoletim = new ArrayList<DisciplinaBoletim>();
    	
   }
   
    public int pegarAno() {
    	Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        return ano;
    }
    
    public int getAno() {
    	return ano;
    }
	
    /**
     * Metodo que adiciona DisciplinasBoletim ao ArrayList do Boletim
     * Neste método é buscado as disciplinas existentes,para assim buscar a Frequencia e a Avaliacao dela que pentence ao aluno do boletim.
     * @param repositorioDisciplina para pegar as disciplinas e fazer o loop 
     * @param repositorioFrequencia para encontrar as Frequencias do Aluno
     * @param repositorioAvaliacao para buscar as Avaliacoes do Aluno
     */
    public void addDisciplinasBoletim(IRepositorioDisciplina repositorioDisciplina, IRepositorioFrequencia repositorioFrequencia, IRepositorioAvaliacao repositorioAvaliacao) {
    	for(int i=0; i<repositorioDisciplina.getDisciplinas().size(); i++) {
    		Frequencia f = repositorioFrequencia.buscaFrequenciaAluno(aluno, repositorioDisciplina.getDisciplinas().get(i), ano);
    		Avaliacao a = repositorioAvaliacao.buscaAvaliacaoAluno(aluno, repositorioDisciplina.getDisciplinas().get(i), ano);
    		if(a!=null || f!=null) {
    			disciplinasBoletim.add(new DisciplinaBoletim(f, a));
    		}
    	}
    }

	@Override
	public String toString() {
		return "Boletim " + ano 
				+"\n" + aluno 
				+ "\n" + disciplinasBoletim + "\n";
	}
    
    
}