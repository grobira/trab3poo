package trab3;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Visual {
	Scanner in;
	
	public Visual(){
		in = new Scanner(System.in);
	}
	
	public int Menu(){
    	System.out.println("\nBem vindo ao sistema de biblioteca");
    	System.out.println("\n[1] Cadastrar");
    	System.out.println("[2] Listar registros");
    	System.out.println("[3] Configurar data");
    	System.out.println("[4] Registrar emprestimo");
    	System.out.println("[5] Sair");
    	
    	int resp = in.nextInt();
    	
    	return resp;    	
    }
    
    public int MenuCadastrar(){
    	System.out.println("O que deseja cadastrar :");
    	System.out.println("[1] Usuário");
    	System.out.println("[2] Livro");
    	System.out.println("[3] Sair");

    	
    	int resp = in.nextInt();
    	return resp;    	
    }
    
    public int MenuCadastrarUsuario(){
    	System.out.println("Qual o tipo de usuário ?");
    	System.out.println("[1] Comunidade");
    	System.out.println("[2] Aluno");
    	System.out.println("[3] Professor");
    	System.out.println("[4] Sair");

    	
    	int resp = in.nextInt();
    	
    	return resp; 
    }
    
    public int MenuCadastrarLivro(){
    	System.out.println("Qual o tipo de livro ?");
    	System.out.println("[1] Texto");
    	System.out.println("[2] Livro padrão");
    	System.out.println("[3] Sair");
    	
    	int resp = in.nextInt();
    	
    	return resp; 
    }
    
    public void MenuCadastrarComunidade(Biblioteca library){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	Community nCmmt = new Community(name, library.getUsers().size() + 1);
    	if(library.validateUser(nCmmt)){
    		library.addUser(nCmmt);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(library, nCmmt);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    	
    }
    
    public void MenuCadastrarAluno(Biblioteca library){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	Student nStdnt = new Student(name, library.getUsers().size() + 1);
    	if(library.validateUser(nStdnt)){
    		library.addUser(nStdnt);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(library, nStdnt);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    }
    

    public void MenuCadastrarProfessor(Biblioteca library){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	Teacher nTchr = new Teacher(name, library.getUsers().size() + 1);
    	if(library.validateUser(nTchr)){
    		library.addUser(nTchr);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(library, nTchr);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    }
    
    public void MenuCadastrarTexto(Biblioteca library){
    	System.out.println("Entre com os dados do texto :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	TextBook nTxtbk = new TextBook(name, library.getBooks().size() + 1);
    	if(library.validateBook(nTxtbk)){
    		library.addBook(nTxtbk);
    		System.out.println("Texto cadastrado com sucesso!");
    		printBook(nTxtbk);
    	}else
    		System.out.println("Falha ao cadastrar texto, tente novamente!");    		
    	
    }
    
    public void MenuCadastrarLivroP(Biblioteca library){
    	System.out.println("Entre com os dados do livro :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	GeneralBook nGnrlbk = new GeneralBook(name, library.getBooks().size() + 1);
    	if(library.validateBook(nGnrlbk)){
    		library.addBook(nGnrlbk);
    		System.out.println("Livro cadastrado com sucesso!");
    		printBook(nGnrlbk);
    	}else
    		System.out.println("Falha ao cadastrar livro, tente novamente!");    		
    	
    }
    
    public int MenuListar(){
    	System.out.println("O que deseja listar ?");
    	System.out.println("[1] Usuários");
    	System.out.println("[2] Livro");
    	
    	int resp = in.nextInt();
    	
    	return resp;    	
    }
    
    public void MenuListarUsuarios(Biblioteca library){
    	library.getUsers().stream().forEach(s -> s.print(library));
    }
    
    public void MenuListarLivros(Biblioteca library){
    	library.getBooks().stream().forEach(s -> s.print());
    }
        
    public int MenuData() {
	System.out.println("Configuração de data:");
	System.out.println("[1] Deixar data atual");
	System.out.println("[2] Modificar data");
	System.out.println("[3] Sair");

	int resp;
	
	resp = in.nextInt();
	return resp;
    }

    public Calendar MenuDataAtual(){
    	Calendar c = Calendar.getInstance();
		System.out.println("Data e Hora atual: " + c.getTime());
		return c;
    }

    public Calendar MenuDataMudar(){
        Calendar c = Calendar.getInstance();

	System.out.println("Entre com o dia (dd):");

	c.set(Calendar.DAY_OF_MONTH, in.nextInt());

	System.out.println("Entre com o mês (mm):");

	c.set(Calendar.MONTH, (in.nextInt()-1));

	System.out.println("Entre com o ano (yyyy):");

	c.set(Calendar.YEAR, in.nextInt());
	
	System.out.println("Data e Hora atual: " + c.getTime());
    return c;
    }
    
    
    public void MenuEmprestimo(Biblioteca library, Calendar c){
    	System.out.println("Entre com o nome do usuario :");
    	String uName = in.nextLine();
    	
    	List<User> userSearch = library.getUsers().stream().filter(s -> s.getName().equals(uName)).collect(Collectors.toList());
    	System.out.println("Entre com o indice do usuario correspondente ao ID :");
    	for ( int i = 0 ; i < userSearch.size() ; i++ ){
    		System.out.println("[" + i + "] Nome : " + userSearch.get(i).getName() + " ID : " + userSearch.get(i).getID());
    	}
    	int uPos = in.nextInt();
    	
    	System.out.println("Entre com o nome do livro :");
    	String bName = in.nextLine();
    	
    	List<Book> bookSearch = library.getBooks().stream().filter(s -> s.getName().equals(bName)).collect(Collectors.toList());
    	System.out.println("Entre com o indice do livro correspondente ao ID :");
    	for ( int i = 0 ; i < bookSearch.size() ; i++ ){
    		System.out.println("[" + i + "] Nome : " + bookSearch.get(i).getName() + " ID : " + bookSearch.get(i).getID());
    	}
    	int bPos = in.nextInt();
    	
    	Rent nRnt = new Rent(userSearch.get(uPos), bookSearch.get(bPos), c , library.getRents().size()+1);
    	
    	userSearch.get(uPos).addRent(nRnt.getID());
    	bookSearch.get(bPos).setFree(false);   	    	
    	
    	library.addRent(nRnt);   	
    }
    
    public void printUser(Biblioteca library, User us){
    	System.out.println("Nome : " + us.getName());
    	System.out.println("ID do cadastro : " + us.getID());
    	System.out.println("Penalidade : " + us.getPenality());
    	System.out.println("Maximo de emprestimos : "+ us.getMaxRents() + " durante no máximo : " + us.getRentMaxDays());
    	int aux[] = us.getRentsID();
    	for ( int i = 0 ; i < us.getMaxRents() ; i++){
    		if ( aux[i] != 0){
    			System.out.println("Livro emprestado : " + library.findBookName(aux[i]));
    		}		
    	}
    }
    
    public void printBook(Book bk){
    	System.out.println("Nome : " + bk.getName());
    	System.out.println("ID de cadastro do livro : " + bk.getID());
    	System.out.println("Disponivel : " + bk.getStatus());
    }
}
