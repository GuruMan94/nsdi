package ge.tsotne.nsdi.controller;

import ge.tsotne.nsdi.model.MyUser;
import ge.tsotne.nsdi.service.MyUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	private MyUserService myUserService;

	@Autowired
	public RegistrationController(MyUserService myUserService) {
		this.myUserService = myUserService;
	}

	@GetMapping
	public String registration(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		return "registration";
	}

	@PostMapping
	public String registerUser(@ModelAttribute MyUser myUser){
		if(StringUtils.isAnyBlank(myUser.getPassword(),myUser.getUsername())){
			throw new RuntimeException("username or password is blank");
		}
		myUser.setId(null);
		myUserService.register(myUser);
		return "redirect:login.html";
	}

//	@GetMapping("/all")
//	@ResponseBody
//	public List<MyUser> all(){
//		return myUserService.findAll();
//	}

}
