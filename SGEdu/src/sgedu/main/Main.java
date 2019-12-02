package sgedu.main;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sgedu.fachada.Fachada;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;

import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.usuarios.*;

/**
 * Class Main
 * @author Allysson
 * A classe Main extende de Application a partir da qual os aplicativos JavaFX se estendem.
 * A classe Main instancia a fachada, e faz a integração do sistema com a GUI.
 */

public class Main extends Application {
	
	///variaveis staticas para formar o "cache" de cenas para trocar
	private static Stage stage;
	private static Scene menu;
	private static Scene loginAluno;
	private static Scene loginProfessor;
	private static Scene loginResponsavel;
	private static Scene loginCoordenador;
	private static Scene AlunoLogado;
	private static Scene ProfessorLogado;
	private static Scene CoordenadorLogado;
	private static Scene ResponsavelLogado;
	
	@Override
	public void start(Stage Pstage) throws Exception {
		stage=Pstage;
		
		///criando o cache de cenas
		Parent FXMLMenu = FXMLLoader.load(getClass().getResource("../gui/telas/Menu.fxml"));
		menu=new Scene(FXMLMenu);
		
		Parent FXMLLoginAluno = FXMLLoader.load(getClass().getResource("../gui/telas/LoginAluno.fxml"));
		loginAluno=new Scene(FXMLLoginAluno);
		
		Parent FXMLLoginProfessor = FXMLLoader.load(getClass().getResource("../gui/telas/LoginProfessor.fxml"));
		loginProfessor=new Scene(FXMLLoginProfessor);
		
		Parent FXMLLoginResponsavel = FXMLLoader.load(getClass().getResource("../gui/telas/LoginResponsavel.fxml"));
		loginResponsavel=new Scene(FXMLLoginResponsavel);
		
		Parent FXMLLoginCoordenador = FXMLLoader.load(getClass().getResource("../gui/telas/LoginCoordenador.fxml"));
		loginCoordenador=new Scene(FXMLLoginCoordenador);
		
		Parent FXMLAlunoLogado = FXMLLoader.load(getClass().getResource("../gui/telas/AlunoLogado.fxml"));
		AlunoLogado=new Scene(FXMLAlunoLogado);

		Parent FXMLProfessorLogado = FXMLLoader.load(getClass().getResource("../gui/telas/ProfessorLogado.fxml"));
		ProfessorLogado=new Scene(FXMLProfessorLogado);
		
		Parent FXMLResponsavelLogado = FXMLLoader.load(getClass().getResource("../gui/telas/ResponsavelLogado.fxml"));
		ResponsavelLogado=new Scene(FXMLResponsavelLogado);
		
		Parent FXMLCoordenadorLogado = FXMLLoader.load(getClass().getResource("../gui/telas/CoordenadorLogado.fxml"));
		CoordenadorLogado=new Scene(FXMLCoordenadorLogado);
		
		
		stage.setScene(menu);
		stage.show();		
	}
	
	///metodo que troca as cenas
	
	public static void changeScreen(String scr) {
		switch(scr) {
			case "Menu":
				stage.setScene(menu);
				break;
			case "LoginAluno":
				stage.setScene(loginAluno);
				break;
			case "LoginProfessor":
				stage.setScene(loginProfessor);
				break;
			case "LoginResponsavel":
				stage.setScene(loginResponsavel);
				break;
			case "LoginCoordenador":
				stage.setScene(loginCoordenador);
				break;
			case "AlunoLogado":
				stage.setScene(AlunoLogado);
				break;
			case "ProfessorLogado":
				stage.setScene(ProfessorLogado);
				break;
			case "CoordenadorLogado":
				stage.setScene(CoordenadorLogado);
				break;
			case "ResponsavelLogado":
				stage.setScene(ResponsavelLogado);
				break;
			
		}
		
	}
	
	public static void main(String[] args) throws UsuarioJaCadastradoException, IOException, ClassNotFoundException {
	
		Fachada fachada=Fachada.criaObjeto();
		
		
		launch(args);
	}
}