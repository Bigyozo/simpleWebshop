package dut.myshop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	public static void sendMail(String email,String emailMsg) throws AddressException, MessagingException {
		 Properties props = new Properties();
		 props.setProperty("mail.transport.protocol", "SMTP");
		 props.setProperty("mail.smtp.host", "smtp.163.com");
		 props.setProperty("mail.smtp.port", "25");
		 // 指定验证为true
		 props.setProperty("mail.smtp.auth", "true");
		 props.setProperty("mail.smtp.timeout","1000");
		 // 验证账号及密码，密码需要是第三方授权码
		 Authenticator auth = new Authenticator() {
		 public PasswordAuthentication getPasswordAuthentication(){
		    return new PasswordAuthentication("15524843108@163.com", "zfl940420");
		            }
		        };
		 Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		MimeMessage message = new MimeMessage(session);
		// 设置发送者
		message.setFrom(new InternetAddress("15524843108@163.com"));
		// 设置发送方式与接收者
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
		// 设置主题
		message.setSubject("邮件激活注册");
		// 设置内容
		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送
		Transport.send(message);	
	}
}
