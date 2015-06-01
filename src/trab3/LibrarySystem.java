package trab3;

import java.util.Calendar;
import java.util.Scanner;


public class LibrarySystem{
	static Biblioteca library;
	static Scanner in;
    public static void main(String args[]) {
    in = new Scanner(System.in);
 
	library = new Biblioteca();
	String bookFile = "src/books.csv";
	String userFile = "src/users.csv";
	String rentFile = "src/rents.csv";

	library.updateLib(bookFile, userFile, rentFile);
	
	int resp = 0;
	while(resp != 4){
		resp = Menu();
		if (resp == 1){
			resp = MenuCadastrar();
			if ( resp == 1){
				resp = MenuCadastrarUsuario();
				if ( resp == 1){
					MenuCadastrarComunidade();
				}
				else if ( resp == 2){
					MenuCadastrarAluno();
				}
				else if ( resp == 3){
					MenuCadastrarProfessor();
				}
			}
			else if ( resp == 2){
				resp = MenuCadastrarLivro();
				if ( resp == 1){
					MenuCadastrarTexto();
				}else if ( resp == 2){
					MenuCadastrarLivroP();
				}
				
			}
		}
		else if ( resp == 2){
			
		}
		else if ( resp == 3){
		    resp = MenuData();
		    if (resp == 1) {
			MenuDataAtual();
		    } else if (resp == 2) {
			MenuDataMudar();
		    }
		}
	}
    }
    
    static int Menu(){
    	System.out.println("\nBem vindo ao sistema de biblioteca");
    	System.out.println("\n[1] Cadastrar");
    	System.out.println("[2] Listar registros");
    	System.out.println("[3] Configurar data");
    	System.out.println("[4] Sair");
    	
    	int resp = in.nextInt();
    	
    	return resp;    	
    }
    
    static int MenuCadastrar(){
    	System.out.println("O que deseja cadastrar :");
    	System.out.println("[1] Usuário");
    	System.out.println("[2] Livro");
    	System.out.println("[3] Sair");

    	Scanner in = new Scanner(System.in);
    	int resp = in.nextInt();
    	in.close();
    	return resp;    	
    }
    
    static int MenuCadastrarUsuario(){
    	System.out.println("Qual o tipo de usuário ?");
    	System.out.println("[1] Comunidade");
    	System.out.println("[2] Aluno");
    	System.out.println("[3] Professor");
    	System.out.println("[4] Sair");

    	
    	int resp = in.nextInt();
    	
    	return resp; 
    }
    
    static int MenuCadastrarLivro(){
    	System.out.println("Qual o tipo de livro ?");
    	System.out.println("[1] Texto");
    	System.out.println("[2] Livro padrão");
    	System.out.println("[3] Sair");
    	
    	int resp = in.nextInt();
    	
    	return resp; 
    }
    
    static void MenuCadastrarComunidade(){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	Community nCmmt = new Community(name, library.getUsers().size() + 1);
    	if(library.validateUser(nCmmt)){
    		library.addUser(nCmmt);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(nCmmt);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    	
    }
    
    static void MenuCadastrarAluno(){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	Student nStdnt = new Student(name, library.getUsers().size() + 1);
    	if(library.validateUser(nStdnt)){
    		library.addUser(nStdnt);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(nStdnt);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    }
    

    static void MenuCadastrarProfessor(){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	String name = in.nextLine();
    	
    	Teacher nTchr = new Teacher(name, library.getUsers().size() + 1);
    	if(library.validateUser(nTchr)){
    		library.addUser(nTchr);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(nTchr);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    }
    
    static void MenuCadastrarTexto(){
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
    
    static void MenuCadastrarLivroP(){
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

    
    static void printUser(User us){
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
    
    static void printBook(Book bk){
    	System.out.println("Nome : " + bk.getName());
    	System.out.println("ID de cadastro do livro : " + bk.getID());
    	System.out.println("Disponivel : " + bk.getStatus());
    }
    
    static int MenuData() {
	System.out.println("Configuração de data:");
	System.out.println("[1] Deixar data atual");
	System.out.println("[2] Modificar data");
	System.out.println("[3] Sair");

	int resp;
	
	    resp = in.nextInt();


	return resp;
    }

    static void MenuDataAtual(){
	Calendar c = Calendar.getInstance();
	System.out.println("Data e Hora atual: " + c.getTime());
    }

    static void MenuDataMudar(){
        Calendar c = Calendar.getInstance();

	System.out.println("Entre com o dia (dd):");

	c.set(Calendar.DAY_OF_MONTH, in.nextInt());

	System.out.println("Entre com o mês (mm):");

	c.set(Calendar.MONTH, (in.nextInt()-1));

	System.out.println("Entre com o ano (yyyy):");

	c.set(Calendar.YEAR, in.nextInt());
	
	System.out.println("Data e Hora atual: " + c.getTime());
    }
}
