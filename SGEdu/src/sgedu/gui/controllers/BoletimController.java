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
import sgedu.negocios.entidade.turma.Turma;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.entidade.usuarios.Professor;

public class BoletimController {

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btVoltar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfAno;

    @FXML
    private ListView<String> lvAlunos;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tf1Bimestre;

    @FXML
    private TextField tf2Bimestre;

    @FXML
    private TextField tf3Bimestre;

    @FXML
    private TextField tf4Bimestre;

    @FXML
    private Button btSalvarNotas;

    @FXML
    private Button btFaltas1;

    @FXML
    private Button btFaltas2;

    @FXML
    private Button btFaltas3;

    @FXML
    private Button btFaltas4;
    
    @FXML
    private Label lbNotificacao;
    
    Fachada fachada=Fachada.criaObjeto();
    
    private boolean achou=false;

    public void carregarLista() {
    	if(achou) {
	    	int ano=strToInt(tfAno.getText(),0);
	    	ArrayList<Aluno> alunos=fachada.getAlunosEmTurma(tfNome.getText(), ano);
	    	for(int i=0;i<alunos.size();i++) {
	    		int j=i+1;
	    		lvAlunos.getItems().add((j)+"  "+alunos.get(i).toString());
	    	}
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
    
    /////metodo para converter string em int
    public static double douToInt(String valor, double padrao) 
    {
       try {
           return Double.valueOf(valor); // Para retornar um Integer, use Integer.parseInt
       } 
       catch (NumberFormatException e) {  // Se houver erro na convers�o, retorna o valor padr�o
           return padrao;
       }
    }
    
    @FXML
    void botaoFaltas1(ActionEvent event) {
    	int ano=strToInt(tfAno.getText(),0);
		Professor professor=fachada.buscarLoginProfessor(fachada.getUsuarioLogado().getLogin());
		
    	fachada.adicionarFrequencia(tfLogin.getText(), professor.getDisciplina().getNome(), ano, 1);
    	lbNotificacao.setText("Faltas adicionadas no 1 Bimestre");
    }

    @FXML
    void botaoFaltas2(ActionEvent event) {
    	int ano=strToInt(tfAno.getText(),0);
		Professor professor=fachada.buscarLoginProfessor(fachada.getUsuarioLogado().getLogin());
    	fachada.adicionarFrequencia(tfLogin.getText(), professor.getDisciplina().getNome(), ano, 2);
    	lbNotificacao.setText("Faltas adicionadas no 2 Bimestre");
    }

    @FXML
    void botaoFaltas3(ActionEvent event) {
    	int ano=strToInt(tfAno.getText(),0);
		Professor professor=fachada.buscarLoginProfessor(fachada.getUsuarioLogado().getLogin());
    	fachada.adicionarFrequencia(tfLogin.getText(), professor.getDisciplina().getNome(), ano, 3);
    	lbNotificacao.setText("Faltas adicionadas no 3 Bimestre");
    }

    @FXML
    void botaoFaltas4(ActionEvent event) {
    	int ano=strToInt(tfAno.getText(),0);
		Professor professor=fachada.buscarLoginProfessor(fachada.getUsuarioLogado().getLogin());
    	fachada.adicionarFrequencia(tfLogin.getText(), professor.getDisciplina().getNome(), ano, 4);
    	lbNotificacao.setText("Faltas adicionadas no 4 Bimestre");

    }

    @FXML
    void botaoPesquisa(ActionEvent event) {
    	int ano=strToInt(tfAno.getText(),0);
    	Turma turma =fachada.buscarTurma(tfNome.getText(), ano);
    	if(turma==null) {
    		lbNotificacao.setText("Login nao encontrado");
    	}else {
    		achou=true;
    		carregarLista();
    		}
    		achou=true;
    	}

    

    @FXML
    void botaoSalvar(ActionEvent event) {
    	if(tfLogin.getText()!=null) {
    		int ano=strToInt(tfAno.getText(),0);
    		Professor professor=fachada.buscarLoginProfessor(fachada.getUsuarioLogado().getLogin());
    				
    		double nota1=douToInt(tf1Bimestre.getText(),-1);
    		double nota2=douToInt(tf2Bimestre.getText(),-1);
    		double nota3=douToInt(tf3Bimestre.getText(),-1);
    		double nota4=douToInt(tf4Bimestre.getText(),-1);
    		
    		
    		fachada.adicionarAvaliacao(tfLogin.getText(),professor.getDisciplina(), ano, nota1, nota2, nota3, nota4);
    		lbNotificacao.setText("Notas adicionadas");
    		
    	}else {
    		lbNotificacao.setText("Insira um login valido");
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
