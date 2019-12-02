package sgedu.negocios;

import java.io.IOException;

import sgedu.dados.diario.IRepositorioAvaliacao;
import sgedu.dados.diario.IRepositorioFrequencia;
import sgedu.dados.turma.IRepositorioDisciplina;
import sgedu.negocios.entidade.diario.Avaliacao;
import sgedu.negocios.entidade.diario.Boletim;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

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
    	Avaliacao avaliacao=rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano);
    	if(avaliacao==null) {
    		Avaliacao novaAvaliacao=new Avaliacao(aluno,disciplina);
    		
    		
    		
    		if(nota1!=-1) {
    			novaAvaliacao.setNota1(nota1);
    		}
    		
    		if(nota2!=-1) {
    			novaAvaliacao.setNota2(nota2);
    		}
    		if(nota3!=-1) {
    			novaAvaliacao.setNota3(nota3);
    		}
    		if(nota4!=-1) {
    			novaAvaliacao.setNota4(nota4);
    		}
    		
    		novaAvaliacao.setMediaFinal();
    		
    		System.out.println("////////////////////"+novaAvaliacao.toString());
    		
    		try {
				rAvaliacao.addAvaliacao(novaAvaliacao);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}else {
    		
    		if(nota1!=-1) {
    			rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano).setNota1(nota1);
    		}
    		
    		if(nota2!=-1) {
    			rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano).setNota2(nota2);
    		}
    		if(nota3!=-1) {
    			rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano).setNota3(nota3);
    		}
    		if(nota4!=-1) {
    			rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano).setNota4(nota4);
    		}
    		
    		
    		rAvaliacao.buscaAvaliacaoAluno(aluno, disciplina, ano).setMediaFinal();
    		
    	}
    	
    	try {
			rAvaliacao.salvarArquivoAvaliacao();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    public String visualizarBoletim(Aluno aluno) {
    	Boletim boletim=new Boletim(aluno);
    	
    	boletim.addDisciplinasBoletim(this.rDisciplina, this.rFrequencia, this.rAvaliacao);
    	return boletim.toString();
    	
    }
    
    
	

}