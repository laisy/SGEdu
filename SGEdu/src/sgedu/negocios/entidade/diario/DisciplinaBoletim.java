package sgedu.negocios.entidade.diario;

public class DisciplinaBoletim {

    private Frequencia frequencias;
    private Avaliacao avaliacoes;
    private String situacaoDisciplina;
    
    public DisciplinaBoletim(Frequencia f, Avaliacao a) {
    	this.frequencias = f;
    	this.avaliacoes = a;
   }
   
    public String situacaoAluno() {
    	if(avaliacoes.getMediaFinal() >= 7.0 && frequencias.getFaltasTotal() < frequencias.getDisciplina().getQuantAulasBimestre()) {
    		this.situacaoDisciplina = "APROVADO";
    		return situacaoDisciplina;
    	}
    	this.situacaoDisciplina = "REPROVADO";
    	return situacaoDisciplina;
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
		return situacaoDisciplina;
	}

	public void setSituacao(String situacao) {
		this.situacaoDisciplina = situacao;
	}

	@Override
	public String toString() {
		return " FREQUENCIA: " + frequencias + "\n" +
				" AVALIACAO: " + avaliacoes + "\n" +
				" SITUACAO: " + situacaoDisciplina + "\n";
	}
}
