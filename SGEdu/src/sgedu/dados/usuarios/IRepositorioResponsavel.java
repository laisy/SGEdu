package sgedu.dados.usuarios;

import java.io.IOException;
import java.util.ArrayList;
import sgedu.negocios.entidade.usuarios.Responsavel;

/**
 * Interface IRepositorioResponsavel
 * @author laisy
 * Abaixo temos a interface a ser implementada no repositório de Responsavel, 
 * com suas assinaturas de métodos.
 */

public interface IRepositorioResponsavel {

	void salvarArquivoResponsavel() throws IOException;
	
	void buscarArquivoResponsavel() throws IOException;
	
	void addResponsavel(Responsavel r) throws IOException;
	
	void removerResponsavelNome(String nome) throws IOException;
	
	void removerResponsavelLogin(String login) throws IOException;
	
	Responsavel buscarResponsavelNome(String nome) ;
	
	Responsavel buscarResponsavelLogin(String login);
	
	void alterarSenhaResponsavel(Responsavel responsavel) throws IOException;
	
	void alterarNomeResponsavel(Responsavel responsavel) throws IOException;
	
	ArrayList<Responsavel> getResponsaveis();
	
}
