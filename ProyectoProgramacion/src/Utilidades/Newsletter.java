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
import Utilidades.*;
public class Newsletter {
	
		static String remitente="proyectodefinitivoprogram@gmail.com";
		static String claveemail= "fiktyurwaxtknfcb";
		
		public static void sendMail(String destinatario, String asunto,String cuerpo) throws MessagingException{
		Properties props = System.getProperties();
	    props.put("mail.smtp.auth", "true");   
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.host", "smtp.gmail.com");  
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", claveemail);    
	    props.put("mail.smtp.port", "587"); 

	    Session session = Session.getDefaultInstance(props);
	    //session.setDebug(true);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));    
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, claveemail);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   
	    }
	  }
		
		
		 public  static void signUpMail(String correo) throws MessagingException {
		    	sendMail(correo,"Registro","Bienvenido al  grupo \nEstamos muy contentos de que hayas decidido registarte con nosotros.\nUn saludo");
		    }
		
		
		 public static void biggestOrderSendMail(List<String> lista) throws MessagingException{
			   for(String correo : lista) {
			   sendMail(correo,"Dar las gracias","Muchas gracias por confiar en nosotros, \nEsperamos volver a vernos pronto\n Un saludo"); }	
	}
		
		
		
}

/*Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", claveemail);    
	    props.put("mail.smtp.auth", "true");    
	    props.put("mail.smtp.starttls.enable", "true"); 
	    props.put("mail.smtp.port", "587"); 

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));    
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, claveemail);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   
	    }*/


	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
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
   }*/

