package sgedu.negocios;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.dados.usuarios.IRepositorioAluno;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

/**
 * Class NegocioAluno
 * @author Allysson
 * Classe Negocio Aluno gerencia as regras de negócios referente a Aluno.
 */

public class NegocioAluno {
	
	private IRepositorioAluno repositorio;
	
	public NegocioAluno(IRepositorioAluno repositorio) {
		this.repositorio=repositorio;	
	}
	
	public void adicionar(Aluno aluno) throws UsuarioJaCadastradoException, IOException{
		try {
			repositorio.buscarArquivoAluno();
			Aluno alunoBusca=repositorio.buscarAlunoLogin(aluno.getLogin());
			if(alunoBusca==null) {		
				repositorio.addAluno(aluno);	
			}else {	
				throw new UsuarioJaCadastradoException();
			}		
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public Aluno buscarLogin(String login) {
		return repositorio.buscarAlunoLogin(login);
		
	}
	
	
	public void remover(String login) {
		try {
			repositorio.buscarArquivoAluno();
			Aluno alunoBusca=repositorio.buscarAlunoLogin(login);
			if(alunoBusca!=null) {		
				repositorio.removerAlunoLogin(login);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void AlterarNome(Aluno aluno) {
		try {
			repositorio.alterarNomeAluno(aluno);
		} catch (IOException e) {
			System.out.println("Nome não alterada!");
		}
	}
	
	public void alterarSenha(Aluno aluno) {
		try {
			repositorio.alterarSenhaAluno(aluno);
		} catch (IOException e) {
			System.out.println("Senha não alterada!");
		}
	}
	
	public boolean confirmaLogin(String login, String senha) {
		Aluno resposta =repositorio.buscarAlunoLogin(login)	;
		if(resposta!=null) {
			return resposta.verificaSenha(senha);
		}
		return false;
	}
	
	public ArrayList<Aluno> getAlunos(){
		return repositorio.getAlunos();
	}

}
