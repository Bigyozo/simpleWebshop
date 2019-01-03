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
		 // ָ����֤Ϊtrue
		 props.setProperty("mail.smtp.auth", "true");
		 props.setProperty("mail.smtp.timeout","1000");
		 // ��֤�˺ż����룬������Ҫ�ǵ�������Ȩ��
		 Authenticator auth = new Authenticator() {
		 public PasswordAuthentication getPasswordAuthentication(){
		    return new PasswordAuthentication("15524843108@163.com", "zfl940420");
		            }
		        };
		 Session session = Session.getInstance(props, auth);

		// 2.����һ��Message�����൱�����ʼ�����
		MimeMessage message = new MimeMessage(session);
		// ���÷�����
		message.setFrom(new InternetAddress("15524843108@163.com"));
		// ���÷��ͷ�ʽ�������
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
		// ��������
		message.setSubject("�ʼ�����ע��");
		// ��������
		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.���� Transport���ڽ��ʼ�����
		Transport.send(message);	
	}
}
