package sgedu.gui.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sgedu.negocios.entidade.usuarios.Aluno;

public class VisualizarAlunosController {

    @FXML
    private ListView<String> lvAlunos;
    
    
    public void carregarLista(ArrayList<Aluno> alunos) {
    	for(int i=0;i<alunos.size();i++) {
    		int j=i+1;
    		lvAlunos.getItems().add((j)+"  "+alunos.get(i).toString());
    	}
    }
    
    @FXML
    private Button btVoltar;

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
