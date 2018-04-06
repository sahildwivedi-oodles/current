package com.example.traning.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.traning.domain.Otp;
import com.example.traning.repository.OtpRepository;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

@Service
public class EmailService {
	
	
	public static final String ACCOUNT_SID = "AC44c8bbce79fdaba40fcdba34296adf83";
	public static final String AUTH_TOKEN = "a1de3ceacfaa7c18e9d92ad0742b4d20";
	public static final String TWILIO_NUMBER = "+13309474628";
	int otp;
	
	@Autowired
	OtpRepository otprepository;

	@Autowired
      private JavaMailSender emailSender;

	    public void sendSimpleMessage(String mail,int otp) {
		System.err.println(mail);
		this.otp=otp;
		System.out.println(otp);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Account verfication");
		message.setText("body-" + otp);
		message.setTo(mail);
		message.setFrom("sahil.dwivedi@oodlestechnologies.com");
		emailSender.send(message);
		sendSMS();

	}

	public void sendSMS() {
		try {
			TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// params.add(new BasicNameValuePair("Body", "Hello, World!"));
			params.add(new BasicNameValuePair("Body", "Your first message from Twilio!-"+ otp));
			params.add(new BasicNameValuePair("To", "+917007124580")); // Add real number here
			params.add(new BasicNameValuePair("From", TWILIO_NUMBER));
			MessageFactory messageFactory = client.getAccount().getMessageFactory();
			Message message = messageFactory.create(params);
			System.out.println("<--------->"+message.getSid());
			} 
		catch (TwilioRestException e) {
			System.out.println(e.getErrorMessage());
		}
	}

       	public Otp validation(Otp otp) {
       		Otp dotp=otprepository.findOneByOtp(otp.getOtp());
       		if(dotp!=null)
    		{
       			System.out.println(dotp.getEmail());
       			otp.setEmail(dotp.getEmail());
       			otp.setCreateOn(dotp.getCreateOn());
       			    			
    			
    			return otp;
    		}
    		else{throw new NullPointerException("otp doest match");
    		}
	}
     
       	
       	
       	
       	

}