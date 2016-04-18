package com.jpa.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
public static void send(String msgBody) throws UnsupportedEncodingException{
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props, null);
	try {
	    Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("binlu99@gmail.com", "Bin Lu"));
	    msg.addRecipient(Message.RecipientType.TO,
	     new InternetAddress("binlu99@gmail.com", "Bin Lu"));
	    msg.addRecipient(Message.RecipientType.TO,
	   	     new InternetAddress("yinghuicao@hotmail.com", "Yinghui Cao"));
	    msg.setSubject("JSON you submitted");
	    msg.setText(msgBody);
	    Transport.send(msg);

	} catch (AddressException e) {
	    // ...
	} catch (MessagingException e) {
	    // ...
	}
}
}
