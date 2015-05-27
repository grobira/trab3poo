package trab3;

public class Book {

    String name;
    int type;
    boolean status;
    int ID;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public boolean getStatus() {
	return status;
    }

    public void setFree(boolean status) {
	this.status = status;
    }

    Book(String name) {
	this.name = name;
	this.status = true;
    }

    public String toString() {
	String register = type + "+" + ID + "," + name;
	return register;
    }
}
