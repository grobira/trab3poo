package trab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Biblioteca {

    List<User> users;
    List<Book> books;
    List<Rent> rents;

    Biblioteca() {
    }

    /*
     * Organização dos arquivos cvs
     * user : tipo , ID , name , rents[] 
     * book : tipo, ID, name
     * rent : ID, date( yyyy , mm , dd), bookID, userID, isFinish
     */
    void updateLib(String book, String user, String rent) {
	BookFactory fact = new BookFactory();
	try {
	    BufferedReader in = new BufferedReader(new FileReader(book));
	    String csv;
	    while ((csv = in.readLine()) != null) {
		books.add(fact.makeBook(csv));
	    }
	    in.close();
	} catch (FileNotFoundException e) {
	    System.out.println("File " + book + " was not found!");
	} catch (IOException e) {
	    System.out.println("Error reading the file!");
	}

	UserFactory factU = new UserFactory();
	try {
	    BufferedReader in = new BufferedReader(new FileReader(user));
	    String csv;
	    while ((csv = in.readLine()) != null) {
		users.add(factU.makeUser(csv));
	    }
	    in.close();
	} catch (FileNotFoundException e) {
	    System.out.println("File " + user + " was not found!");
	} catch (IOException e) {
	    System.out.println("Error reading the file!");
	}

	try {
	    BufferedReader in = new BufferedReader(new FileReader(rent));
	    String csv;
	    while ((csv = in.readLine()) != null) {
		rents.add(new Rent(csv));
	    }
	    in.close();
	} catch (FileNotFoundException e) {
	    System.out.println("File " + rent + " was not found!");
	} catch (IOException e) {
	    System.out.println("Error reading the file!");
	}
    }
}
