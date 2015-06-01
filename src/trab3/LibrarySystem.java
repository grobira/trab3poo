package trab3;

import java.util.Calendar;
import java.util.Scanner;


public class LibrarySystem{
	static Biblioteca library;
    public static void main(String args[]) {

 
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
					resp = MenuCadastrarAluno();
				}
				else if ( resp == 3){
					resp = MenuCadastrarProfessor();
				}
			}
			else if ( resp == 2){
				resp = MenuCadastrarLivro();
			}
		}
		else if ( resp == 2){
			
		}
		else if ( resp == 3){
			
		}
	}


	
	Calendar day = Calendar.getInstance();
	//day.set(Integer.parseInt(dates[0]), Integer.parseInt(dates[1]), Integer.parseInt(dates[2]));
	
    }
    
    static int Menu(){
    	System.out.println("Bem vindo ao sistema de biblioteca");
    	System.out.println("\n[1] Cadastrar");
    	System.out.println("[2] Listar registros");
    	System.out.println("[3] Simular outra data");
    	System.out.println("[4] Sair");
    	Scanner in = new Scanner(System.in);
    	int resp = in.nextInt();
    	in.close();
    	return resp;    	
    }
    
    static int MenuCadastrar(){
    	System.out.println("O que deseja cadastrar :");
    	System.out.println("[1] Usuário");
    	System.out.println("[2] Livro");
    	System.out.println("[3] Voltar");

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

    	Scanner in = new Scanner(System.in);
    	int resp = in.nextInt();
    	in.close();
    	return resp; 
    }
    
    static int MenuCadastrarLivro(){
    	System.out.println("Qual o tipo de livro ?");
    	System.out.println("[1] Texto");
    	System.out.println("[2] Livro padrão");
    	System.out.println("[3] Sair");

    	Scanner in = new Scanner(System.in);
    	int resp = in.nextInt();
    	in.close();
    	return resp; 
    }
    
    static void MenuCadastrarComunidade(){
    	System.out.println("Entre com os dados do usuário :");
    	System.out.println("Nome :");

    	Scanner in = new Scanner(System.in);
    	String name = in.nextLine();
    	in.close();
    	
    	
    	Community nCmmt = new Community(name, library.getUsers().size() + 1);
    	if(library.validateUser(nCmmt)){
    		library.addUser(nCmmt);
    		System.out.println("Usuario cadastrado com sucesso!");
    		printUser(nCmmt);
    	}else
    		System.out.println("Falha ao cadastrar usuario, tente novamente!");    		
    	
    }
    
    static int MenuCadastrarAluno(){
    	System.out.println("Qual o tipo de livro ?");
    	System.out.println("[1] Texto");
    	System.out.println("[2] Livro padrão");
    	System.out.println("[3] Sair");

    	Scanner in = new Scanner(System.in);
    	int resp = in.nextInt();
    	in.close();
    	return resp; 
    }
    
    static int MenuCadastrarProfessor(){
    	System.out.println("Qual o tipo de livro ?");
    	System.out.println("[1] Texto");
    	System.out.println("[2] Livro padrão");
    	System.out.println("[3] Sair");

    	Scanner in = new Scanner(System.in);
    	int resp = in.nextInt();
    	in.close();
    	return resp; 
    }
    
    static void printUser(User us){
    	System.out.println("Nome : " + us.getName());
    	System.out.println("ID do cadastro : " + us.getID());
    	System.out.println("Penalidade : " + us.getPenality());
    	System.out.println("Maximo de emprestimos : "+ us.getMaxRents() + " durante no máximo : " + us.getRentMaxDays());
    	int aux[] = us.getRentsID();
    	for ( int i = 0 ; i < us.getMaxRents() ; i++){
    		if ( aux[i] != 0){
    			System.out.println("Livro emprestado : " + library.findBookRent(aux[i]));
    		}
    			
    	}
    	
    }

}
