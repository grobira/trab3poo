package trab3;

import java.util.ArrayList;


public class User {
	
	String name;
	ArrayList<Rent> rents;
	int rentMaxDays;
	int maxRents;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Rent> getRents() {
		return rents;
	}

	public void setRents(ArrayList<Rent> rents) {
		this.rents = rents;
	}

	public int getRentMaxDays() {
		return rentMaxDays;
	}

	public void setRentMaxDays(int rentMaxDays) {
		this.rentMaxDays = rentMaxDays;
	}

	public int getMaxRents() {
		return maxRents;
	}

	public void setMaxRents(int maxRents) {
		this.maxRents = maxRents;
	}

	public int getPenality() {
		return penality;
	}

	public void setPenality(int penality) {
		this.penality = penality;
	}

	int penality;
	
	User(String name){
		this.name = name;
		this.rents = new ArrayList<Rent>();
	}
}
