import dao.PhonebookDao;
import phoneBookJDBC.PhoneBook;
import phoneBookJDBC.PhonebookUser;
import phoneBookJDBC.User;

public class Main {

	public static void main(String[] args) {
		User u=new User(4,"rana","behdadi",768);
		User u1=new User(6,"ahmad","rashedi",7432);
		PhoneBook p=new PhoneBook(16,"rrr");
		PhonebookUser pu=new PhonebookUser(4,16);
		PhonebookUser pu1=new PhonebookUser(6,13);	
		PhonebookDao pd=new PhonebookDao();
	//	pd.createPhoneBook(p);
//		pd.deletePhoneBook(p);
	//	pd.updatePhoneBook(p);
		
		
		
	}
	
	

}
