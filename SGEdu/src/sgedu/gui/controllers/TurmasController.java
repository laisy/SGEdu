package sgedu.gui.controllers;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.main.Main;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.turma.Turma;

public class TurmasController {

    @FXML
    private TextField tfnome;

    @FXML
    private TextField tfAno;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btCadastrar;

    @FXML
    private ListView<String> lvTurmas;

    @FXML
    private Button btAdicionar;

    @FXML
    private TextField tfNomeBusca;
    
    private boolean confirmar=false;
    
    Fachada fachada=Fachada.criaObjeto();
    
    public void carregarLista() {
    	ArrayList<Turma> turma=fachada.getTurmas();
    	for(int i=0;i<turma.size();i++) {
    		int j=i+1;
    		lvTurmas.getItems().add((j)+"  "+turma.get(i).toString());
    	}
    }

    @FXML
    void botaoAdicionar(ActionEvent event) {
    	
    	
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
    	int numero=strToInt(tfAno.getText(),0);
    	fachada.adicionarTurma(tfnome.getText(), numero);
    }

    @FXML
    void botaoVoltar(ActionEvent event) {
    	System.out.println("voltar menu");
    	Main.changeScreen("Menu");
    	Stage stage = (Stage) btVoltar.getScene().getWindow();
    	stage.close();	
    }

}
