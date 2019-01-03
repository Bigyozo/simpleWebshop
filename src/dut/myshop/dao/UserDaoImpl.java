package dut.myshop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dut.myshop.domain.User;
import dut.myshop.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {
	
	/* (non-Javadoc)
	 * @see dut.myshop.dao.UserDao#addUser(dut.myshop.domain.User)
	 */
	@Override
	public void addUser(User user) throws SQLException {
		String sql="insert into user(username,password,gender,email,telephone,introduce,activeCode) values(?,?,?,?,?,?,?)";
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		int row=runner.update(conn,sql,user.getUsername(),user.getPassword(),user.getGender(),user.getEmail(),user.getTelephone(),user.getIntroduce(),user.getActiveCode());
		if(row==0) {
			throw new RuntimeException();
		}	
	}
	
	/* (non-Javadoc)
	 * @see dut.myshop.dao.UserDao#findUserByActiveCode(java.lang.String)
	 */
	@Override
	public User findUserByActiveCode(String activeCode) throws SQLException {
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		String sql="select * from user where activeCode = ?";
		User user=runner.query(conn, sql,new BeanHandler<User>(User.class),activeCode);
		return user;
	}
	
	/* (non-Javadoc)
	 * @see dut.myshop.dao.UserDao#activeUser(java.lang.String)
	 */
	@Override
	public void activeUser(String activeCode) throws SQLException {
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		String sql="update user set state = 1 where activeCode = ?";
	    runner.update(conn,sql,activeCode);		
	} 
	
	/* (non-Javadoc)
	 * @see dut.myshop.dao.UserDao#findUserByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUserByUsernameAndPassword(String username,String password) throws SQLException {
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		String sql="select * from user where username = ? and password = ?";
		return runner.query(conn, sql, new BeanHandler<User>(User.class), username,password);	
	}

	@Override
	public boolean findUserByUsername(String username) throws SQLException {
		QueryRunner runner=new QueryRunner();
		Connection conn=DataSourceUtils.getConnection();
		String sql="select * from user where username = ?";		
		User user=runner.query(conn, sql, new BeanHandler<User>(User.class), username);
		if(user==null)
			return false;
		else return true;
	}
	
}
