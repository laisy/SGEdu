package sgedu.dados.notificacao;

import java.io.IOException;

import sgedu.negocios.entidade.notificacao.Notificacao;

public interface IRepositorioNotificacoes {

	void salvarArquivoNotificacao() throws IOException;
	
	void buscarArquivoNotificacao() throws IOException;
	
	void addNotificacao(Notificacao noti) throws IOException;
	
	Notificacao buscaNotificacaoRemetente(String remetente);
	
	Notificacao buscaNotificacaoDestinatario(String destinatario);
	
	Notificacao buscaNotificacaoID(int id);
	
	void removerNotificacao(int id) throws IOException;
	
	void salvarContadorNotificacao() throws IOException;
}
