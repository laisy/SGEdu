package sgedu.negocios;

import sgedu.dados.diario.IRepositorioAvaliacao;
import sgedu.dados.diario.IRepositorioFrequencia;
import sgedu.dados.turma.IRepositorioDisciplina;

public class NegocioBoletim {
	
    private IRepositorioFrequencia rFrequencia;
    private IRepositorioAvaliacao rAvaliacao;
    private IRepositorioDisciplina rDisciplina;

    public NegocioBoletim(IRepositorioDisciplina rDisciplina, IRepositorioFrequencia rFrequencia, IRepositorioAvaliacao rAvaliacao) {
    	this.rAvaliacao = rAvaliacao;
    	this.rDisciplina = rDisciplina;
    	this.rFrequencia = rFrequencia;
    }
    
    
	

}