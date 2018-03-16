package ge.tsotne.nsdi.controller;

import ge.tsotne.nsdi.service.MyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping({"/", "index"})
	public String getIndexPage(ModelMap modelMap){
		modelMap.addAttribute("currentUser",MyUserService.getUser().getUsername());
		return "index";
	}
}
