
package com.federicopedernera.fdp.Controller;

import com.federicopedernera.fdp.Dto.DtoEmail;
import com.federicopedernera.fdp.Service.ImpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sendEmail")
@CrossOrigin("http://localhost:4200")
public class EmailController {
    
    @Autowired
    ImpEmailService emailService;
    
    @PostMapping("/send")
    public ResponseEntity<?>sendMail(@RequestBody DtoEmail request) {
		return emailService.sendMail(request);
    }
}
