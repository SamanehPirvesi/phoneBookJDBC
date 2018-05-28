package phoneBookJDBC;

public class PhonebookUser {
	public PhonebookUser(int p_id, int u_id) {

		this.p_id = p_id;
		this.u_id = u_id;
	}

	private int p_id;
	private int u_id;

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

}
