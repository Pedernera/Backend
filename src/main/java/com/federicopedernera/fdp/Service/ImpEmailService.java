
package com.federicopedernera.fdp.Service;
import com.federicopedernera.fdp.Dto.DtoEmail;
import com.federicopedernera.fdp.Security.Controller.Mensaje;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class ImpEmailService {
   Logger log = LoggerFactory.getLogger(getClass());
   
   @Value("${spring.mail.username}")
	private String from;
   @Autowired
	private JavaMailSender javaMailSender;

	public ResponseEntity<String>sendMail(DtoEmail request){
		MimeMessage msg = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg, false);
                        helper.setFrom(from);
                        helper.setTo(from);
                        helper.setText(request.getMensaje());
                        helper.setSubject("Informacion Contacto");
			javaMailSender.send(msg);
		} catch (MailException | MessagingException e) {
			log.info("error in sending mail, detail: [{}]", e.getMessage());
			return new ResponseEntity(new Mensaje("error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity(new Mensaje("Enviado creada"), HttpStatus.OK);
	}

	
}
