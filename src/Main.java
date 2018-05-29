import dao.PhonebookDao;
import dao.UserDao;
import phoneBookJDBC.PhoneBook;
import phoneBookJDBC.User;

public class Main {

	public static void main(String[] args) {
		User u=new User(4,"rasha","falahati",799);
		User u1=new User(6,"ahmad","rashedi",7432);
		PhoneBook p=new PhoneBook(16,"rrr");
			
		PhonebookDao pd=new PhonebookDao();
		UserDao ud=new UserDao();
	//	pd.createPhoneBook(p);
//		pd.deletePhoneBook(p);
	//	pd.updatePhoneBook(p);
		
	//	pd.getAllPhoneBook().stream().forEach(ph -> System.out.println(ph.getP_name()+" "+p.getP_id()));
//		PhoneBook ph=pd.getPhoneBookByName("A");
//		System.out.println(ph.getP_name()+" "+ph.getP_id());
//		
//		ud.createUser(u);
//		ud.deleteUser(u);
//		ud.updateUser(u);
//		ud.getAlluser().stream().forEach(s ->System.out.println(s.getU_id()+" "+s.getU_name()+" "+s.getU_surname()+" "+s.getTellnumber()));
//		User us=ud.getUserBySureName("ahadi");
//		System.out.println(us.getU_id()+" "+us.getU_name()+" "+us.getU_surname()+" "+us.getTellnumber());
//		ud.getUserByName("ali").stream().forEach(s ->System.out.println(s.getU_id()+" "+s.getU_name()+" "+s.getU_surname()+" "+s.getTellnumber()));
//pd.insertUserPhoneBook(4,13);
//		pd.getUsersListinPhineBook(13).stream().forEach(p4->System.out.println(p4.getU_id()+" "+p4.getU_name()+" "+p4.getU_surname()+" "+p4.getTellnumber()));
ud.getPhoneBookListForUser(4).stream().forEach(u3->System.out.println(u3.getP_id()+" "+u3.getP_name()));
	}
	
	
	

}
