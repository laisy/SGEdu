package sgedu.fachada;

import java.io.IOException;
import java.util.ArrayList;

import sgedu.dados.turma.IRepositorioDisciplina;
import sgedu.dados.turma.IRepositorioTurma;
import sgedu.dados.turma.RepositorioDisciplina;
import sgedu.dados.turma.RepositorioTurma;
import sgedu.dados.usuarios.IRepositorioAluno;
import sgedu.dados.usuarios.IRepositorioCoordenador;
import sgedu.dados.usuarios.IRepositorioProfessor;
import sgedu.dados.usuarios.IRepositorioResponsavel;
import sgedu.dados.usuarios.RepositorioAluno;
import sgedu.dados.usuarios.RepositorioCoordenador;
import sgedu.dados.usuarios.RepositorioProfessor;
import sgedu.dados.usuarios.RepositorioResponsavel;
import sgedu.negocios.NegocioAluno;
import sgedu.negocios.NegocioCoordenador;
import sgedu.negocios.NegocioDisciplina;
import sgedu.negocios.NegocioProfessor;
import sgedu.negocios.NegocioResponsavel;
import sgedu.negocios.NegocioTurma;
import sgedu.negocios.entidade.turma.Disciplina;
import sgedu.negocios.entidade.turma.Turma;
import sgedu.negocios.entidade.usuarios.Aluno;
import sgedu.negocios.entidade.usuarios.Coordenador;
import sgedu.negocios.entidade.usuarios.Professor;
import sgedu.negocios.entidade.usuarios.Responsavel;
import sgedu.negocios.entidade.usuarios.Usuario;
import sgedu.negocios.excecoes.UsuarioJaCadastradoException;


public class Fachada {
	private static Fachada objeto;
	
	private NegocioAluno negocioAluno;
	private NegocioResponsavel negocioResponsavel;
	private NegocioCoordenador negocioCoordenador;
	private NegocioProfessor negocioProfessor;
	
	private NegocioDisciplina negocioDisciplina;
	private NegocioTurma negocioTurma;
	private Usuario usuarioLogado;
	

