package phoneBookJDBC;

public class User {
	public User(int u_id, String u_name, String u_surname, int tellnumber) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_surname = u_surname;
		this.tellnumber = tellnumber;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_surname() {
		return u_surname;
	}

	public void setU_surname(String u_surname) {
		this.u_surname = u_surname;
	}

	public int getTellnumber() {
		return tellnumber;
	}

	public void setTellnumber(int tellnumber) {
		this.tellnumber = tellnumber;
	}

	private int u_id;
	private String u_name;
	private String u_surname;
	private int tellnumber;

}
