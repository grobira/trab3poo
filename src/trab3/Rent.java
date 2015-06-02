package trab3;

import java.util.Calendar;

public class Rent {

	int tenantID; // locatario
	int borrowedID; // livro emprestado
	Calendar startBorrow;
	Calendar endBorrow;
	int isFinish;
	int ID;

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

	public Calendar getStartBorrow() {
		return startBorrow;
	}

	public void setStartBorrow(Calendar startBorrow) {
		this.startBorrow = startBorrow;
	}

	public int getIsFinish() {
		return isFinish;
	}

	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}

	Rent(String csv) {
		String[] values = csv.split(",");
		this.ID = Integer.parseInt(values[0]);
		startBorrow = Calendar.getInstance();
		startBorrow.set(Integer.parseInt(values[1]),
				Integer.parseInt(values[2]), Integer.parseInt(values[3]));
		endBorrow = Calendar.getInstance();
		endBorrow.set(Integer.parseInt(values[4]), Integer.parseInt(values[5]),
				Integer.parseInt(values[6]));
		this.borrowedID = Integer.parseInt(values[7]);
		this.tenantID = Integer.parseInt(values[8]);
		this.isFinish = Integer.parseInt(values[9]); // 1= true, 0= false

	}

	public Rent(User us, Book bk, Calendar dt, int id) {
		this.borrowedID = bk.getID();
		this.tenantID = us.getID();
		this.startBorrow = dt;
		this.isFinish = 0;
		this.endBorrow = startBorrow;
		endBorrow.add(Calendar.DAY_OF_MONTH, us.getRentMaxDays());

	}

	public String toString() {
		return ID + "," + startBorrow.toString() + "," + endBorrow.toString()
				+ "," + borrowedID + "," + tenantID + "," + isFinish;
	}
}
