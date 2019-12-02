package sgedu.negocios;

import java.io.IOException;

import sgedu.dados.diario.IRepositorioAvaliacao;
import sgedu.dados.diario.IRepositorioFrequencia;
import sgedu.dados.turma.IRepositorioDisciplina;
import sgedu.negocios.entidade.diario.Avaliacao;
import sgedu.negocios.entidade.diario.Boletim;
import sgedu.negocios.entidade.diario.Frequencia;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class NegocioBoletim
 * @author Allysson
 * Classe Negocio Boletim gerencia as regras de negócios referente ao Boletim.
 */

public class NegocioBoletim {
	
    private IRepositorioFrequencia rFrequencia;
    private IRepositorioAvaliacao rAvaliacao;
    private IRepositorioDisciplina rDisciplina;

    public NegocioBoletim(IRepositorioDisciplina rDisciplina, IRepositorioFrequencia rFrequencia, IRepositorioAvaliacao rAvaliacao) {
    	this.rAvaliacao = rAvaliacao;
    	this.rDisciplina = rDisciplina;
    	this.rFrequencia = rFrequencia;
    }
    
    public void adicionarAvaliacao(Aluno aluno, Disciplina disciplina, int ano,double nota1,double nota2,double nota3,double nota4) {
    	Avaliacao a = rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano);
    	try{
    		if(a == null) {
	    		a = new Avaliacao(aluno, disciplina);
	    		rAvaliacao.addAvaliacao(a);
    		} 
    		if(nota1 != -1) {
    			a.setNota1(nota1);
    		}
    		if(nota2 != -1) {
    			a.setNota2(nota2);
    		}
    		if(nota3 != -1) {
    			a.setNota3(nota3);
    		}
    		if(nota4 != -1) {
    			a.setNota4(nota4);
    		}
    		
    		a.setMediaFinal();
    		rAvaliacao.salvarArquivoAvaliacao();
    		
    		System.out.println(rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano));
    		
    	} catch(IOException e) {
    		System.out.println("Avaliacao não adicionada no arquivo!");
		
    	}
    }
    
    public String visualizarBoletim(Aluno aluno) {
    	Boletim boletim=new Boletim(aluno);
    	
    	boletim.addDisciplinasBoletim(this.rDisciplina, this.rFrequencia, this.rAvaliacao);
    	return boletim.toString();
    	
    }
    
    public void adicionarFrequencia(Aluno aluno,Disciplina disciplina, int ano, int bimestre) {
    	
    	Frequencia f = rFrequencia.buscaFrequenciaAluno(aluno, disciplina, ano);
    	try {
	    	if(f == null) {
	    		f = new Frequencia(aluno, disciplina);
				rFrequencia.addFrequencia(f);    		
	    	}
	    	
			if(bimestre == 1) {
				f.setFaltas1();
				f.setFrequencia1();
			}
			if(bimestre == 2) {
				f.setFaltas2();
				f.setFrequencia2();
			}
			if(bimestre == 3) {
				f.setFaltas3();
				f.setFrequencia3();
			}
			if(bimestre == 4) {
				f.setFaltas4();
				f.setFrequencia4();
			}
			
			f.setFaltasTotal();
			f.setFrequenciaTotal();
			rFrequencia.salvarArquivoFrequencia();
			
			System.out.println(rFrequencia.buscaFrequenciaAluno(aluno, disciplina, ano));
			
		} catch (IOException e) {
			System.out.println("Frequencia não adicionada no arquivo!");
		}
    	
    }
    
}