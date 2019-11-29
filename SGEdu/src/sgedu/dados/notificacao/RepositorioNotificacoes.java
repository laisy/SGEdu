package sgedu.dados.notificacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sgedu.negocios.entidade.notificacao.Notificacao;

public class RepositorioNotificacoes implements IRepositorioNotificacoes{
	ArrayList <Notificacao> notificacoes;
	
	public RepositorioNotificacoes() {
		this.notificacoes=new ArrayList<Notificacao>();
	}
	
	public void salvarArquivoNotificacao() throws IOException {
		FileOutputStream file = new FileOutputStream("Notificacoes.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(notificacoes);
		os.close();
	}
	
	public void buscarArquivoNotificacao() throws IOException{
		try {
			FileInputStream file = new FileInputStream("Notificacoes.dat");
			ObjectInputStream is = new ObjectInputStream(file);
			notificacoes = (ArrayList<Notificacao>) is.readObject();
			is.close();
			salvarArquivoNotificacao();
		} catch(IOException | ClassNotFoundException e) {
			salvarArquivoNotificacao();
		}
		
	}
	
	public void addNotificacao(Notificacao noti) throws IOException {
		notificacoes.add(noti);
		salvarArquivoNotificacao();
	}
	
	public Notificacao buscaNotificacaoRemetente(String remetente) {
		for(int i=0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getRemetente().contentEquals(remetente)) {
				return notificacoes.get(i);
			}
		}
		return null;
	}
	
	public Notificacao buscaNotificacaoDestinatario(String destinatario) {
		for(int i=0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getDestinatario().contentEquals(destinatario)) {
				return notificacoes.get(i);
			}
		}
		return null;
	}
	
	public Notificacao buscaNotificacaoID(int id) {
		for(int i=0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getId()==id) {
				return notificacoes.get(i);
			}
		}
		return null;
	}
	
	public void removerNotificacao(int id) throws IOException {
		Notificacao noti = buscaNotificacaoID(id);
		notificacoes.remove(noti);
		salvarArquivoNotificacao();
	}

}