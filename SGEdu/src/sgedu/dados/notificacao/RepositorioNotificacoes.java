package sgedu.dados.notificacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sgedu.negocios.entidade.notificacao.Notificacao;

/**
 * Abaixo temos a classe para o repositório de Notificacao que serve para armazenar em um arraylist para salvar em um arquivo binário
 * todos os dados das Notificacoes criadas no sistema; e a implementação da interface IRepositorioNotificacoes.
 * @author laisy
 */

public class RepositorioNotificacoes implements IRepositorioNotificacoes{
	ArrayList <Notificacao> notificacoes;
	
	public RepositorioNotificacoes() {
		this.notificacoes=new ArrayList<Notificacao>();
	}
	
	
	/**
	 * Metodo para criar a salvar o arquivo de Notificacoes.
	 */
	public void salvarArquivoNotificacao() throws IOException {
		FileOutputStream file = new FileOutputStream("Notificacoes.dat");
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(notificacoes);
		os.close();
	}
	
	/**
	 * Metodo para buscar o arquivo na pasta, e assim verificar a existencia dele,
	 * caso nao encontre, ele cria um.
	 * Este metodo possui um tratamento de excecoes para excecoes do tipo ClassNotFoundException
	 * nao serem passadas pra cima.
	 */
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
	

	/**
	 * Metodo para buscar Notificacao atraves do remetente
	 * @param rementente da notificacao
	 * @return retorna a notificacao buscada, caso nao encontre retorna null;
	 */
	public Notificacao buscaNotificacaoRemetente(String remetente) {
		for(int i=0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getRemetente().contentEquals(remetente)) {
				return notificacoes.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para buscar Notificacao atraves do destinatario
	 * @param destinatario da notificacao
	 * @return retorna a notificacao buscada, caso nao encontre retorna null;
	 */
	public Notificacao buscaNotificacaoDestinatario(String destinatario) {
		for(int i=0; i<notificacoes.size(); i++) {
			if(notificacoes.get(i).getDestinatario().contentEquals(destinatario)) {
				return notificacoes.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Metodo para buscar Notificacao atraves do ID
	 * @param ID da notificacao
	 * @return retorna a notificacao buscada, caso nao encontre retorna null;
	 */
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