package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import sgedu.dados.usuarios.RepositorioResponsavel;;

/**
 * Class Responsavel
 * @author Allysson & Lucas Leonardo
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


}
