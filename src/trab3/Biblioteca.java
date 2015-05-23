package trab3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Biblioteca {
	ArrayList<User> users;
	ArrayList<Book> books;
	
	Biblioteca(){
		users = new ArrayList<User>();
		books = new ArrayList<Book>();
	}
	
	
	void updateSystem(String book, String user){
        try {
            BufferedReader in = new BufferedReader(new FileReader(book));
            String csv;
            while((csv = in.readLine()) != null) {
                books.add(new Book(csv));
            }
            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File " + book + " was not found!");
        }
        catch(IOException e) {
            System.out.println("Error reading the file!");
        }
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(user));
            String csv;
            while((csv = in.readLine()) != null) {
                users.add(new User(csv));
            }
            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File " + book + " was not found!");
        }
        catch(IOException e) {
            System.out.println("Error reading the file!");
        }
	}
}
