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
import sgedu.fachada.Fachada;
import sgedu.negocios.entidade.usuarios.Aluno;


public class CrudAlunoController {
	 @FXML
    private Button btCadastrar;

    @FXML
    private Button btAlterarDados;

    @FXML
    private Button btRemover;

    @FXML
    private Button btVisualizarAlunos;

    @FXML
    private Button btVoltar;
    
    Fachada fachada=Fachada.criaObjeto();

    @FXML
    void botaoAlterarDados(ActionEvent event) {
    	
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/AlterarDadosAluno.fxml"));
			Parent root = loader.load();
		
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("altera dados de aluno");
            stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void botaoCadastrar(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/CadastrarAluno.fxml"));
			Parent root = loader.load();
		
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastro de aluno");
            stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void botaoRemover(ActionEvent event) {

    }

    @FXML
    void botaoVisualizarAlunos(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/VisualizarAlunos.fxml"));
			Parent root = loader.load();
			
			VisualizarAlunosController visualizarAlunosController=loader.getController();
			ArrayList<Aluno> alunos=fachada.getAlunos();
			visualizarAlunosController.carregarLista(alunos);
		
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Visualiza alunos");
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
