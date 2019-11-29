package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;

import sgedu.dados.usuarios.RepositorioCoordenador;

/**
 * Class Coordenador
 * @author Allysson
 * Classe Coordenador cria objetos do tipo Coordenador, seus metodos e atributos.
 * Um coordenador é um Usuário, tem acesso a todos as funcionalidades do sistema.
 */

public class Coordenador extends Usuario implements Serializable{
	
	
    public Coordenador(String login,String nome, String senha) {
        super(login,nome, senha);
    }
    
    @Override
	public String toString() {
		return "LOGIN: "+super.getLogin()+" \n    NOME: "+super.getNome();
	}


}
