package sgedu.negocios.entidade.diario;

import java.util.ArrayList;
import java.util.Calendar;
import sgedu.dados.diario.IRepositorioAvaliacao;
import sgedu.dados.diario.IRepositorioFrequencia;
import sgedu.dados.turma.IRepositorioDisciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class Boletim
 * 
 */

public class Boletim {

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
	
    public void addDisciplinasBoletim(IRepositorioDisciplina repositorioDisciplina, IRepositorioFrequencia repositorioFrequencia, IRepositorioAvaliacao repositorioAvaliacao) {
    	for(int i=0; i<repositorioDisciplina.getDisciplinas().size(); i++) {
    		Frequencia f = repositorioFrequencia.buscaFrequenciaAluno(aluno, repositorioDisciplina.getDisciplinas().get(i), ano);
    		Avaliacao a = repositorioAvaliacao.buscaAvaliacaoAluno(aluno, repositorioDisciplina.getDisciplinas().get(i), ano);
    		disciplinasBoletim.add(new DisciplinaBoletim(f, a));
    	}
    }

	@Override
	public String toString() {
		return "Boletim " + ano + " ALUNO: " + aluno + "\n"
				+ disciplinasBoletim.toString();
	}
    
    
}