package sgedu.gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.main.Main;

public class AlunoLogadoController  implements Initializable {

    @FXML
    private Button btVoltar;
    

    @FXML
    private TextField tfNome;
    @FXML
    private Label lbNome;

    
    Fachada fachada=Fachada.criaObjeto();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
