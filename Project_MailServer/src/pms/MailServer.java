package pms;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  

public class MailServer
{
	public static void main(String[] args) 
		{
			String to="pmalakar09@gmail.com";
			Properties props = new Properties();  
			  props.put("mail.smtp.host", "smtp.gmail.com");  
			  props.put("mail.smtp.socketFactory.port", "465");  
			  props.put("mail.smtp.socketFactory.class",  
			            "javax.net.ssl.SSLSocketFactory");  
			  props.put("mail.smtp.auth", "true");  
			  props.put("mail.smtp.port", "465");  
			   
			  Session session = Session.getDefaultInstance(props,  
			   new javax.mail.Authenticator() {  
			   protected PasswordAuthentication getPasswordAuthentication() {  
			   return new PasswordAuthentication("divsserver@gmail.com","9477151565");
			   }  
			  });  
			   
			  //compose message  
			  try {  
			   MimeMessage message = new MimeMessage(session);  
			   message.setFrom(new InternetAddress("divsserver@gmail.com"));
			   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			   message.setSubject("Hello Server Testing");  
			   message.setText("Testing DIVS Admin Server.......");  
			     
			   //send message  
			   Transport.send(message);  
			  
			   System.out.println("message sent successfully");  
			   
			  } catch (MessagingException e) {throw new RuntimeException(e);}  
			   
		}
}
