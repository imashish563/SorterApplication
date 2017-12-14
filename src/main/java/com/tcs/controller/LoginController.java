package com.tcs.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.model.LoginData;
import com.tcs.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
    	
    	model.put("login", new LoginData());
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @Valid LoginData loginData, BindingResult result) {

    	LOGGER.info("Entering showWelcomePage");
    	
    	if (result.hasErrors()) {
    		model.put("login", new LoginData());
			return "login";
		}
    	
        boolean isValidUser = service.validateUser(loginData.getUserName(), loginData.getPassword());
        
        LOGGER.info("Is Valid User - " + isValidUser);

        if (!isValidUser) {
        	model.put("login", new LoginData());
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("name", loginData.getUserName());
        model.put("password", loginData.getPassword());

        LOGGER.info("Exiting showWelcomePage");
        return "welcome";
    }

}