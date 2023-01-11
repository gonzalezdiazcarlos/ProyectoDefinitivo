package Utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Newsletter {

		
	private Properties propiedades;
	private  Session sesion;
		

	Properties p = new Properties();
		
		
	public Newsletter(String correoEnvio) throws IOException {
			this.propiedades = new Properties();
			loadConfig(correoEnvio);
			checkConfg();
			 
			
			
		}
	private void loadConfig(String ruta) throws IOException{
		InputStream is = new FileInputStream( ruta);
				this.propiedades.load(is);
	}
    private void checkConfg() throws InvalidParameterException{
        String[] keys = {
        			"mail.smtp.host",
        			"mail.smtp.port",
        			"mail.smtp.user",
        			"mail.smtp.password",
        			"mail.smtp.starttls.enable",
        			"mail.smtp.auth"};
        for (int i = 0; i < keys.length; i++) {
				if (this.propiedades.get(keys[i])==null) {   throw new InvalidParameterException("No existe la clave "+keys[i]);		}		  
        }  }
    public void sendMail(String asunto, String message, String mail) throws MessagingException{
    	MimeMessage email = new MimeMessage(sesion);
    	email.setFrom (new InternetAddress ((String) this.p.get("mail.smtp.user")));
    	email.addRecipient(Message.RecipientType.TO,new InternetAddress (mail));
    	email.setSubject(asunto);
    	email.setText(message);
    	Transport t = sesion.getTransport("smtp");
    	t.connect((String)this.p.get("mail.smtp.user"),(String)this.p.get("mail.smtp.password"));
    	t.sendMessage(email, email.getAllRecipients());
    }
    
    public void sendConjuntoMails(String asunto, String message, String[] mail) throws MessagingException{
    	MimeMessage email = new MimeMessage(sesion);
    	email.setFrom (new InternetAddress ((String) this.p.get("mail.smtp.user")));
    	for (int j = 0; j < mail.length; j++) {
        	email.addRecipient(Message.RecipientType.TO,new InternetAddress (mail[j]));
		}
    	email.setSubject(asunto);
    	email.setText(message);
    	Transport t = sesion.getTransport("smtp");
    	t.connect((String)this.p.get("mail.smtp.user"),(String)this.p.get("mail.smtp.password"));
    	t.sendMessage(email, email.getAllRecipients());
    }
    public  void signUpMail(String correo) throws MessagingException {
    	sendMail("Registro","Bienvenido al  grupo \nEstamos muy contentos de que hayas decidido registarte con nosotros.\nUn saludo",correo);
    }
   public void biggestOrderSendMail(List<String> lista) throws MessagingException{
	   for(String correo : lista) {
	   sendMail("Dar las gracias","Muchas gracias por confiar en nosotros, \nEsperamos volver a vernos pronto\n Un saludo",correo);
   }}
}
