package sgedu.dados.usuarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Coordenador;

public class RepositorioCoordenador implements IRepositorioCoordenador {
	ArrayList <Coordenador> coordenadores;
	
	public RepositorioCoordenador() {
		coordenadores = new ArrayList<Coordenador>();
	}
	
	
	public ArrayList<Coordenador> getCoordenadores() {
		return coordenadores;
	}

	public void salvarArquivoCoordenador() throws IOException {
		FileOutputStream file = new FileOutputStream("Coordenadores.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(coordenadores);
		os.close();

	}
	
	public void buscarArquivoCoordenador() throws IOException{
		try{
			FileInputStream file = new FileInputStream("Coordenadores.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			coordenadores = (ArrayList<Coordenador>) is.readObject();
			is.close();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoCoordenador();
		}
		
	}
	
	public void addCoordenador(Coordenador c) throws IOException {
		coordenadores.add(c);
		salvarArquivoCoordenador();
	}
	
	public void removerCoordenadorNome(String nome) throws IOException {
		Coordenador c = buscarCoordenadorNome(nome);
		
		coordenadores.remove(c);
		salvarArquivoCoordenador();
	}
	
	public void removerCoordenadorLogin(String login) throws IOException{
		Coordenador c = buscarCoordenadorLogin(login);
		
		coordenadores.remove(c);
		salvarArquivoCoordenador();
	}
	
	public Coordenador buscarCoordenadorNome(String nome) {
		for(int i=0; i<coordenadores.size(); i++) {
			if(coordenadores.get(i).getNome().contentEquals(nome)) {
				return coordenadores.get(i);
			}
		}
		return null;
	}
	
	public Coordenador buscarCoordenadorLogin(String login) {
		for(int i=0; i<coordenadores.size(); i++) {
			if(coordenadores.get(i).getLogin().contentEquals(login)) {
				return coordenadores.get(i);
			}
		}
		return null;
	}
	
	public void alterarSenhaCoordenador(Coordenador coordenador) throws IOException{ 
		Coordenador c = buscarCoordenadorLogin(coordenador.getLogin());
		
		coordenador.setSenha(c.getSenha());
		salvarArquivoCoordenador();
	}
	
	public void alterarNomeCoordenador(Coordenador coordenador) throws IOException{ 
		Coordenador c = buscarCoordenadorLogin(coordenador.getLogin());
		 
		coordenador.setNome(c.getNome());
		salvarArquivoCoordenador();
	}
	
	
}
