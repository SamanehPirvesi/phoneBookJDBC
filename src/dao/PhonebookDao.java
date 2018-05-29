package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phoneBookJDBC.PhoneBook;
import phoneBookJDBC.User;

public class PhonebookDao {
	public void createPhoneBook(PhoneBook p) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO phonebook(P_ID,P_NAME)VALUES(?,?)");
			stmt.setInt(1, p.getP_id());
			stmt.setString(2, p.getP_name());
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);

	}

	public void deletePhoneBook(PhoneBook p) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM phonebook WHERE P_NAME=?");
			stmt.setString(1, p.getP_name());
			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		utility.JdbcConnection.closeConnection(conn);

	}

	public void updatePhoneBook(PhoneBook p) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE phonebook SET P_NAME=? WHERE P_ID=?");
			stmt.setString(1, p.getP_name());
			stmt.setInt(2, p.getP_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);

	}

	public List<PhoneBook> getAllPhoneBook() {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM phonebook ");
			ResultSet result = stmt.executeQuery();
			List<PhoneBook> listOfPhoneBook = new ArrayList<>();
			while (result.next()) {
				int p_id = result.getInt(1);
				String p_name = result.getString(2);
				PhoneBook p = new PhoneBook(p_id, p_name);
				listOfPhoneBook.add(p);
			}
			return listOfPhoneBook;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);

		return null;

	}

	public PhoneBook getPhoneBookByName(String name) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM phonebook WHERE P_NAME=? ");
			stmt.setString(1, name);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				int p_id = result.getInt(1);
				String p_name = result.getString(2);
				PhoneBook p = new PhoneBook(p_id, p_name);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
		return null;
	}
	public void insertUserPhoneBook(int u_id , int p_id) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO user_phonebook(p_id,u_id)VALUES(?,?)");
			stmt.setInt(1, p_id);
			stmt.setInt(2, u_id);
			stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
	}
	public List<User> getUsersListinPhineBook(int p_id){
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM user u,user_phonebook up WHERE up.p_id=? and up.u_id=u.ID");
			stmt.setInt(1, p_id);
			ResultSet result = stmt.executeQuery();
			List<User> listOfuserInPhoneBook = new ArrayList<>();
			while (result.next()) {
				int u_id = result.getInt(1);
				String u_name = result.getString(2);
				String u_surname=result.getString(3);
				int u_tellnumber=result.getInt(4);
				User u = new User(u_id,u_name,u_surname,u_tellnumber);
				listOfuserInPhoneBook.add(u);
			}
			return listOfuserInPhoneBook;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
		return null;
	}
	
}
