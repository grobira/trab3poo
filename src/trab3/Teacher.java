package trab3;

public class Teacher extends User {

    Teacher(String[] name) {
	super(name[2]);
	rentMaxDays = 60;
	maxRents = 6;
	this.ID = Integer.parseInt(name[1]);
	rentsID = new int[maxRents];
	this.rentsID[0] = Integer.parseInt(name[3]);
	this.rentsID[1] = Integer.parseInt(name[4]);
	this.rentsID[2] = Integer.parseInt(name[5]);
	this.rentsID[3] = Integer.parseInt(name[6]);
	this.rentsID[4] = Integer.parseInt(name[7]);
	this.rentsID[5] = Integer.parseInt(name[8]);
	this.type = 2;
    }

    Teacher(String name, int id) {
    	super(name);
    	rentMaxDays = 60;
    	maxRents = 6;
    	this.ID = id;
    	rentsID = new int[maxRents];
    	this.rentsID[0] = 0;
    	this.rentsID[1] = 0;
    	this.rentsID[2] = 0;
    	this.rentsID[3] = 0;
    	this.rentsID[4] = 0;
    	this.rentsID[5] = 0;
    	this.type = 2;
    }

}
