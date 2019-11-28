package sgedu.dados.usuarios;

import java.io.IOException;
import sgedu.negocios.entidade.usuarios.Coordenador;

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
	

}
