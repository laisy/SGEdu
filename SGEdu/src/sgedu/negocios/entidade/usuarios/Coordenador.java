package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;

import sgedu.dados.usuarios.RepositorioCoordenador;

/**
 * Class Coordenador
 * @author Allysson & Lucas Leonardo
 */

public class Coordenador extends Usuario implements Serializable{
	
	
    public Coordenador(String login,String nome, String senha) {
        super(login,nome, senha);
    }
    

}
