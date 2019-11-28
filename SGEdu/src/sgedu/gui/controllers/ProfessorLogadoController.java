package sgedu.gui.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sgedu.fachada.Fachada;
import sgedu.main.Main;

public class ProfessorLogadoController {
	 @FXML
	    private Button btVoltar;
	    

	    @FXML
	    private TextField tfNome;
	    @FXML
	    private Label lbNome;

	    
	    Fachada fachada=Fachada.criaObjeto();
	  
	    
	    public void transferirMessagem(String nome) {
	        lbNome.setText(nome);
	    }

	    @FXML
	    void botaoVoltar(ActionEvent event) {
	    	System.out.println("voltar menu");
	    	Main.changeScreen("Menu");
	    }
}
