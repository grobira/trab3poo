package trab3;

public class Teacher extends User{
	
	Teacher(String[] name){
		super(name[1]);
		rentMaxDays = 60;
		maxRents = 6;
	}

}
