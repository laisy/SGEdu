package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;

import sgedu.dados.usuarios.RepositorioAluno;

/**
 * Class Aluno
 * @author Allysson
 * Classe Aluno inicializa objetos do tipo aluno, seus atributos e métodos.
 * Aluno é um Usuário, e tem acesso restrito do sistema. Possui somente um Responsavel.
 * 
 */
public class Aluno extends Usuario implements Serializable{
	
	private Responsavel responsavel;
	
    public Aluno(String login,String nome, String senha){
        super(login,nome, senha);
    }
    
	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return "LOGIN: "+super.getLogin()+" \n    NOME: "+super.getNome();
	}

}