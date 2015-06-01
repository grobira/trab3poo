package trab3;

public class Student extends User {

    Student(String[] name) {
	super(name[2]);
	rentMaxDays = 15;
	maxRents = 4;
	this.ID = Integer.parseInt(name[1]);
	this.rentsID[0] = Integer.parseInt(name[3]);
	this.rentsID[1] = Integer.parseInt(name[4]);
	this.rentsID[2] = Integer.parseInt(name[5]);
	this.rentsID[3] = Integer.parseInt(name[6]);
	this.type = 1;
    }
    
    
    Student(String name, int id) {
    	super(name);
		rentMaxDays = 15;
		maxRents = 4;
		this.ID = id;
		this.rentsID[0] = 0;
		this.rentsID[1] = 0;
		this.rentsID[2] = 0;
		this.rentsID[3] = 0;
		this.type = 1;
    }
}
