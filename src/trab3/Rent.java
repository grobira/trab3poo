package trab3;

import java.util.Date;

public class Rent {



	public int getTenantID() {
		return tenantID;
	}

	public void setTenantID(int tenantID) {
		this.tenantID = tenantID;
	}

	public int getBorrowedID() {
		return borrowedID;
	}

	public void setBorrowedID(int borrowedID) {
		this.borrowedID = borrowedID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	int tenantID;
	int borrowedID;
	Date startBorrow;
	int isFinish;
	int ID;
	
	@SuppressWarnings("deprecation")
	Rent(String csv){
		String[] values = csv.split(",");
		this.ID = Integer.parseInt(values[0]);
		startBorrow = new Date(Integer.parseInt(values[1])
				, Integer.parseInt(values[2])
				, Integer.parseInt(values[3]));
		this.borrowedID = Integer.parseInt(values[4]);
		this.tenantID = Integer.parseInt(values[5]);
		this.isFinish = Integer.parseInt(values[6]);  //1= true, 0= false
		
	}
}
