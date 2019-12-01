package sgedu.gui.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.main.Main;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.Aluno;

public class DisciplinasController {

    @FXML
    private TextField tfNome1;

    @FXML
    private TextField tfQuantidadeAula;

    @FXML
    private Button btCadastrar;

    @FXML
    private ListView<String> lvDisciplinas;

    @FXML
    private TextField tfNome2;

    @FXML
    private TextField tfProfessor;

    @FXML
    private Button btAdicionar;

    @FXML
    private Label lbNotificacao;

    @FXML
    private Button btRemover;

    @FXML
    private Button btVoltar;
    
    private boolean confirmar=false;
    
    Fachada fachada=Fachada.criaObjeto();
    
    @FXML
    void botaoAdicionarProfessor(ActionEvent event) {
    	
    	if(!confirmar) {
    		lbNotificacao.setText("Deseja adicionar "+tfProfessor.getText()+" na turma?\n"
    				+"Aperte Adicionar professor para confirmar");
    	}else {
    		fachada.addProfessorTurma(tfNome2.getText(), tfProfessor.getText());
    		lbNotificacao.setText("Professor adicionado a turma");
    	}
    	
    	confirmar=true;
    	

    }
    
    public void carregarLista() {
    	ArrayList<Disciplina> disciplinas=fachada.getDisciplinas();
    	for(int i=0;i<disciplinas.size();i++) {
    		int j=i+1;
    		lvDisciplinas.getItems().add((j)+"  "+disciplinas.get(i).toString());
    	}
    }
    
    
    /////metodo para converter string em int
    public static int strToInt(String valor, int padrao) 
    {
       try {
           return Integer.valueOf(valor); // Para retornar um Integer, use Integer.parseInt
       } 
       catch (NumberFormatException e) {  // Se houver erro na conversão, retorna o valor padrão
           return padrao;
       }
    }

    @FXML
    void botaoCadastrar(ActionEvent event) {
    	int aulas=strToInt(tfQuantidadeAula.getText(),-1);
    	
    	if(aulas>0) {
    		fachada.adicionarDisciplina(tfNome1.getText(), aulas);
    		lbNotificacao.setText("Disciplina adicionada com sucesso");
    	}else {
    		lbNotificacao.setText("Insira um valor numero para a quantidade de aulas");
    	}
    }

    @FXML
    void botaoRemover(ActionEvent event) {
    	if(!confirmar) {
    		lbNotificacao.setText("Aperte em Remover disciplina para confirmar");
    	}else {
    		fachada.removeDisciplina(tfNome1.getText());
    		lbNotificacao.setText("Disciplina removida");
    		confirmar=false;
    	}
    	confirmar=true;
    	
    	
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();
    }

}
