package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phoneBookJDBC.PhoneBook;

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
			stmt.setString(1,p.getP_name());
			stmt.setInt(2,p.getP_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<PhoneBook> getAllPhoneBook(){
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE phonebook SET P_NAME=? WHERE P_ID=?");
			ResultSet result = stmt.executeQuery();
			List<PhoneBook> listOfPhoneBook=new ArrayList<>();
			while (result.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
}
