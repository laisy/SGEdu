package sgedu.gui.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

public class CadastrarAlunoController {
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField tfLogin;

    @FXML
    private Label lbConfimra;

    @FXML
    private TextField tfSenha2;

    
    Fachada fachada=Fachada.criaObjeto();

    @FXML
    void botaoCadastrar(ActionEvent event) {
    	Aluno aluno = new Aluno(tfLogin.getText(),tfNome.getText(),tfSenha.getText());
    	

		try {
			fachada.adicionarAluno(aluno);
			lbConfimra.setText("Aluno Cadastrado");
			System.out.println(aluno.getLogin());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}catch(UsuarioJaCadastradoException e) {
			lbConfimra.setText("Login ja existente");
		}
    	

    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	

    }

}
