package sgedu.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.main.Main;

/**
 * Class LoginAlunoController
 * @author Allysson
 *	Classe de controle para gerenciar a tela de login do aluno.
 */

public class LoginAlunoController implements Initializable {

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
    void botaoVoltar() {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    }
    
    @FXML
    void botaoLogar(ActionEvent event) {	
            try {
            	if(fachada.confirmaLoginAluno(tfLogin.getText(),pfSenha.getText())) {
            		///setando o usuario logado
            		fachada.setUsuarioLogado(fachada.buscarLoginAluno(tfLogin.getText()));

            		/////carregando a proxima tela
            		FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/AlunoLogado.fxml"));
            		Parent root = loader.load();
            		
            		AlunoLogadoController alunoLogadoController=loader.getController();
            		
            		///transferindo a informa��o do usuario logado para a proxima tela
            		alunoLogadoController.transferirMessagem(fachada.getUsuarioLogado().getNome());
            		
            		
            		
            		////////apaga as informa��e dos campos login e senha
    	    		tfLogin.setText("");
    	    		pfSenha.setText("");
    	    		
            		////troca a tela atual para o menu
            		Main.changeScreen("Menu");
            		
            		////exibe a nova tela com o usuario logado
            		
            		
            		Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Aluno Logado");
                    stage.show();
                    
                    
            		System.out.println("Logou aluno");
            	}else {
            		Main.changeScreen("menu");
            		System.out.println("falha no login");
            	}
			} catch (IOException e) {
				System.out.println(e);
			}
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    
    

}
