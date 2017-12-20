package com.hsbc.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.hsbc.auth.domain.LoginResponseVO;
import com.hsbc.auth.domain.LoginVO;
import com.hsbc.auth.util.CognitoHelper;



/**
 * Class: AuthServerController 
 * 
 * @author berchmansa
 */
@RestController
@EnableWebMvc
public class AuthServerController {
	
	@Autowired
	CognitoHelper cognitoHelper;
	
	
	
	@RequestMapping(value = "/avail", method = RequestMethod.GET)
	public String init() {
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("Authentication Server", "Auth Server is Running..");
		return gson.toJson("Auth Server is Running..");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody LoginVO loginVO, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		System.out.println("Start : login" + loginVO.getUserName() +"     " + loginVO.getPassword());
		String response = "";
		LoginResponseVO loginResponseVO =  new LoginResponseVO();
		try {
			loginResponseVO = cognitoHelper.validateUser(loginVO.getUserName(), loginVO.getPassword());
			System.out.println("Responce Token : " + response);
		} catch (Exception e) {
			System.out.println("Error : "+ e.getMessage());
		}
		return gson.toJson(loginResponseVO);
	}
}
