package trab3;

public class UserFactory {

	UserFactory() {
	}

	public User makeUser(String userstr) {
		String[] values = userstr.split(",");
		char type = values[0].charAt(0);
		if (type == '0') {
			return new Community(values);
		}
		if (type == '1') {
			return new Student(values);
		} else {
			return new Teacher(values);
		}

	}
}
