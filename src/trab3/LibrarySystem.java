package trab3;

import java.util.Calendar;

public class LibrarySystem {

    public static void main(String args[]) {

	Biblioteca library = new Biblioteca();
	Visual vs = new Visual();
	Calendar sysCal = Calendar.getInstance();

	String bookFile = "src/books.csv";
	String userFile = "src/users.csv";
	String rentFile = "src/rents.csv";

	library.updateLib(bookFile, userFile, rentFile);

	int resp = 0;
	while (resp != 5) {
	    resp = vs.Menu();
	    if (resp == 1) {
		resp = vs.MenuCadastrar();
		if (resp == 1) {
		    resp = vs.MenuCadastrarUsuario();
		    if (resp == 1) {
			vs.MenuCadastrarComunidade(library);
		    } else if (resp == 2) {
			vs.MenuCadastrarAluno(library);
		    } else if (resp == 3) {
			vs.MenuCadastrarProfessor(library);
		    }
		} else if (resp == 2) {
		    resp = vs.MenuCadastrarLivro();
		    if (resp == 1) {
			vs.MenuCadastrarTexto(library);
		    } else if (resp == 2) {
			vs.MenuCadastrarLivroP(library);
		    }

		}
	    } else if (resp == 2) {
		resp = vs.MenuListar();
		if (resp == 1) {
		    vs.MenuListarUsuarios(library);
		} else if (resp == 2) {
		    vs.MenuListarLivros(library);
		}
	    } else if (resp == 3) {
		resp = vs.MenuData();
		if (resp == 1) {
		    sysCal = vs.MenuDataAtual();
		} else if (resp == 2) {
		    sysCal = vs.MenuDataMudar();
		}
	    } else if (resp == 4) {
		vs.MenuEmprestimo(library, sysCal);
	    }
	}
    }

}
