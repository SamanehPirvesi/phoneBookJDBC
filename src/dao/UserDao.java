package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import phoneBookJDBC.User;

public class UserDao {
	public void createUser(User u) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("INSERT INTO user(ID,name,surname,tellnumber)VALUES(?,?,?,?)");
			stmt.setInt(1, u.getU_id());
			stmt.setString(2, u.getU_name());
			stmt.setString(3, u.getU_surname());
			stmt.setInt(4, u.getTellnumber());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
	}

	public void deleteUser(User u) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("DELETE FROM user WHERE name=?");
			stmt.setString(1, u.getU_name());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
	}

	public void updateUser(User u) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("UPDATE user SET name=?,surname=?,tellnumber=? WHERE ID=?");
			stmt.setString(1, u.getU_name());
			stmt.setString(2, u.getU_surname());
			stmt.setInt(3, u.getTellnumber());
			stmt.setInt(4, u.getU_id());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
	}

	public List<User> getAlluser() {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM user");
			ResultSet result = stmt.executeQuery();
			List<User> listOfUser = new ArrayList<>();
			while (result.next()) {
				int u_id = result.getInt(1);
				String name = result.getString(2);
				String surName = result.getString(3);
				int tellNumber = result.getInt(4);
				User u = new User(u_id, name, surName, tellNumber);
				listOfUser.add(u);
			}
			return listOfUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
		return null;
	}
	public User getUserBySureName(String surname) {
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM user where surname=?");
			stmt.setString(1,surname);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
			int u_id = result.getInt(1);
			String name = result.getString(2);
			String surName = result.getString(3);
			int tellNumber = result.getInt(4);
			User u = new User(u_id, name, surName, tellNumber);
			return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
		return null;
	}
	public List<User> getUserByName(String name){
		Connection conn = utility.JdbcConnection.getConnection();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement("SELECT * FROM user where name=?");
			stmt.setString(1,name);
			List<User> listOfUser=new ArrayList<>();
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
			int u_id = result.getInt(1);
			String u_name = result.getString(2);
			String surName = result.getString(3);
			int tellNumber = result.getInt(4);
			User u = new User(u_id, u_name, surName, tellNumber);
			listOfUser.add(u);
			
			}
			return listOfUser;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utility.JdbcConnection.closeConnection(conn);
		
		
		return null;
	}

}
