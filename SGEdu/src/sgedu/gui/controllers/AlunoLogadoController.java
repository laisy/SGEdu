package sgedu.gui.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sgedu.negocios.entidade.usuarios.Aluno;

public class AlunoLogadoController{

	@FXML
    private Button btVoltar;

    @FXML
    private Label lbNome;

    @FXML
    private Button btBoletim;

    @FXML
    private Button btNotificacoes;

    @FXML
    private Button btInformacoes;

    @FXML
    void botaoBoletim(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/VisualizaBoletim.fxml"));
			Parent root = loader.load();
			
			VisualizaBoletimController visualizaBoletimController=loader.getController();
			
			visualizaBoletimController.carregarLista();
		
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Visualiza boletim");
            stage.show();
			
		} catch (IOException e) {
			System.out.println("Erro");
		}	
    	
    }

    @FXML
    void botaoNotificacoes(ActionEvent event) {

    }


    @FXML
    void btInformacoes(ActionEvent event) {

    }

    
    public void transferirMessagem(String nome) {
        lbNome.setText(nome);
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();
    }

}
