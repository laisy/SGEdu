package sgedu.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sgedu.main.Main;

/**
 * Class MenuController
 * @author Allysson
 *	Classe de controle para gerenciar a primeira tela de logins.
 */

public class MenuController {

    @FXML
    private Button loginAluno;

    @FXML
    private Button loginProfessor;

    @FXML
    private Button loginCoordenador;
    
    @FXML
    void btAluno(ActionEvent event) {
    	System.out.println("Login aluno");
    	Main.changeScreen("LoginAluno");
	
    }
    
    @FXML
    void btResponsavel(ActionEvent event) {
    	System.out.println("Login Responsavel");
    	Main.changeScreen("LoginResponsavel");

    }
    
    @FXML
    void btProfessor(ActionEvent event) {	
    	System.out.println("Login Profesor");
    	Main.changeScreen("LoginProfessor");
	
    }
    
    @FXML
    void btCoordenador(ActionEvent event) {
    	System.out.println("Login Coordenador");
    	Main.changeScreen("LoginCoordenador");
    	
	
    }
    
   
    

}
