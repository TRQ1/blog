package com.q1.blog.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		logger.info("This is the blog of index message");
		return "index";	
	}

	@RequestMapping(value="/head", method = RequestMethod.GET)
	public String head() {
		logger.info("This is the blog of head message");
		return "head";	
	}
	
	@RequestMapping(value="/intro", method = RequestMethod.GET)
	public String intro() {
		logger.info("This is the blog of intro message");
		return "intro";	
	}

	@RequestMapping(value="/footer", method = RequestMethod.GET)
	public String footer() {
		logger.info("This is the blog of footer message");
		return "footer";	
	}


}
	