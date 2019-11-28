package sgedu.negocios.entidade.diario;

import sgedu.negocios.entidade.usuarios.Aluno;

/**
 * Class Boletim
 * 
 */

public class Boletim {

    private Aluno aluno;
    private int ano;
    private Frequencia frequencias;
    private Avaliacao avaliacoes;
    private String situacao;
    
    public Boletim(Aluno aluno, Frequencia f, Avaliacao a) {
    	this.aluno = aluno;
    	this.frequencias = f;
    	this.avaliacoes = a;
    	this.ano = a.getAno();
   }
   
    public String situacaoAluno() {
    	if(avaliacoes.getMediaFinal() >= 7.0 && frequencias.getFaltasTotal() < frequencias.getDisciplina().getQuantAulasBimestre()) {
    		this.situacao = "APROVADO";
    		return situacao;
    	}
    	this.situacao = "REPROVADO";
    	return situacao;
    }

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Frequencia getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(Frequencia frequencias) {
		this.frequencias = frequencias;
	}

	public Avaliacao getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Avaliacao avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "BOLETIM " + ano + "\n" + " ALUNO(A): " + aluno 
				+ "\n" + " FALTAS E FREQUENCIAS: " + frequencias 
				+ "\n" + " AVALIACOES: " + avaliacoes 
				+ "\n" + " SITUACAO: " + situacao;
	}
   
	
}