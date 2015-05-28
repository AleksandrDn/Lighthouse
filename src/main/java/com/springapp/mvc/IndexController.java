package com.springapp.mvc;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springapp.mvc.helperEntity.Booking;
import com.springapp.mvc.service.AccountService;
import com.springapp.mvc.service.ClientService;
import com.springapp.mvc.service.NewsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class IndexController {

	@Resource(name="accountService")
	private AccountService accountService;

	@RequestMapping("/")
	public ModelAndView printWelcome(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = setLoginText(auth.getName());
		return new ModelAndView("index", "loginSelector", name);/*"index"*/
	}

	private String setLoginText(String email)
	{
		if (email.equals("anonymousUser"))
			return "<a href=\"/login\">" + "Войти" + "</a>";
		String nameRole = accountService.getRole(email);
		String name = accountService.getFirstName(email);
		if (nameRole.equals("ROLE_USER"))
			return "<a href=\"/user/indexUser\">" + name + "</a>";
		else
			return "<a href=\"/admin/indexAdm\">" + name + "</a>";
	}

	private String setBookingFirstName(String email)
	{
		if (email.equals("anonymousUser"))
			return "";
		return accountService.getFullFirstName(email);
	}
	private String setBookingLastName(String email)
	{
		if (email.equals("anonymousUser"))
			return "";
		return accountService.getLastName(email);
	}
	private String setBookingPhone(String email)
	{
		if (email.equals("anonymousUser"))
			return "";
		return accountService.getPhone(email);
	}

//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}

	@RequestMapping("/news")
	public ModelMap news(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loginSelector", setLoginText(auth.getName()));
		return model;
	}

	@RequestMapping("/reviews")
	public ModelMap reviews(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("loginSelector", setLoginText(auth.getName()));
		if (!auth.getName().equals("anonymousUser")) {
			model.addAttribute("isUser", "block");
			model.addAttribute("id", auth.getName());
		}
		else {
			model.addAttribute("isUser", "none");
			model.addAttribute("id", "");
		}
		return model;
	}

	@RequestMapping("/pricing")
	public String pricing() {
		return "pricing";
	}

	@RequestMapping("/booking")
	public ModelMap booking(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName();
		model.addAttribute("loginSelector", setLoginText(email));
		model.addAttribute("firstName", setBookingFirstName(email));
		model.addAttribute("lastName", setBookingLastName(email));
		model.addAttribute("phone", setBookingPhone(email));
		if (!email.equals("anonymousUser")) {
			model.addAttribute("mode", "readonly");
			if (setBookingPhone(email) != null)
				model.addAttribute("modePhone", "readonly");
			else
				model.addAttribute("modePhone", " ");
		}
		else
			model.addAttribute("mode", " ");

		return model;
	}

	@RequestMapping("/payForm")
	public ModelAndView showPayForm(@RequestParam(value="token") String token) {
		Booking booking = null;
		ModelAndView m = new ModelAndView("payForm");
		m.addObject("clientName",  " " + token);
		return m;
	}

//	@RequestMapping("/signup")
//	public String signup() {
//		return "signup";
//	}

	@RequestMapping("/404")
	public String err404() {
		return "404";
	}
}