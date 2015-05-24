package trab3;

public class Text extends Book{
	
	Text(String[] name){
		super(name[2]);
		this.ID = Integer.parseInt(name[1]);
	}
}
