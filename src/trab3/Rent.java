package trab3;

import java.util.Date;

public class Rent {

	public User getTenant() {
		return tenant;
	}

	public void setTenant(User tenant) {
		this.tenant = tenant;
	}

	public Book getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Book borrowed) {
		this.borrowed = borrowed;
	}

	public Date getStartBorrow() {
		return startBorrow;
	}

	public void setStartBorrow(Date startBorrow) {
		this.startBorrow = startBorrow;
	}

	public int getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}

	User tenant;
	Book borrowed;
	Date startBorrow;
	int isFinish;
	
	@SuppressWarnings("deprecation")
	Rent(String csv){
		String[] values = csv.split(",");
		startBorrow = new Date(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Integer.parseInt(values[2]));
		this.borrowed = new Book(values[3]);
		this.tenant = new User(values[4]);
		this.isFinish = Integer.parseInt(values[5]);  //1= true, 0= false
	}
}
