package trab3;

public class GeneralBook extends Book {

    GeneralBook(String[] name) {
	super(name[2]);
	this.ID = Integer.parseInt(name[1]);
	this.type = 0;

    }

    GeneralBook(String name, int id) {
	super(name);
	this.ID = id;
	this.type = 0;

    }
}
