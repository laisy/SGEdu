package sgedu.dados.usuarios;

import java.io.IOException;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Coordenador;
/**
 * Interface IRepositorioCoordenador
 * @author laisy
 * Abaixo temos a interface a ser implementada no repositório de Coordenador, 
 * com suas assinaturas de métodos.
 * 
 */
public interface IRepositorioCoordenador {
	
	void salvarArquivoCoordenador() throws IOException;
	
	void buscarArquivoCoordenador() throws IOException;
	
	void addCoordenador(Coordenador c) throws IOException;
	
	void removerCoordenadorNome(String nome) throws IOException;
	
	void removerCoordenadorLogin(String login) throws IOException;
	
	Coordenador buscarCoordenadorNome(String nome);
	
	Coordenador buscarCoordenadorLogin(String login);
	
	void alterarSenhaCoordenador(Coordenador coordenador) throws IOException;
	
	void alterarNomeCoordenador(Coordenador coordenador) throws IOException;
	
	ArrayList<Coordenador> getCoordenadores();

}
