package sgedu.negocios;

import java.io.IOException;
import java.util.ArrayList;

import sgedu.dados.turma.IRepositorioTurma;
import sgedu.negocios.entidade.turma.Turma;

public class NegocioTurma {
	
	private IRepositorioTurma repositorio;
	
	
	public NegocioTurma(IRepositorioTurma repositorio) {
		this.repositorio=repositorio;
	}
	
	
	public void adicionar(String nome, int ano) {
		Turma turma=new Turma(nome,ano);
		
		try {
			repositorio.buscarArquivoTurma();
			Turma busca=repositorio.buscarTurma(turma.getNome(), turma.getAno());
			if(busca==null) {
				repositorio.addTurma(turma);
				System.out.println("entrou no IF");
			}else {
				System.out.println("entrou no else");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public ArrayList<Turma> getTurma() {
		return repositorio.getTurmas();
	}
	
	
	
	
	
	
	

}
