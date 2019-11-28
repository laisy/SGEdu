package sgedu.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class CoordenadorLogadoController {
	
	
	
	@FXML
	private Button btVoltar;
	    

    @FXML
    private TextField tfNome;
    @FXML
    private Label lbNome;

    
    @FXML
    private Button btCrudAluno;

    @FXML
    void botaoCrudAluno(ActionEvent event) {	
		try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/CrudAluno.fxml"));
			Parent root = loader.load();
			
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("CRUD aluno");
            stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

    }
    

    
    public void transferirMessagem(String nome) {
        lbNome.setText(nome);
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();
    }


}
