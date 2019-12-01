package sgedu.gui.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sgedu.negocios.entidade.usuarios.Aluno;

public class CrudProfessorController {

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btVisualiza;

    @FXML
    private Button btAlterarDados;

    @FXML
    private Button btRemover;

    @FXML
    private Button btVoltar;

    @FXML
    void botaoAlterarDados(ActionEvent event) {
    	try {
    			/////carregando a proxima tela
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/AlterarDadosProfessor.fxml"));
    			Parent root = loader.load();
    			
    			AlterarDadosProfessorController alterarDadosProfessorController=loader.getController();
    			
    		
    			Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("alterar dados de professor");
                stage.show();
                
                alterarDadosProfessorController.carregarLista();
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}

    }

    @FXML
    void botaoCadastrar(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/CadastrarProfessor.fxml"));
			Parent root = loader.load();
			
			CadastrarProfessorController cadastrarProfessorController=loader.getController();
			
		
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastro de professor");
            stage.show();
            
            cadastrarProfessorController.carregarLista();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void botaoRemover(ActionEvent event) {

    }

    @FXML
    void botaoVisualiza(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/VisualizarProfessores.fxml"));
			Parent root = loader.load();
			
			VisualizarProfessoresController visualizarProfessoresController=loader.getController();
			
			visualizarProfessoresController.carregarLista();
		
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Visualiza Professores");
            stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
