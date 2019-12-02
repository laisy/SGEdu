package sgedu.gui.controllers;



import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.main.Main;

public class ProfessorLogadoController {
	   @FXML
	    private Button btVoltar;

	    @FXML
	    private Label lbNome;

	    @FXML
	    private Button btInformacoes;

	    @FXML
	    private Button btAdicionarNotas;

	    @FXML
	    private Button btNotificacao;

	    Fachada fachada=Fachada.criaObjeto();	    
	    
	    @FXML
	    void botaoAdicionarNotas(ActionEvent event) {
	    	try {
				/////carregando a proxima tela
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/BoletimController.fxml"));
				Parent root = loader.load();
			
				
				Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.setTitle("Adicionar notas");
	            stage.show();
	           
				
			} catch (IOException e) {
				e.printStackTrace();
			}

	    }

	    @FXML
	    void botaoInformacoes(ActionEvent event) {

	    }

	    @FXML
	    void botaoNotificacao(ActionEvent event) {

	    }
	  
	    
	    public void transferirMessagem(String nome) {
	        lbNome.setText(nome);
	    }

	    @FXML
	    void botaoVoltar(ActionEvent event) {
	    	System.out.println("voltar menu");
	    	Main.changeScreen("Menu");
	    }
}
