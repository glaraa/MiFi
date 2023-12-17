package com.MakeitFlauntit.MIFI.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
import com.MakeitFlauntit.MIFI.service.AllUsersService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession; 
@Controller
//@RestController
public class MiFiController {
	@Autowired(required = false)
	private AllUsersService aus;
	@Autowired(required = false)
	private AllUsersRepo aur;
	@Autowired
	 private BCryptPasswordEncoder passwordEncode;
	
	
	
//////////////////////////////////////////SHOW_LOGIN_PAGE//////////////////////////////////////////////////////////////	
	@GetMapping("/")
	public String login() {
		return "Login";
	}
	
	
///////////////////////////////////////////SHOW_FORGOT_PASSWORD_PAGE///////////////////////////////////////////////////////////
	@GetMapping("/forgot_pass")
	public String forgotPass() {
		return "ForgotPassword";
	}
	
	
	////////////////////////////////////REGISTRATION////////////////////////////////////////////
	
	@PostMapping("/allRecords")
	public String createuser(@ModelAttribute AllRecords allrecords, HttpSession session) {
		// System.out.println(user);
		boolean f = aus.checkUserName(allrecords.getUserName());
		if (f) {
			session.setAttribute("msg", "User Name already exists");
			System.out.println("UserName already Exists");
		} else {
			AllRecords allrecords1 = aus.addUsers(allrecords);
			if (allrecords1 != null) {
				session.setAttribute("msg", "Registered Sucessfully");
				System.out.println("Registeration Successful");
			} else {
				session.setAttribute("msg", "Something wrong on server");
			}
		}

		return "redirect:/";
	}
/////////////////////////////////////////FORGOT_PASSWORD////////////////////////////////////////////////
//	@PostMapping("/for_pass")
//	public String check(@RequestParam String userName,@RequestParam String email, HttpSession session)
//	{
//		AllRecords ar;
//		ar=aur.findByUserNameAndEmail(userName, email);
//	    if(ar!=null) {
//	    	session.setAttribute("msg", "Entered data Validated...!\nFurther message will be sent through given email");
//	    	char[] temp=ses.genOTP();
//	    	String otp=new String(temp);
//	    	ar.setPassword(passwordEncode.encode(otp));
//	    	aur.save(ar);
//	    	String name=ar.getFirstName();
//	    	EmailForgotPass efp=ses.mailContents(email, otp,name);
//	    	ses.sendSimpleMail(efp);
//	    }
//	    else {
//	    	session.setAttribute("msg", "Entered username and email doesnt exist");
//	    }
//		
//		return "redirect:/forgot_pass";
//	
//	 }
}
