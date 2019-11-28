package sgedu.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.main.Main;

public class LoginProfessorController {


    @FXML
    private Button btVoltar;
    
    @FXML
    private TextField tfLogin;

    @FXML
    private Button btLogar;
    
    @FXML
    private PasswordField pfSenha;
    
    Fachada fachada=Fachada.criaObjeto();

    @FXML
    void botaoLogar(ActionEvent event) {
    	 try {
         	if(fachada.confirmaLoginProfessor(tfLogin.getText(),pfSenha.getText())) {
         		///setando o usuario logado
         		fachada.setUsuarioLogado(fachada.buscarLoginProfessor(tfLogin.getText()));
         		
         		/////carregando a proxima tela
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/ProfessorLogado.fxml"));
        		Parent root = loader.load();
        		
        		ProfessorLogadoController professorLogadoController=loader.getController();
        		
        		///transferindo a informação do usuario logado para a proxima tela
        		professorLogadoController.transferirMessagem(fachada.getUsuarioLogado().getNome());
        	
        		
        		
        		////////apaga as informaçõe dos campos login e senha
        	    		tfLogin.setText("");
        	    		pfSenha.setText("");
        	    		
        	    ////troca a tela atual para o menu
        		Main.changeScreen("Menu");
        		
        		////exibe a nova tela com o usuario logado
        		
        		
        		Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Professor Logado");
                stage.show();
                	
         	}
         	}catch(IOException e) {
				System.out.println(e);
				
         	}

    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    }
    

}
