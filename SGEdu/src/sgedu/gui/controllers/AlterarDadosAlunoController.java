package sgedu.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.negocios.entidade.usuarios.Aluno;

public class AlterarDadosAlunoController {

    @FXML
    private TextField tfLoginPesquisa;

    @FXML
    private Button btPesquisar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfResponsavel;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btAtualizar;
    
    @FXML
    private Label lbNotificacao;

    
    Fachada fachada=Fachada.criaObjeto();
    
    private boolean achouAluno=false;

    @FXML
    void botaoAtualizar(ActionEvent event) {
    	if(achouAluno) {
    		Aluno aluno=new Aluno(tfLoginPesquisa.getText(),tfNome.getText(),tfSenha.getText());	
    		fachada.alterarNomeAluno(aluno);
    		fachada.alterarSenhaAluno(aluno);
    		
    		if(fachada.buscarLoginResponsavel(tfResponsavel.getText())!=null) {
    			aluno=fachada.buscarLoginAluno(tfLoginPesquisa.getText());
    			aluno.setResponsavel(fachada.buscarLoginResponsavel(tfResponsavel.getText()));
    		}
    		
    	}else {
    		lbNotificacao.setText("Pesquise por um login valido");
    	}

    }

    @FXML
    void botaoPesquisar(ActionEvent event) {
    	String pesquisa=tfLoginPesquisa.getText();
    	Aluno aluno =fachada.buscarLoginAluno(pesquisa);    
    	if(aluno==null) {
    		lbNotificacao.setText("Login nao encontrado");
    	}else {
    		tfNome.setText(aluno.getNome());
    		tfSenha.setText(aluno.getSenha());
    		Object responsavel=aluno.getResponsavel();
    		if(responsavel!=null) {
    			tfResponsavel.setText(aluno.getResponsavel().getLogin());
    		}
    		achouAluno=true;
    	}

    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
