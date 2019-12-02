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

/**
 * Class LoginCoordenadorController
 * @author Allysson
 *	Classe de controle para gerenciar a tela de login do Coordenador.
 */
public class LoginCoordenadorController {

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
    	if(fachada.confirmaLoginCoordenador(tfLogin.getText(),pfSenha.getText())) {
    		try {
	    		///setando o usuario logado
	    		fachada.setUsuarioLogado(fachada.buscarLoginCoordenador(tfLogin.getText()));
	    		
	    		
	    		/////carregando a proxima tela
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/CoordenadorLogado.fxml"));
	    		Parent root = loader.load();
	    		
	    		CoordenadorLogadoController coordenadorLogadoController=loader.getController();
	    		
	    		
	    		
	    		///transferindo a informa��o do usuario logado para a proxima tela
	    		coordenadorLogadoController.transferirMessagem(fachada.getUsuarioLogado().getNome());
	
	    		////////apaga as informa��e dos campos login e senha
	    		tfLogin.setText("");
	    		pfSenha.setText("");
	    		
	    		////troca a tela atual para o menu
	    		Main.changeScreen("Menu");
        		
	    		////exibe a nova tela com o usuario logado 		
        		Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Coordenador Logado");
                stage.show();

    		
    		
    		
    		
    		
    		
	    		System.out.println("Logou coordenador");
    		}catch(IOException e) {
    			System.out.println("Erro");
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
