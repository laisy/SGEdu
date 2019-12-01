package sgedu.gui.controllers;

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
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.entidade.usuarios.Professor;


public class AlterarDadosProfessorController {

    @FXML
    private TextField tfLoginPesquisa;

    @FXML
    private Button btPesquisar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;

    @FXML
    private Label lbNotificacao;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btAtualizar;

    @FXML
    private ComboBox<String> cbDisciplina;

    @FXML
    private ComboBox<String> cbTurma;
    
    private ObservableList<String> obsDisciplinas;
    
    Fachada fachada=Fachada.criaObjeto();
    
    private boolean achouAluno=false;
    
    @FXML
    void carregarLista() {
    	ArrayList<Disciplina> dis=fachada.getDisciplinas();
    	List<String> disciplinas=new ArrayList<>();
    	
    	for(int i =0;i<dis.size();i++) {
    		disciplinas.add(dis.get(i).getNome());
    		System.out.println(disciplinas.get(i));
    	}
    	
    	obsDisciplinas=FXCollections.observableArrayList(disciplinas);
    	
    	cbDisciplina.setItems(obsDisciplinas);

    }

    @FXML
    void botaoAtualizar(ActionEvent event) {
    	if(achouAluno) {
    		if(cbDisciplina.getSelectionModel().getSelectedItem()!=null) {
    			Professor professor=new Professor(tfLoginPesquisa.getText(),tfNome.getText(),tfSenha.getText(),fachada.buscarDisciplina(cbDisciplina.getSelectionModel().getSelectedItem()));	
    			fachada.alteraNomeProfessor(professor);
        		fachada.alterarSenhaProfessor(professor);
    		}else {
    			lbNotificacao.setText("Selecione a disciplina");
    		} 		
    	}else {
    		lbNotificacao.setText("Pesquise por um login valido");
    	}
    }

    @FXML
    void botaoPesquisar(ActionEvent event) {
    	String pesquisa=tfLoginPesquisa.getText();
    	Professor professor =fachada.buscarLoginProfessor(pesquisa);  
    	if(professor==null) {
    		lbNotificacao.setText("Login nao encontrado");
    	}else {
    		tfNome.setText(professor.getNome());
    		tfSenha.setText(professor.getSenha());
    	}
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
