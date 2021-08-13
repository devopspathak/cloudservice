package com.ap.hello;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
Logger logger=Logger.getLogger("HelloController.class");
	@RequestMapping("/")
	public String index(HttpServletRequest req) {
		logger.info("hello....................");
		String name=System.getenv("NAME1");
		System.out.println(name);
		logger.info("hello......."+name);
		
		String ip = req.getHeader("x-forwarded-for");      
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		       ip = req.getHeader("Proxy-Client-IP");      
		   }   
		   if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {      
		       ip = req.getRemoteAddr();      
		   }      
		return "Greetings from Spring Boot!-----"+ip+"  "+name;
		
		
	}

}