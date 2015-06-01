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

    public int getID() {
	return ID;
    }

    public void print() {
	System.out.println("ID de cadastro do livro : " + getID());
	System.out.println("Nome : " + getName());
	System.out.println("Disponivel : " + getStatus());
	System.out.println();
    }
}
