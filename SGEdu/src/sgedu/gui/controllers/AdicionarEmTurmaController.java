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
import sgedu.main.Main;
import sgedu.negocios.entidade.turma.Disciplina;

public class AdicionarEmTurmaController {

    @FXML
    private TextField tfNome2;

    @FXML
    private TextField tdAno2;

    @FXML
    private TextField tfLogin;

    @FXML
    private Button btAdicionarAluno;

    @FXML
    private ComboBox<String> cbDisciplinas;

    @FXML
    private TextField tfNome1;

    @FXML
    private TextField tfAno1;

    @FXML
    private Button btAdicionarDisciplina;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Label lbNotificacao;

    
    private ObservableList<String> obsDisciplinas;
  
    Fachada fachada=Fachada.criaObjeto();

    private boolean confirmar=false;
    
    @FXML
    void botaoAdicionarAluno(ActionEvent event) {
    	if(!confirmar) {
    		lbNotificacao.setText("Deseja adicionar "+tfLogin.getText()+" na turma?\n"
    				+"Aperte Adicionar aluno para confirmar");
    	}else {
    		int ano=strToInt(tdAno2.getText(),-1);
    		fachada.adicionarAlunoEmTurma(tfNome2.getText(), ano, tfLogin.getText());
    		lbNotificacao.setText("Aluno adicionado a turma");
    	}
    	
    	confirmar=true;
    	

    }

    @FXML
    void botaoAdicionarDisciplinas(ActionEvent event) {
    	int ano=strToInt(tfAno1.getText(),-1);
    	fachada.adicionarDisciplinaEmTurma(tfNome1.getText(), ano, cbDisciplinas.getSelectionModel().getSelectedItem());	
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
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
