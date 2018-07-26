package com.dashboard.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.mail.Multipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dashboard.beans.AskBean;
import com.dashboard.beans.PhotoBean;
import com.dashboard.beans.TrainerBean;
import com.dashboard.service.Trainer;


@Controller

public class controller1 
{
	@Autowired
	Trainer trainer;
	
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request , @RequestParam("fileUpload") MultipartFile fileUp,Model model) throws Exception {
		
		//System.out.println(fileUp.getBytes());
		
	//String	 realPath = request.getServletContext().getRealPath("/");
//	System.out.println(realPath);
		String path = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(path);
		  /*  String classPath = ""+ "kavya123.jpg" ;
		    File f = new File(classPath);
			MultipartFile result = new MockMultipartFile("kavya",
	                "kavyaOrg", "image/jpg", fileUp.getBytes());
		result.transferTo(f);
	  PhotoBean pb = new PhotoBean();
	  pb.setPhotoId("for qwerty post");
	  pb.setPhotoImg(fileUp.getBytes());
	  
		trainer.addPhoto(pb);
	model.addAttribute("img", classPath);*/
		return null;

		
	
		
	}
 



      
	
	
	
	
	
	
	/* @Autowired
	    private JavaMailSender mailSender;
	
	 
	 @RequestMapping(method = RequestMethod.POST, value="/sendEmail")
	    public String doSendEmail(HttpServletRequest request) {
	        // takes input from e-mail form
	        String recipientAddress = request.getParameter("recipient");
	        String subject = request.getParameter("subject");
	        String message = request.getParameter("message");
	         
	        // prints debug info
	        System.out.println("To: " + recipientAddress);
	        System.out.println("Subject: " + subject);
	        System.out.println("Message: " + message);
	         
	        // creates a simple e-mail object
	        SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(recipientAddress);
	        email.setSubject(subject);
	        email.setText(message);
	         
	        // sends the e-mail
	        mailSender.send(email);
	         
	        // forwards to the view named "Result"
	        return "Result";
	    }
	 */
	 
	 
	@RequestMapping(value="/hello" , method=RequestMethod.GET)
	public String getvalues(Model model)
	{
		 Map<AskBean, ArrayList<AskBean>> m= trainer.askForum();
		 model.addAttribute("askobject",m);
		
		System.out.println("controller...");
		return "askform";
	}
	//tostorecomment
	@RequestMapping(value="/tostorecomment",method=RequestMethod.GET)  

	public  @ResponseBody String doValidate(@RequestParam(value ="description") String description,@RequestParam(value ="posttosend") String posttosend) 
	{
		System.out.println("im in controller");
		AskBean a = new AskBean();
		a.setDescription(description);
		
		a.setPostId(Integer.parseInt(posttosend));
		System.out.println(a.getDescription());
		System.out.println(a.getPostId());
		System.out.println("to dao");
		a.setStudentId("kavya123post");
		a.setName("for tym being");
	AskBean ask = 	trainer.addComment(a);
	System.out.println(ask.getName()+","+ask.getDescription()+","+ask.getDateCreated()+","+Integer.parseInt(posttosend));
	return ask.getName()+","+ask.getDescription()+","+ask.getDateCreated()+","+Integer.parseInt(posttosend);
	}
	
	@RequestMapping(value="/tostorepost",method=RequestMethod.GET)  

	public  @ResponseBody String toaddpostqwert(@RequestParam(value ="description") String description) 
	{
		System.out.println("im in controller");
		AskBean a = new AskBean();
		a.setDescription(description);
		
		
		System.out.println(a.getDescription());
		
		System.out.println("to dao");
		a.setStudentId("kavya123post");
		a.setName("for tym being");
	AskBean ask = 	trainer.addPost(a);
	System.out.println("i m in post Controller ");
	System.out.println(ask.getName()+","+ask.getDescription()+","+ask.getDateCreated()+","+ask.getPostId());
	return ask.getName()+","+ask.getDescription()+","+ask.getDateCreated()+","+ask.getPostId();
	}
	
	
	
	
	/*@RequestMapping(value="/tostorecomment" , method=RequestMethod.GET)
	public void doValidate(HttpServletRequest request,Model model) 
	{
	System.out.println("im in controller");
		AskBean a = new AskBean();
		a.setDescription(request.getParameter("description"));
		
		a.setPostId(Integer.parseInt(request.getParameter("posttosend")));
		System.out.println(a.getDescription());
		System.out.println(a.getPostId());
		System.out.println("to dao");
		a.setStudentId("kavya123post");
		a.setName("for tym being");
	AskBean ask = 	trainer.addComment(a);
	System.out.println(ask.getDescription());
		model.addAttribute("addcomment","adfshfdj");
		
	}*/
	 
}
