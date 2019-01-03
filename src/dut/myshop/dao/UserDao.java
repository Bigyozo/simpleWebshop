package dut.myshop.dao;

import java.sql.SQLException;

import dut.myshop.domain.User;

public interface UserDao {

	void addUser(User user) throws SQLException;

	User findUserByActiveCode(String activeCode) throws SQLException;

	void activeUser(String activeCode) throws SQLException;

	User findUserByUsernameAndPassword(String username, String password) throws SQLException;

	boolean findUserByUsername(String username)throws SQLException;
}