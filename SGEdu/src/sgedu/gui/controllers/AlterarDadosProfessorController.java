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
    
    @FXML
    private TextField tfNomeTurma;

    @FXML
    private TextField tfAno;

    
    private ObservableList<String> obsDisciplinas;
    
    Fachada fachada=Fachada.criaObjeto();
    
    private boolean achou=false;
    
    @FXML
    void carregarLista() {
    	ArrayList<Disciplina> dis=fachada.getDisciplinas();
    	List<String> disciplinas=new ArrayList<>();
    	
    	for(int i =0;i<dis.size();i++) {
    		disciplinas.add(dis.get(i).getNome());
    	}
    	
    	obsDisciplinas=FXCollections.observableArrayList(disciplinas);
    	
    	cbDisciplina.setItems(obsDisciplinas);

    }

    @FXML
    void botaoAtualizar(ActionEvent event) {
    	if(achou) {
    		if(cbDisciplina.getSelectionModel().getSelectedItem()!=null) {
    			int ano=strToInt(tfAno.getText(),0);
    			
    			Professor professor=new Professor(tfLoginPesquisa.getText(),tfNome.getText(),tfSenha.getText(),fachada.buscarDisciplina(cbDisciplina.getSelectionModel().getSelectedItem()));	
    			fachada.alteraNomeProfessor(professor);
        		fachada.alterarSenhaProfessor(professor);
        		fachada.alterarDisciplinaProfessor(tfLoginPesquisa.getText(), cbDisciplina.getSelectionModel().getSelectedItem());
        		
        		fachada.adicionaTurmaProfessor(tfLoginPesquisa.getText(), tfNomeTurma.getText(), ano);
    		}else {
    			lbNotificacao.setText("Selecione a disciplina");
    		} 		
    	}else {
    		lbNotificacao.setText("Pesquise por um login valido");
    	}
    }
    
    /////metodo para converter string em int
    public static int strToInt(String valor, int padrao) 
    {
       try {
           return Integer.valueOf(valor); // Para retornar um Integer, use Integer.parseInt
       } 
       catch (NumberFormatException e) {  // Se houver erro na convers�o, retorna o valor padr�o
           return padrao;
       }
    }

    @FXML
    void botaoPesquisar(ActionEvent event) {
    	String pesquisa=tfLoginPesquisa.getText();
    	Professor professor =fachada.buscarLoginProfessor(pesquisa);  
    	if(professor==null) {
    		lbNotificacao.setText("Login nao encontrado");
    		achou=false;
    	}else {
    		tfNome.setText(professor.getNome());
    		tfSenha.setText(professor.getSenha());
    		achou=true;
    		}
    	}

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
