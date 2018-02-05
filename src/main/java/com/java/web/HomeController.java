package com.java.web;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.web.service.UserService;
import com.java.web.service.UserServiceInterface;
import com.java.web.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	private String page;
	
	@RequestMapping("/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails user = (UserDetails) auth.getPrincipal();
			logger.info("UserID : " + user.getUsername());
			page = "redirect:/";
		} else {
			logger.info("Not Login");
			page = "login";
		}
		return page;
	}
	
	@RequestMapping("/jq")
	public String jq() {
		return "jquery";
	}
	
	@RequestMapping("/jData")
	public ModelAndView jData(ModelAndView mav) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails user = (UserDetails) auth.getPrincipal();
			logger.info("User : " + user.getUsername());
			data.put("msg", user.getUsername());
		}else {
			data.put("msg", "내용이 왔습니다.");
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(data));
		mav.addObject("message",jsonObject.toString());
		mav.setViewName("json");
		return mav;
	}
	
	@Autowired
	UserServiceInterface usi;
	
	@RequestMapping("/signup")
	public String singup() {
		return"signup";
	}
	
	@RequestMapping("/adduser")
	public ModelAndView adduser(HttpServletRequest req, ModelAndView mav) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("status", HttpUtil.returnJson(usi.addUser(HttpUtil.paramMap(req))));
		
		if(data.get("status").equals(1)) {
			mav.setViewName("home");
		}else {
			mav.setViewName("login");
		}
		
		return mav;
	}
}
