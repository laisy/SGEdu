package sgedu.dados.usuarios;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.negocios.entidade.usuarios.Professor;

/**
 * Abaixo temos a interface a ser implementada no repositório de Professor, 
 * com suas assinaturas de métodos.
 * @author laisy
 */

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
	
	ArrayList<Professor> getProfessores();
	

}
