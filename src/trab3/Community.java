package trab3;

public class Community extends User {

    Community(String[] name) {
	super(name[2]);
	rentMaxDays = 15;
	maxRents = 2;
	this.ID = Integer.parseInt(name[1]);
	rentsID = new int[maxRents];
	this.rentsID[0] = Integer.parseInt(name[3]);
	this.rentsID[1] = Integer.parseInt(name[4]);
	this.type = 0;
    }

    Community(String name, int id) {
	super(name);
	rentMaxDays = 15;
	maxRents = 2;
	this.ID = id;
	rentsID = new int[maxRents];
	rentsID[0] = 0;
	rentsID[1] = 0;
	this.type = 0;
    }

}
