package com.ssongman.resource;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class controller {
	@GetMapping
	public String hello(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		System.out.println("before session uid : " + uid);
		if (uid==null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		System.out.println("after session uid : " + uid.toString());
		return "Hello World get";
	}
	
	@PostMapping("/add")
	public String helloPost(@RequestBody final String hello) {
		return "Hello world post";
	}
}
