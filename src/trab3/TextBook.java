package trab3;

public class TextBook extends Book{
	
	TextBook(String[] name){
		super(name[2]);
		this.ID = Integer.parseInt(name[1]);
	}
}
