package sgedu.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;

public class VisualizaBoletimController {

    @FXML
    private ListView<String> lvBoletim;

    @FXML
    private Button btVoltar;
    
    Fachada fachada=Fachada.criaObjeto();
    
    public void carregarLista() {	
    	lvBoletim.getItems().add(fachada.visualizarBoletim(fachada.getUsuarioLogado().getLogin()));
    	
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();
    }

}
