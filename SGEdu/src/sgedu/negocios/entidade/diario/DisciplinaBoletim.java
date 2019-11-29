package sgedu.negocios.entidade.diario;

/**
 * Class DisciplinaBoletim
 * @author laisy
 * DisciplinaBoletim é uma composição de boletim, os objetos criados nesta classe são
 * um objeto Frequencia e um objeto Avaliacao de uma determinada disciplina, ainda possui a situação do aluno,
 * se ele foi reprovado ou aprovado na disciplina.
 *
 */
 class DisciplinaBoletim {

    private Frequencia frequencias;
    private Avaliacao avaliacoes;
    private String situacaoDisciplina;
    
    public DisciplinaBoletim(Frequencia f, Avaliacao a) {
    	this.frequencias = f;
    	this.avaliacoes = a;
   }
   
    /**
     * O metodo situacaoAluno cria a situacao do aluno na disciplina, se foi aprovado ou reprovado
     * com base na seguinte condição: se o aluno teve media final >= 7 e a quantidade de faltas total nao 
     * foi maior que a quantidade de aulas de um bimestre, então ele foi aprovado. 
     */
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
