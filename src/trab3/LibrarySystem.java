package trab3;

public class LibrarySystem {

	public static void main(String args[]){
		Biblioteca library = new Biblioteca();
		String bookFile = "books.cvs";
		String userFile = "users.cvs";
		String rentFile = "rents.cvs";
		
		library.updateLib(bookFile, userFile, rentFile);
	}

}
