package sgedu.negocios;

import java.io.IOException;
import sgedu.dados.usuarios.IRepositorioCoordenador;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.entidade.usuarios.Coordenador;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

/**
 * Class NegocioCoordenador
 * @author Allysson
 * Classe Negocio Coordenador gerencia as regras de negócios referente a aluno.
 */
public class NegocioCoordenador {
	
	private IRepositorioCoordenador repositorio;
	
	
	public NegocioCoordenador(IRepositorioCoordenador repositorio) {
		this.repositorio=repositorio;		
	}
	
	public void adicionar(Coordenador coordenador) throws UsuarioJaCadastradoException, IOException {
		try {
			repositorio.buscarArquivoCoordenador();
			Coordenador coordenadorBusca = repositorio.buscarCoordenadorLogin(coordenador.getLogin());
			
			if(coordenadorBusca==null) {
				repositorio.addCoordenador(coordenador);
			} else {
				throw new UsuarioJaCadastradoException();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Coordenador buscarLogin(String login) {
		return repositorio.buscarCoordenadorLogin(login);
	}
	
	
	
	public boolean confirmaLogin(String login, String senha) {
		Coordenador resposta= repositorio.buscarCoordenadorLogin(login);
		if(resposta!=null) {
			return resposta.verificaSenha(senha);
		}
		return false;
		
	}
	
	
	public Aluno cadatrarAluno(String login,String nome, String senha) {
		Aluno aluno=new Aluno(login,nome, senha);
		return aluno;
	}
	
	
	
	
	
	
	
	
	

}
