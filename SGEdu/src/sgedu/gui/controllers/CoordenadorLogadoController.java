package sgedu.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import sgedu.negocios.entidade.turma.Disciplina;

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
    private Button btCrudProfessor;

    @FXML
    private Button btCrudResponsavel;

    @FXML
    private Button btCrudCoordenador;
   
    @FXML
    private Button btDisciplinas;
    
    @FXML
    private Button btTurmas;

    
    Fachada fachada=Fachada.criaObjeto();
    
    @FXML
    void botaoTurmas(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/Turmas.fxml"));
			Parent root = loader.load();
			
			TurmasController turmaController=loader.getController();
			turmaController.carregarLista();
			
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Turmas");
            stage.show();
           
			
		} catch (IOException e) {
			System.out.println("Erro");
		}

    }

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
			System.out.println("Erro");
		}
		
		

    }
    
    @FXML
    void botaoCrudCoordenador(ActionEvent event) {

    }

    @FXML
    void botaoCrudProfessor(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/CrudProfessor.fxml"));
			Parent root = loader.load();
			
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("CRUD professor");
            stage.show();
			
		} catch (IOException e) {
			System.out.println("Erro");
		}
    }

    @FXML
    void botaoCrudResponsavel(ActionEvent event) {

    }
    

    
    public void transferirMessagem(String nome) {
        lbNome.setText(nome);
    }
    
    @FXML
    void botaoDisciplinas(ActionEvent event) {	
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/Disciplinas.fxml"));
			Parent root = loader.load();
			
			DisciplinasController disciplinasController=loader.getController();
			
			
			
			ArrayList<Disciplina> disciplinas=fachada.getDisciplinas();
			disciplinasController.carregarLista();
		
			
			////exibe a nova tela com o usuario logado 		
			Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.setTitle("Disciplina");
	        stage.show();
    	}catch(IOException e) {
    		System.out.println("Erro");
		}
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();
    }


}
