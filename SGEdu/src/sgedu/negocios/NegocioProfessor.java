package sgedu.negocios;

import java.io.IOException;
import java.util.ArrayList;

import sgedu.dados.usuarios.IRepositorioProfessor;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Professor;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

public class NegocioProfessor {
	
	private IRepositorioProfessor repositorio;
	
	public NegocioProfessor(IRepositorioProfessor repositorio) {
		this.repositorio=repositorio;
	}
	
	public void adicionar(String login, String nome, String senha, Disciplina disciplina) throws UsuarioJaCadastradoException, IOException{
		try {
			repositorio.buscarArquivoProfessor();
			Professor professor=new Professor(login,nome,senha,disciplina);
			Professor professorBusca=repositorio.buscarProfessorLogin(professor.getLogin());
			
			if(professorBusca==null) {
				repositorio.addProfessor(professor);	
			} else {
				throw new UsuarioJaCadastradoException();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Professor buscarLogin(String login) {
		return repositorio.buscarProfessorLogin(login);
	}
	
	
	public boolean confirmaLogin(String login, String senha) {
		Professor resposta= repositorio.buscarProfessorLogin(login);
		
		if(resposta!=null) {
			return resposta.verificaSenha(senha);
		}
		return false;
	}
	
	public ArrayList<Professor> getProfessores(){
		return repositorio.getProfessores();
	}
	
	public void alteraNome(Professor professor) {
		try {
			repositorio.alterarNomeProfessor(professor);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void alteraSenha(Professor professor) {
		try {
			repositorio.alterarSenhaProfessor(professor);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	

}
