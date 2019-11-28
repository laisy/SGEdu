package sgedu.dados.usuarios;

import java.io.IOException;

import sgedu.negocios.entidade.usuarios.Professor;

public interface IRepositorioProfessor {
	
	void salvarArquivoProfessor() throws IOException ;
	
	void buscarArquivoProfessor() throws IOException;
	
	void addProfessor(Professor p) throws IOException;
	
	void removerProfessorNome(String nome) throws IOException;
	
	void removerProfessorLogin(String login) throws IOException ;
	
	Professor buscarProfessorNome(String nome);
	
	Professor buscarProfessorLogin(String login) ;
	
	void alterarSenhaProfessor(Professor professor) throws IOException;
	
	void alterarNomeProfessor(Professor professor) throws IOException;
	

}
