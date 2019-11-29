package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import sgedu.dados.usuarios.RepositorioResponsavel;;

/**
 * Class Responsavel
 * @author Allysson
 * Classe para criação de objetos do tipo Responsavel, seus atributos e metodos.
 * Responsavel é um Usuário, e é um responsavel pelo aluno (ex mãe/pai).
 * Responsavel tem acesso restrito do sistema. 
 */

public class Responsavel extends Usuario implements Serializable{
    private ArrayList<Aluno> alunos;

    //obrigatório ao menos 1 aluno para associar o responsável
    public Responsavel(String login,String nome, String senha) {
        super(login,nome, senha);
        this.alunos = new ArrayList<Aluno>();
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

	@Override
	public String toString() {
		return "LOGIN: "+super.getLogin()+" \n    NOME: "+super.getNome() + " ALUNOS: " + alunos;
	}

    

}
