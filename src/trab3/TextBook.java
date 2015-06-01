package trab3;

public class TextBook extends Book {

    TextBook(String[] name) {
	super(name[2]);
	this.ID = Integer.parseInt(name[1]);
	this.type = 1;
    }
    
    TextBook(String name, int id) {
	super(name);
	this.ID = id;
	this.type = 1;
    }
}
