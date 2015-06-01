package trab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

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
     * rent : ID, date de locação( yyyy , mm , dd), data de devolução, bookID, userID, isFinish
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
	    try {
		FileWriter arq = new FileWriter(book);
		System.out.println("File " + book + " was created!");
		arq.close();
	    } catch (IOException l) {
		System.out.println("Error reading/creating the file!");
	    }
	}catch (IOException e) {
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
	}  catch (FileNotFoundException e) {
	    System.out.println("File " + user + " was not found!");
	    try {
		FileWriter arq = new FileWriter(user);
		System.out.println("File " + user + " was created!");
		arq.close();
	    } catch (IOException l) {
		System.out.println("Error reading/creating the file!");
	    }
	}catch (IOException e) {
	    System.out.println("Error reading the file!");
	}

	try {
	    BufferedReader in = new BufferedReader(new FileReader(rent));
	    String csv;
	    while ((csv = in.readLine()) != null) {
		rents.add(new Rent(csv));
	    }
	    in.close();
	}  catch (FileNotFoundException e) {
	    System.out.println("File " + rent + " was not found!");
	    try {
		FileWriter arq = new FileWriter(rent);
		System.out.println("File " + rent + " was created!");
		arq.close();
		
	    } catch (IOException l) {
		System.out.println("Error reading/creating the file!");
	    }
	}catch (IOException e) {
	    System.out.println("Error reading the file!");
	}
    }

    public void addUser(User nUser) {
	users.add(nUser);
	addInUserFile(nUser);
    }

    public void addInUserFile(User nUser) {
	try {
	    PrintWriter pw = new PrintWriter(new FileOutputStream("src/users.csv"));
	    pw.println(nUser.toString());
	    pw.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    public void addBook(Book nBook) {
	books.add(nBook);
	addInBookFile(nBook);
    }

    public void addInBookFile(Book nBook) {
	try {
	    PrintWriter pw = new PrintWriter(new FileOutputStream("src/books.csv"));
	    pw.println(nBook.toString());
	    pw.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
    
    public void addRent(User us, Book bk, Calendar dt){
    	Rent nRent = new Rent(us, bk, dt, rents.size()+1);
    	rents.add(nRent);
    	addInRentFile(nRent);
    }
    
    public void addRent(Rent nRent){
    	rents.add(nRent);
    	addInRentFile(nRent);
    }
    
    public void addInRentFile(Rent nRent){
    	try {
    	    PrintWriter pw = new PrintWriter(new FileOutputStream("src/rents.csv"));
    	    pw.println(nRent.toString());
    	    pw.close();
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	}
    }
    
    public List<User> getUsers(){
    	return users;
    }
    
    public List<Book> getBooks(){
    	return books;
    }
    
    public List<Rent> getRents(){
    	return rents;
    }
    
    public boolean validateUser(User us){
    	if(users.stream().anyMatch(s -> s.getID() == us.getID()))
    		return false;    	
    	return true;
    }
    
    public boolean validateBook(Book bk){
    	if(books.stream().anyMatch(s -> s.getID() == bk.getID()))
    		return false;    	
    	return true;
    }
    

    public String findBookRent(int rentID){
    	List<Rent> rentSearch = rents.stream().filter(s -> s.getID() == rentID).collect(Collectors.toList());
    	int bookID = rentSearch.get(0).getBorrowedID();
    	return findBookName(bookID);
    }
    
    public String findBookName(int bookID){
    	List<Book> bookSearch = books.stream().filter(s -> s.getID() == bookID).collect(Collectors.toList());
    	return bookSearch.get(0).getName();

    }
}
