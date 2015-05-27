package trab3;

public class BookFactory {

    BookFactory() {
    }

    public Book makeBook(String bookstr) {
	String[] values = bookstr.split(",");
	char type = values[0].charAt(0);

	if (type == '0') {
	    return new GeneralBook(values);
	} else {
	    return new TextBook(values);
	}

    }
}
