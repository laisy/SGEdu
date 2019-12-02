package sgedu.negocios;

import java.io.IOException;

import sgedu.dados.usuarios.IRepositorioResponsavel;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.entidade.usuarios.Responsavel;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;


/**
 * Class NegocioResponsavel
 * @author Allysson
 * Classe Responsavel Aluno gerencia as regras de negócios referente a Responsavel.
 */
public class NegocioResponsavel {
	
	private IRepositorioResponsavel repositorio;
	
	public NegocioResponsavel(IRepositorioResponsavel repositorio){
		this.repositorio=repositorio;
	}
	
	public void adicionar(Responsavel responsavel) throws IOException, UsuarioJaCadastradoException {
		try {
			repositorio.buscarArquivoResponsavel();
			Responsavel responsavelBusca=repositorio.buscarResponsavelLogin(responsavel.getLogin());
			
			if(responsavelBusca==null) {
				repositorio.addResponsavel(responsavel);
				
			} else {
				throw new UsuarioJaCadastradoException();
			}
		} catch (IOException e){
			e.printStackTrace();
			
		}
		
	}
	
	public boolean confirmaLogin(String login, String senha) {
		Responsavel resposta=repositorio.buscarResponsavelLogin(login);

		if(resposta!=null) {
			return resposta.verificaSenha(senha);
		}
		return false;
	}		
	
	public void addAluno(Responsavel responsavel,Aluno aluno) {
		Responsavel responsavelBusca=repositorio.buscarResponsavelLogin(responsavel.getLogin());
		
		if(responsavelBusca!=null) {
			responsavelBusca.addAluno(aluno);
		}
	}
	
	public Responsavel buscaLogin(String login) {
		return repositorio.buscarResponsavelLogin(login);
	}
	
	
	
}
