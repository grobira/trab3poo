package trab3;

public class Community extends User{
	
	Community(String[] name){
		super(name[1]);
		rentMaxDays = 15;
		maxRents = 2;
	}

}
