package trab3;

public class User {
	
	String name;
	int[] rentsID;
	int rentMaxDays;
	int maxRents;
	int ID;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getRentsID() {
		return rentsID;
	}

	public void setRents(int[] rents) {
		this.rentsID = rents;
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
	}
}