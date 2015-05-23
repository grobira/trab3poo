package trab3;

public class Student extends User{
	
	Student(String[] name){
		super(name[1]);
		rentMaxDays = 15;
		maxRents = 4;
	}
}
