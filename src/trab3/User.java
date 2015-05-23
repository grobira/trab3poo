package trab3;

import java.util.ArrayList;


public class User {
	
	String name;
	ArrayList<Rent> rents;
	int rentMaxDays;
	int maxRents;
	
	User(String name){
		this.name = name;
		this.rents = new ArrayList<Rent>();
	}
}
