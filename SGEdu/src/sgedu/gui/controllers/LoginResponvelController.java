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

public class LoginResponvelController {


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
    void BotaoLogar(ActionEvent event) {
    	if(fachada.confirmaLoginResponsavel(tfLogin.getText(),pfSenha.getText())) {
    		try {
	    		///setando o usuario logado
	    		fachada.setUsuarioLogado(fachada.buscarLoginResponsavel(tfLogin.getText()));
	    		
	    		
	    		/////carregando a proxima tela
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/ResponsavelLogado.fxml"));
	    		Parent root = loader.load();
	    		
	    		ResponsavelLogadoController responsavelLogadoController=loader.getController();
	    		
	    		
	    		
	    		///transferindo a informação do usuario logado para a proxima tela
	    		responsavelLogadoController.transferirMessagem(fachada.getUsuarioLogado().getNome());
	
	    		////////apaga as informaçõe dos campos login e senha
	    		tfLogin.setText("");
	    		pfSenha.setText("");
	    		
	    		////troca a tela atual para o menu
	    		Main.changeScreen("Menu");
        		
	    		////exibe a nova tela com o usuario logado 		
        		Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Responsavel Logado");
                stage.show();

    		
    		
    		
    		
    		
    		
	    		System.out.println("Logou Responsavel");
    		}catch(IOException e) {
				System.out.println(e);
			}
    	}else {
    		Main.changeScreen("menu");
    		System.out.println("falha no login");
    	}
    	

    }

    
    
    
    
    
    

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    }

}
