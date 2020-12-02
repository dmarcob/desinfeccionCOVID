package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Clase para enviar emails
 *
 */
public class SendEmail {

	private static final String remitente = "megaloCovid@gmail.com";
	private static final String clave = "sisinfo2020";

	private static Properties getProps() {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", clave); // La clave de la cuenta
		props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave
		props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
		props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google
		// TODO: ESTA LINEA ES IMPORTANTE
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		return props;
	}


	public static boolean sendEmail(String destinatario, String titulo, String mensaje) {
		boolean ok = false;
		Properties props = getProps();
		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject(titulo);
			message.setText(mensaje);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, clave);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			ok = true;
		} catch (MessagingException me) {
			me.printStackTrace(); // Si se produce un error
		}
		return ok;
	}
}
