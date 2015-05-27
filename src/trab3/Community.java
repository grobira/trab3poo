package trab3;

public class Community extends User {

    Community(String[] name) {
	super(name[2]);
	rentMaxDays = 15;
	maxRents = 2;
	this.ID = Integer.parseInt(name[1]);
	this.rentsID[0] = Integer.parseInt(name[3]);
	this.rentsID[1] = Integer.parseInt(name[4]);
	this.type = 0;
    }

}
