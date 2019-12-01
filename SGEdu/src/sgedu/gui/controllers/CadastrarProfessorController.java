package sgedu.gui.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

public class CadastrarProfessorController {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfSenha;

    @FXML
    private TextField tfSenha2;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastrar;

    @FXML
    private Label lbNotificacao;

    @FXML
    private ComboBox<String> cbDisciplinas;
    
    Fachada fachada=Fachada.criaObjeto();
    
    
    private ObservableList<String> obsDisciplinas;

    @FXML
    void botaoCadastrar(ActionEvent event) {
    	try {
			fachada.adicionarProfessor(tfLogin.getText(), tfNome.getText(), tfSenha.getText(), cbDisciplinas.getSelectionModel().getSelectedItem());
			lbNotificacao.setText("Professor cadastrado com sucesso");
    	} catch (UsuarioJaCadastradoException e) {
			lbNotificacao.setText("Login ja existente");
			e.printStackTrace();
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
    
    @FXML
    void carregarLista() {
    	ArrayList<Disciplina> dis=fachada.getDisciplinas();
    	List<String> disciplinas=new ArrayList<>();
    	
    	for(int i =0;i<dis.size();i++) {
    		disciplinas.add(dis.get(i).getNome());
    		System.out.println(disciplinas.get(i));
    	}
    	
    	obsDisciplinas=FXCollections.observableArrayList(disciplinas);
    	
    	cbDisciplinas.setItems(obsDisciplinas);

    }

}
