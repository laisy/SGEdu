package sgedu.negocios;

import java.util.ArrayList;

import sgedu.dados.diario.IRepositorioAvaliacao;
import sgedu.dados.diario.IRepositorioFrequencia;
import sgedu.negocios.entidade.diario.Avaliacao;
import sgedu.negocios.entidade.diario.Frequencia;
import sgedu.negocios.entidade.usuarios.Aluno;

public class NegocioBoletim {
	
	ArrayList<Frequencia> frequencias;
    ArrayList<Avaliacao> avaliacoes;
    
    private IRepositorioFrequencia repositorioFrequencia;
    private IRepositorioAvaliacao repositorioAvaliacao;
	
    public NegocioBoletim(IRepositorioFrequencia repositorioFrequencia, IRepositorioAvaliacao repositorioAvaliacao) {
    	this.repositorioAvaliacao = repositorioAvaliacao;
    	this.repositorioFrequencia = repositorioFrequencia;
    	this.frequencias = new ArrayList<Frequencia>();
    	this.avaliacoes = new ArrayList<Avaliacao>();
    }
    
//    public ArrayList addFrequencia(Aluno aluno) {
//    	repositorioFrequencia.buscaFrequenciaAluno(aluno, bimestre, disciplina)
//    }
//
    
	

}