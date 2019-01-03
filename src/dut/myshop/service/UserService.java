package dut.myshop.service;

import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import dut.myshop.dao.UserDao;
import dut.myshop.dao.UserDaoImpl;
import dut.myshop.domain.User;
import dut.myshop.exception.LoginException;
import dut.myshop.exception.RegisterException;
import dut.myshop.exception.UserExistException;
import dut.myshop.utils.MailUtils;
import dut.myshop.utils.Md5Utils;

public class UserService {
	private UserDao dao = new UserDaoImpl();

	public User login(String username, String password) throws LoginException {
		User user;
		password=Md5Utils.md5(password);
		try {
			user = dao.findUserByUsernameAndPassword(username, password);
			if (user != null) {
				if (user.getState() == 1)
					return user;
				else
					throw new LoginException("�û�δ����");
			} else
				throw new LoginException("�û������������");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("��¼ʧ��");
		}
	}

	public void register(User user) throws RegisterException, UserExistException {
		try {
			if (dao.findUserByUsername(user.getUsername())) {
				throw new UserExistException();
			} else {
				user.setPassword(Md5Utils.md5(user.getPassword()));
				dao.addUser(user);
				String emailMsg = "��лע�ᣬ���<a href='http://localhost:8080/MyShop/activeUser?activeCode="
						+ user.getActiveCode() + "'>&nbsp;����&nbsp;</a>��ʹ��";
				MailUtils.sendMail(user.getEmail(), emailMsg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RegisterException("ע��ʧ��");
		} catch (AddressException e) {

			e.printStackTrace();
			throw new RegisterException("ע��ʧ��");
		} catch (MessagingException e) {

			e.printStackTrace();
			throw new RegisterException("ע��ʧ��");
		}

	}
}
