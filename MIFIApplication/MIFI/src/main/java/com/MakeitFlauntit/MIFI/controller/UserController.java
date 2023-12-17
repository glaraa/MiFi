package com.MakeitFlauntit.MIFI.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.MakeitFlauntit.MIFI.entity.AllRecords;
import com.MakeitFlauntit.MIFI.entity.CreationComments;
import com.MakeitFlauntit.MIFI.entity.UserBuddies;
import com.MakeitFlauntit.MIFI.entity.UserCreations;
import com.MakeitFlauntit.MIFI.entity.UserProfilePic;
import com.MakeitFlauntit.MIFI.repository.AllUsersRepo;
import com.MakeitFlauntit.MIFI.repository.BuddyReqsRepo;
import com.MakeitFlauntit.MIFI.repository.CommentsRepo;
import com.MakeitFlauntit.MIFI.repository.UserBuddiesRepo;
import com.MakeitFlauntit.MIFI.repository.UserCreationsRepo;
import com.MakeitFlauntit.MIFI.service.AllUsersService;
import com.MakeitFlauntit.MIFI.service.BuddyReqService;
import com.MakeitFlauntit.MIFI.service.UserBuddyService;
import com.MakeitFlauntit.MIFI.service.UserCreationService;

@Controller
@RequestMapping("/user" )
public class UserController {
	@Autowired
	private AllUsersRepo aur;
	@Autowired
	private AllUsersService aus;
	@Autowired
	private UserCreationService ucs;
	@Autowired
	private UserCreationsRepo ucr;
	@Autowired
	private BuddyReqService brs;
	@Autowired
	private UserBuddyService ubs;
	@Autowired
	private UserBuddiesRepo ubr;
	@Autowired
	private BuddyReqsRepo brr;
	@Autowired
	private CommentsRepo cr;
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	String otp;
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@ModelAttribute
	private void userDetails(Model m, Principal p) {
	String userName = p.getName();
	AllRecords allrecords = aur.findByUserName(userName);
	m.addAttribute("user", allrecords);
	long reqCount= brr.countByAddedUserName(userName);
	m.addAttribute("reqC", reqCount);
	List<UserCreations> list = ucr.findAllByUserName(userName);
	m.addAttribute("list", list);
	long count = ucr.countByUserName(userName);
	m.addAttribute("count",count);
	List<AllRecords> allR = new ArrayList<AllRecords>();
	List<String> ub= ubr.findByUserName(userName);
	if(!ub.isEmpty()) {
		for(String u: ub) {
			allR.addAll(aur.findAllByUserName(u));
		}
	}
	long budCount = ubr.countByUserName(userName);
	m.addAttribute("budCount",budCount);
	m.addAttribute("userbud", allR);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@PostMapping("/{userName}")
	 public String delBuddy(@PathVariable String userName,Principal p) {
		String buddyUserName=userName;
		userName =p.getName();
		ubr.deleteByUserNameAndBuddyUserName(userName,buddyUserName);
		ubr.deleteByUserNameAndBuddyUserName(buddyUserName,userName);
		return "redirect:/user/";
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@GetMapping("/settings")
	public String settings() {
		
		return "user/Settings";
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/")
	public String home() {
	

		return "user/UserProfile";
	}
//////////////////////////////////////CREATION_DETAILS/////////////////////////////////////////////////
	@GetMapping("/creation_det/{srNo}")
	public String creationDet(@PathVariable int srNo,Principal p,Model m) {
		UserCreations uc= new UserCreations();
		AllRecords ar=new AllRecords();	
       String userName= ucr.findBySrNo(srNo);
       boolean priv;
       if(userName.equals(p.getName())) {
    	   priv=true;
       }
       else {
    	   priv=false;
       }
       m.addAttribute("priv", priv);
       ar=aur.findByUserName(userName);
       uc=ucr.findAllBySrNo(srNo);
       uc.setFirstName(ar.getFirstName());
       uc.setLastName(ar.getLastName());
       uc.setProPic(ar.getUserProPic());
       ucr.save(uc);
		System.out.println(userName);
 		List<CreationComments> cc= cr.findAllByCreationId(srNo);
 		m.addAttribute("cc", cc);
		m.addAttribute("ar", ar);	
		m.addAttribute("uc", uc);
		return "user/CreationComments";
	
	}
/////////////////////////////////////////DELETE_CREATION/////////////////////////////////////////////
	@PostMapping("/del_creation/{srNo}")
	public String delCreation(@PathVariable int srNo) {
	   ucr.deleteBySrNo(srNo);
		return "redirect:/user/";
		
	}
	
////////////////////////////////////////BUDDY_PROFILE////////////////////////////////////////////////////////////////
	@GetMapping("/bud_profile/{userName}")
	public String budProfile(@PathVariable String userName,Principal p,Model m) {
	if(
		userName.equals(p.getName())) {
		return "user/UserProfile";	
		}
	else
	{
		String budUserName=userName;
		userName=p.getName();
		AllRecords allrecords = aur.findByUserName(budUserName);
		m.addAttribute("buddy", allrecords);
		boolean budCheck=ubr.existsByUserNameAndBuddyUserName(userName, budUserName);
		System.out.println("budcheck"+ budCheck);
		m.addAttribute("check", budCheck);
		List<UserCreations> list = ucr.findAllByUserName(budUserName);
		m.addAttribute("budList", list);
		List<AllRecords> allR = new ArrayList<AllRecords>();
		List<String> ub= ubr.findByUserName(budUserName);
		if(!ub.isEmpty()) {
			for(String u: ub) {
				allR.addAll(aur.findAllByUserName(u));
			}
		}
		m.addAttribute("budBud", allR);
		long count = ucr.countByUserName(budUserName);
		m.addAttribute("count",count);
		long budCount = ubr.countByUserName(budUserName);
		m.addAttribute("budCount",budCount);
		boolean reqSent= brr.existsByAddedUserNameAndReqUserName(budUserName, userName);
	    m.addAttribute("reqSent", reqSent);
	    boolean reqRec= brr.existsByAddedUserNameAndReqUserName(userName, budUserName);
	    m.addAttribute("reqRec", reqRec);
		return "user/BuddyProfile";
	}
		
		
	}
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////BUDDY_SUGGESTIONS/////////////////////////////////////////////////////////
	
	@GetMapping("/buddy_sug")
	public String sugBuddy(Principal p,Model m) {
		
		 List<String> username= new ArrayList<String>();
		String reqUserName = p.getName();
		  List <String> alAdded=brr.findByReqUserName(reqUserName);
		    if(!alAdded.isEmpty())
		    {
		      username.addAll(alAdded);
		    }
		    List <String> alBuds=ubr.findByUserName(reqUserName);
		    if(!alBuds.isEmpty())
		    {
		      username.addAll(alBuds);
		    }
		    List <String> alGotAdded=brr.findByAddedUserName(reqUserName);
		    if(!alGotAdded.isEmpty())
		    {
		      username.addAll(alGotAdded);
		    } 
		username.add(reqUserName);
	    List<AllRecords> ar=aur.findByUserNameNotIn(username);
	    m.addAttribute("ar", ar);
	    return "user/SuggestBuddies";
	}

	
//////////////////////////////////////////ON_CLICK_ADD_BUTTON///////////////////////////////////////////////////////////////
	  
	
	
		@PostMapping("/buddy_sug/{userName}")
	       public String sugUser (@PathVariable String userName,Principal p) 
	    {    	
			String addedUserName=userName;
		    String reqUserName=p.getName(); 
		    brs.addBuddyReqs(addedUserName,reqUserName);
		    return "redirect:/user/buddy_sug";
	    }
		
////////////////////////////////////////////////////////////////////////////////////////////////////////	  
	
		@GetMapping("/add_from_profile/{userName}")
	       public String addFromProfile (@PathVariable String userName,Principal p,Model m) 
	    {    	
			String addedUserName=userName;
		    String reqUserName=p.getName(); 
		    brs.addBuddyReqs(addedUserName,reqUserName);
		    return "redirect:/user/bud_profile/{userName}";
	    }
		
		
//////////////////////////////////////////////BUDDY_REQ///////////////////////////////////////////////////////////
	
	    
	    
	@GetMapping("/buddy_req")
	public String reqBuddy(Principal p,Model m) {
		String addedUserName =p.getName();
		List<AllRecords> userReqsDetails= new ArrayList<AllRecords>();
		userReqsDetails=brs.showBudReqs(addedUserName);
		m.addAttribute("userReq", userReqsDetails);
		return "user/AddBuddies";
	}
	
////////////////////////////////////////////ADD_BUDDY////////////////////////////////////////////////////////////	
	
	
	@PostMapping("/buddy_req/add/{userName}")
	public String addBuddy(@PathVariable String userName,Principal p ) {
		  String buddyUserName=userName;
		  userName=p.getName();
		  ubs.addBuddy(buddyUserName,userName);
		  ubs.addBuddy(userName,buddyUserName);
		  brr.deleteByAddedUserNameAndReqUserName(userName,buddyUserName);
		return "redirect:/user/buddy_req";
	}
	
	
	
//////////////////////////////////////////////DELETE_BUDDY_REQ//////////////////////////////////////////////////////////////////////
	
	
	@PostMapping("/buddy_req/delete/{userName}")
	public String delReq(@PathVariable String userName ,Principal p) {
		  String addedUserName=userName;
		  userName=p.getName();
		  brr.deleteByAddedUserNameAndReqUserName(userName,addedUserName);	  
		return "redirect:/user/buddy_req";
				}
	
	
/////////////////////////////////////////////CHANGE_ABOUT////////////////////////////////////////////
	  @PostMapping("/changeAbout")
	  public String about(@RequestParam String userAbout,Principal p) 
	  { 
		  String changeAbout=userAbout;
    		String userName =p.getName();		
        aus.updateUserAbout(userName, changeAbout);
	    return "redirect:/user/";
	  }
///////////////////////////////////////////CHANGE_PROFILE_PIC///////////////////////////////////////////////
	  
	  @PostMapping("/addpropic")
	  public String userProPic(@RequestParam MultipartFile proPic,Principal p) {
		      UserProfilePic upp = new UserProfilePic();
			  upp.setUserProPic(proPic.getOriginalFilename());
			//  System.out.println(upp);
			    String userName=p.getName();
			  aus.updateUserProPic(userName, upp.getUserProPic());
			 // UserProfilePic uploadpp =appRepo.save(upp);
			  if (upp != null) 
			  { 
				  try
				  {
					  File saveimg = new
					  ClassPathResource("static/proPics").getFile(); 
					  Path path =Paths.get(saveimg.getAbsolutePath() + File.separator +proPic.getOriginalFilename()); 
					   System.out.println(path);
					   Files.copy(proPic.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
					}
				   catch (Exception e)
				   {
			          e.printStackTrace();
			        } 
				  } 
			   return "redirect:/user/";
			   }
//////////////////////////////////////////USER_CREATIONS///////////////////////////////////////////////////////////////////////////////////////
	
	  @PostMapping("/addCreations")
	  public String userCreations(@RequestParam String caption,@RequestParam MultipartFile creations,Principal p) {
			   String userName=p.getName();
			   String creationCaption=caption;
			   String creationName=creations.getOriginalFilename();
			   UserCreations uc =new UserCreations();
     	       uc  = ucs.addCreation(userName,creationCaption,creationName);
			  if (uc != null) 
			  { 
				  try
				  {
					  File saveimg = new
					  ClassPathResource("static/creations").getFile(); 
					  Path path =Paths.get(saveimg.getAbsolutePath() + File.separator +creations.getOriginalFilename()); 
					  // System.out.println(path);
					   Files.copy(creations.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
					}
				   catch (Exception e)
				   {
			          e.printStackTrace();
			        } 
				  } 
			   return "redirect:/user/";
			   }
	  
///////////////////////////////////SETTINGS_CHANGE_USER_ABOUT/////////////////////////////////////////////////////////////
	  @PostMapping("/changeEmail")
	  public String changeEmail(@RequestParam String newEmail,Principal p, HttpSession session) {
		  String userName=p.getName();
		  AllRecords ar;
		  ar=aur.findByUserName(userName);
		  ar.setEmail(newEmail);
		  aur.save(ar);
		  session.setAttribute("msg", "Email Changed Successfully..!");
		  
		return "redirect:/user/settings";
		}
/////////////////////////////////////////SETTINGS_CHANGE_USERNAME////////////////////////////////////////////////////////////
	  @PostMapping("/changeUserName")
	  public String changeUserName(@RequestParam String newFirstName,@RequestParam String newLastName,Principal p, HttpSession session) {
		 
		 
		  String userName=p.getName();
		  AllRecords ar;
		  ar=aur.findByUserName(userName);
		  ar.setFirstName(newFirstName);
		  ar.setLastName(newLastName);
		  aur.save(ar);
		  session.setAttribute("msg", "Name Changed Successfully..!");
			return "redirect:/user/settings"; 
	  }
////////////////////////////////////////CHANGE_PASSWORD//////////////////////////////////////////////////////////		
	  
	  @PostMapping("/changePass")
	  public String changePassword(@RequestParam String oldPassword,@RequestParam String newPassword,Principal p, HttpSession session) {
		  String userName=p.getName();
		  
		  AllRecords ar;
		  ar=aur.findByUserName(userName);
		  boolean passCheck=passwordEncode.matches(oldPassword, ar.getPassword());
			   if(passCheck) {
			   ar.setPassword(passwordEncode.encode(newPassword));
			   aur.save(ar);
			   session.setAttribute("msg", "Password Changed Successfully..!");
		  }
		  else {
			  session.setAttribute("msg", "Old Password is invalid");
		  }
		   
		return "redirect:/user/settings";
		}

/////////////////////////////////////////////////////////////////////////////////////////////////////////	  
	  
	  @GetMapping("/del_final")
	  public String delFin() {
	
		  return "user/DelFin";
	  }
	  
/////////////////////////////////////////DELETE_ACCOUNT////////////////////////////////////////////////////////////
	  
 @PostMapping("/del_fin")
	     public String delAll(@RequestParam String pass,@RequestParam String feedback,Principal p, HttpSession session) {
	 		 AllRecords ar = aur.findByUserName(p.getName());
	     if(passwordEncode.matches(pass, ar.getPassword()))
	     {
	    	
	 	  String userName=p.getName();
	 	  aus.feedBack(userName, feedback);
	 	  aur.deleteByUserName(userName);
		  return "redirect:/logout";
	     }
	     else {
	    	 session.setAttribute("otp", "OTP INVALID: Account Deletion Canceled");
	    	 return "redirect:/user/del_final";
	     }
	  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 	

	 	  
////////////////////////////////////////////////////////////////////////////////////////////////////////
	  
	 	@GetMapping("/feed")
	     public String feed(Principal p,Model m) {
	         String userName= p.getName();
	      //   UserCreations uc=new UserCreations();
	         AllRecords ar;	         
	         List<UserCreations> budC=new ArrayList<UserCreations>();
	         List<String> list= ubr.findByUserName(userName); 
	         for(String l:list)
	         {
	        	 ar=aur.findByUserName(l); 
	        	 List<UserCreations> temp=ucr.findAllByUserName(l);
	        	 budC.addAll(temp);        	
	        	 for(UserCreations u:temp) 
	        	 {	        		
	        		u.setFirstName(ar.getFirstName());
	        	    u.setLastName(ar.getLastName());
	        	    u.setProPic(ar.getUserProPic());
	        	    ucr.save(u);	        	    
	        	 }	        	 
	        	 temp.clear();
	         }	         
	      //  System.out.println(budC);
	         m.addAttribute("budC", budC);
	         return "user/UserFeed";
	     }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	 	@GetMapping("/creation_comm/{srNo}")
	 	 public String creation_comm(@PathVariable int srNo,Principal p,Model m) {
	 		UserCreations uc= ucr.findAllBySrNo(srNo);
	 		m.addAttribute("uc", uc);
	 		List<CreationComments> cc= cr.findAllByCreationId(srNo);
	 		m.addAttribute("cc", cc);
	 		return "user/CreationComments";
	 	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	 	@PostMapping("/addComment/{srNo}")
		  public String addComment(@PathVariable int srNo,@RequestParam String comment,Principal p, HttpSession session) {
			 
			  String userName=p.getName();
			  AllRecords ar;
			  ar=aur.findByUserName(userName);
			  CreationComments cc= new CreationComments();
			  cc.setComUserName(userName);
			  cc.setComProPic(ar.getUserProPic());
			  cc.setCreationId(srNo);
			  cc.setComFirstName(ar.getFirstName());
			  cc.setComLastName(ar.getLastName());
			  cc.setComment(comment);
			  cr.save(cc);
			  return "redirect:/user/creation_comm/{srNo}"; 
		  }
	 	
}
