package sgedu.gui.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.entidade.usuarios.Professor;

public class VisualizarProfessoresController {

    @FXML
    private ListView<String> lvProfessores;

    @FXML
    private Button btVoltar;
    
    Fachada fachada=Fachada.criaObjeto();
    
    public void carregarLista() {
    	ArrayList<Professor> professores = fachada.getProfessores();
    	
    	for(int i=0;i<professores.size();i++) {
    		int j=i+1;
    		lvProfessores.getItems().add((j)+"  "+professores.get(i).toString());
    	}
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }
    
    

}
