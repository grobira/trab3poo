package trab3;

public class Book {

    String name;
    boolean isFree;
    int ID;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public boolean isFree() {
	return isFree;
    }

    public void setFree(boolean isFree) {
	this.isFree = isFree;
    }

    Book(String name) {
	this.name = name;
	this.isFree = true;
    }
}
