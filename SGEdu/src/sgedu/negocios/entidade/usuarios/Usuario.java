package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;

/**
 * Class Usuario
 * @author Allysson
 * Classe modelo para os objetos do tipo "Usuario"; seus atributos e seu construtor.
 * Usuarios sao as pessoas que tem acesso ao sistema.
 */

public abstract class Usuario implements Serializable {
    private String nome;
    private String senha;
    private String login;

    public Usuario(String login,String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getLogin() {
		return login;
	}
    
    public String getSenha() { return senha; }
    
    /**
     * Metodo pra verificar se a senha esta correta ou nao
     * @param senha do usuario
     * @return true para senha correta, false se errada
     */
    public boolean verificaSenha(String senha) {
        if (this.senha.equals(senha)) {
            return true;
        }
        return false;
    }
}