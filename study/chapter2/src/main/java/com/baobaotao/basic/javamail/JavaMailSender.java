package com.baobaotao.basic.javamail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSender {
	public static void main(String[] args){
		
		Transport transport = null;
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.163.com");
			props.put("mail.smtp.auth", "true");
			Authenticator auth = new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication("bahaidong", "165132298vs");
				}
			};
			Session session = Session.getDefaultInstance(props, auth);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("bahaidong@163.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("xingkong0325@126.com"));
			msg.setSubject("Test Title");
			msg.setText("How are you");
			msg.setSentDate(new Date());
			
			transport = session.getTransport("smtp");
			transport.send(msg);
			System.out.println("邮件发送成功");
		} catch (MessagingException e) {
			System.out.println("邮件发送失败");
			e.printStackTrace();
		}finally {
			try {
				transport.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
