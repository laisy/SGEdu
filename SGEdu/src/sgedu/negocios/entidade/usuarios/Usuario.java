package sgedu.negocios.entidade.usuarios;

import java.io.Serializable;

/**
 * Superclass Usuario
 * @author Allysson & Lucas Leonardo
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
    
    public boolean verificaSenha(String senha) {
        if (this.senha.equals(senha)) {
            return true;
        }
        return false;
    }
}