package sgedu.gui.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    @FXML
    private Label lbNotificacao;
    
    @FXML
    private Button btApagar;
    
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
    void botaoApagar(ActionEvent event) {
    	if(!confirmar) {
    		lbNotificacao.setText("deseja remover "+tfnome.getText()+"?\n"
    				+ "Aperte em Remover turma para confirmar");
    	}else {
    		int numero=strToInt(tfAno.getText(),0);
    		fachada.removerTurma(tfnome.getText(), numero);
    		lbNotificacao.setText("turma removida");
    		confirmar=false;
    	}
    	confirmar=true;

    }

    @FXML
    void botaoAdicionar(ActionEvent event) {
    	try {
			/////carregando a proxima tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../telas/AdicionarEmTurma.fxml"));
			Parent root = loader.load();
			
			AdicionarEmTurmaController adicionarEmTurmaController=loader.getController();
			
			
			Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Adicionar em turma");
            stage.show();
            adicionarEmTurmaController.carregarLista();
           
			
		} catch (IOException e) {
			System.out.println("Erro");
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
