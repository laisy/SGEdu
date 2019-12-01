package sgedu.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.negocios.entidade.usuarios.Aluno;

public class RemoverAlunoController {

    @FXML
    private TextField tfLogin;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btBuscar;

    @FXML
    private Label lbNotificacao;

    @FXML
    private Button btConfirmar;
    
    private boolean achouAluno=false;
    
    Fachada fachada=Fachada.criaObjeto();

    @FXML
    void botaoBuscar(ActionEvent event) {
    	String pesquisa=tfLogin.getText();
    	Aluno aluno =fachada.buscarLoginAluno(pesquisa);    
    	if(aluno==null) {
    		lbNotificacao.setText("Login nao encontrado");
    	}else {
    		lbNotificacao.setText("Deseja realmente apagar "+aluno.getNome()+"?");
    		
    		achouAluno=true;
    	}
    }

    @FXML
    void botaoConfirmar(ActionEvent event) {
    	if(achouAluno) {
    		String pesquisa=tfLogin.getText();
        	Aluno aluno =fachada.buscarLoginAluno(pesquisa);
        	fachada.removerAluno(aluno.getLogin());
        	lbNotificacao.setText("Aluno(a) removido com sucesso");
    		
    	}else {
    		lbNotificacao.setText("Pesquise por um login valido");
    	}

    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
