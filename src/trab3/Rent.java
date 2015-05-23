package trab3;
import java.util.Date;


public class Rent {

	Book borrowed;
	Date startBorrow;
	
	@SuppressWarnings("deprecation")
	Rent(int year, int mouth, int day){
		startBorrow = new Date(year, mouth, day);
		
	}
}
