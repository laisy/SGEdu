package sgedu.negocios;

import java.io.IOException;

import sgedu.dados.usuarios.IRepositorioProfessor;
import sgedu.negocios.entidade.usuarios.Professor;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

public class NegocioProfessor {
	
	private IRepositorioProfessor repositorio;
	
	public NegocioProfessor(IRepositorioProfessor repositorio) {
		this.repositorio=repositorio;
	}
	
	public void adicionar(Professor professor) throws UsuarioJaCadastradoException, IOException{
		try {
			repositorio.buscarArquivoProfessor();
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
	
	
	

}
