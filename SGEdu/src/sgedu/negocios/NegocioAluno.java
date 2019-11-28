package sgedu.negocios;

import java.io.IOException;
import java.util.ArrayList;

import sgedu.dados.usuarios.IRepositorioAluno;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

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