	private Fachada() {
		usuarioLogado=null;
		
		IRepositorioAluno repositorioAluno=new RepositorioAluno();
		this.negocioAluno=new NegocioAluno(repositorioAluno);
		
		IRepositorioResponsavel repositorioResponsavel=new RepositorioResponsavel();
		this.negocioResponsavel = new NegocioResponsavel(repositorioResponsavel);
		
		IRepositorioCoordenador repositorioCoordenador=new RepositorioCoordenador();
		this.negocioCoordenador=new NegocioCoordenador(repositorioCoordenador);
		
		IRepositorioProfessor repositorioProfessor=new RepositorioProfessor();
		this.negocioProfessor=new NegocioProfessor(repositorioProfessor);
		
		IRepositorioDisciplina repositorioDisciplina=new RepositorioDisciplina();
		this.negocioDisciplina=new NegocioDisciplina(repositorioDisciplina);
		
		IRepositorioTurma repositorioTurma=new RepositorioTurma();
		this.negocioTurma=new NegocioTurma(repositorioTurma);
	
		
		
		try {
			repositorioAluno.buscarArquivoAluno();
			repositorioResponsavel.buscarArquivoResponsavel();
			repositorioCoordenador.buscarArquivoCoordenador();
			repositorioProfessor.buscarArquivoProfessor();
			
			repositorioDisciplina.buscarArquivoDisciplina();
			repositorioTurma.buscarArquivoTurma();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
	
	

	public static Fachada criaObjeto(){
		if(objeto==null) {
			objeto=new Fachada();
		}
		return objeto;
	}
	
	
	public void setUsuarioLogado(Usuario user) {
		usuarioLogado=user;
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	///////////////////Aluno
	public void adicionarAluno(Aluno aluno) throws UsuarioJaCadastradoException, IOException, ClassNotFoundException {
		negocioAluno.adicionar(aluno);
	}
	
	
	public boolean confirmaLoginAluno(String login, String senha) {
		return negocioAluno.confirmaLogin(login, senha);
	}
	
	public Aluno buscarLoginAluno(String login) {
		return negocioAluno.buscarLogin(login);
	}
	
	public ArrayList<Aluno> getAlunos(){
		return negocioAluno.getAlunos();
	}
	
	public void alterarNomeAluno(Aluno aluno){
		negocioAluno.AlterarNome(aluno);
	}
	
	public void alterarSenhaAluno(Aluno aluno) {
		negocioAluno.alterarSenha(aluno);
	}
	
	public void removerAluno(String login) {
		negocioAluno.remover(login);
	}
	
	
	
	///////////////Responsavel
	
	public void adicionarReponsavel(Responsavel responsavel) throws IOException, UsuarioJaCadastradoException {
		negocioResponsavel.adicionar(responsavel);
	}
	
	public boolean confirmaLoginResponsavel(String login,String senha) {
		return negocioResponsavel.confirmaLogin(login, senha);
	}
	
	public void addAlunoEmResponsavel(Responsavel responsavel, Aluno aluno) {
		negocioResponsavel.addAluno(responsavel, aluno);
	}
	
	public Responsavel buscarLoginResponsavel(String login) {
		return negocioResponsavel.buscaLogin(login);
	}
	
	
	
	
	////////////////Coordenador
	
	public void adicionarCoordenador(Coordenador coordenador) throws UsuarioJaCadastradoException, IOException{
			negocioCoordenador.adicionar(coordenador);
	}
	
	public boolean confirmaLoginCoordenador(String login, String senha) {
		return negocioCoordenador.confirmaLogin(login, senha);
	}
	
	public Usuario buscarLoginCoordenador(String login) {
		return negocioCoordenador.buscarLogin(login);
	}
	
	public Aluno cadastrarAluno(String login,String nome, String senha) throws ClassNotFoundException, UsuarioJaCadastradoException, IOException {
		Aluno aluno= negocioCoordenador.cadatrarAluno(login,nome, senha);
		this.adicionarAluno(aluno);
		return aluno;
	}
	
	/////////professor
	
	public void adicionarProfessor(String login, String nome, String senha, String disciplina) throws UsuarioJaCadastradoException, IOException {
		Disciplina disciplinaBusca=this.buscarDisciplina(disciplina);
		negocioProfessor.adicionar(login,nome,senha,disciplinaBusca);
	}
	
	public boolean confirmaLoginProfessor(String login, String senha) {
		return negocioProfessor.confirmaLogin(login, senha);
	}
	
	public Professor buscarLoginProfessor(String login) {
		return negocioProfessor.buscarLogin(login);
	}
	
	public ArrayList<Professor> getProfessores(){
		return negocioProfessor.getProfessores();
	}
	
	public void alteraNomeProfessor(Professor professor) {
		negocioProfessor.alteraNome(professor);
	}
	public void alterarSenhaProfessor(Professor professor) {
		negocioProfessor.alteraSenha(professor);
	}
	
	
	
	//////////disciplina
	public void adicionarDisciplina(String nome, int aulas) {
		negocioDisciplina.adicionar(nome, aulas);
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return negocioDisciplina.getDisciplinas();
	}
	
	public void removeDisciplina(String nome) {
		negocioDisciplina.remover(nome);
	}
	
	public void addProfessorTurma(String disciplina, String professorLogin) {
		Professor professorBusca=this.buscarLoginProfessor(professorLogin);
		negocioDisciplina.addProfessorTurma(disciplina, professorBusca);
		
	}
	
	public Disciplina buscarDisciplina(String nome) {
		return negocioDisciplina.buscar(nome);
	}
	
	
	/////////////Turma
	public void adicionarTurma(String nome,int ano) {
		negocioTurma.adicionar(nome, ano);
	}
	
	public ArrayList<Turma> getTurmas(){
		return negocioTurma.getTurma();
	}

	
	
	
}