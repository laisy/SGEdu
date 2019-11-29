package sgedu.dados.usuarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.usuarios.Responsavel;

public class RepositorioResponsavel implements IRepositorioResponsavel{

	ArrayList <Responsavel> responsaveis;
	
	public RepositorioResponsavel() {
		responsaveis = new ArrayList<Responsavel>();
	}
	
	public void salvarArquivoResponsavel() throws IOException {
		FileOutputStream file = new FileOutputStream("Responsaveis.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(responsaveis);
		os.close();
	}
	
	public void buscarArquivoResponsavel() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Responsaveis.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			responsaveis = (ArrayList<Responsavel>) is.readObject();
			is.close();
			salvarArquivoResponsavel();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoResponsavel();
		}
		
	}
	
	public void addResponsavel(Responsavel r) throws IOException {
		responsaveis.add(r);
		salvarArquivoResponsavel();
	}
	
	public void removerResponsavelNome(String nome) throws IOException {
		Responsavel r = buscarResponsavelNome(nome);

		responsaveis.remove(r);
		salvarArquivoResponsavel();
	}
	
	public void removerResponsavelLogin(String login) throws IOException {
		Responsavel r = buscarResponsavelLogin(login);
		
		responsaveis.remove(r);
		salvarArquivoResponsavel();
	}
	
	public Responsavel buscarResponsavelNome(String nome) {
		for(int i=0; i<responsaveis.size(); i++) {
			if(responsaveis.get(i).getNome().contentEquals(nome)) {
				return responsaveis.get(i);
			}
		}
		return null;
	}
	
	public Responsavel buscarResponsavelLogin(String login) {
		for(int i=0; i<responsaveis.size(); i++) {
			if(responsaveis.get(i).getLogin().contentEquals(login)) {
				return responsaveis.get(i);
			}
		}
		return null;
	}
	
	public void alterarSenhaResponsavel(Responsavel responsavel) throws IOException{ 
		Responsavel r = buscarResponsavelLogin(responsavel.getLogin());
		
		responsavel.setSenha(r.getSenha());
		salvarArquivoResponsavel();
	}
	
	public void alterarNomeResponsavel(Responsavel responsavel) throws IOException{ 
		Responsavel r = buscarResponsavelLogin(responsavel.getLogin());
		
		responsavel.setNome(r.getNome());
		salvarArquivoResponsavel();
	}

	public ArrayList<Responsavel> getResponsaveis() {
		return responsaveis;
	}
}
