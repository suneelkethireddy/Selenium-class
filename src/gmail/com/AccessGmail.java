package gmail.com;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AccessGmail {

	public static void main(String[] args) {

		AccessGmail gmail = new AccessGmail();
		//gmail.read();

		gmail.send();

	}

	public void read() {

		Properties props = new Properties();

		try {
			props.load(new FileInputStream(new File("smtp.properties")));
			Session session = Session.getDefaultInstance(props, null);

			Store store = session.getStore("imaps");
			store.connect("smtp.gmail.com", "***************@gmail.com", "********");

			Folder inbox = store.getFolder("inbox");
			inbox.open(Folder.READ_ONLY);
			int messageCount = inbox.getMessageCount();

			System.out.println("Total Messages:- " + messageCount);

			Message[] messages = inbox.getMessages();
			System.out.println("------------------------------");

			for (int i = 0; i < 10; i++) {
				if(messages[i].getSubject().equalsIgnoreCase("randomString")){
					System.out.println("Email is received");
				}
				System.out.println("Mail Subject:- " + messages[i].getSubject().compareToIgnoreCase(""));
			}

			inbox.close(true);
			store.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void send() {
		final String username = "******************@gmail.com";
		final String password = "*********";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("****************@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("************************i@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}