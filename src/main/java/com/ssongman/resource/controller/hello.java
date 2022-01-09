package com.ssongman.resource.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/hello")
@Api(value="HelloWorld Resource REST Endpoint", description = "shows the hello info")
public class hello {
	
	@ApiOperation(value="Returns Hello World")
	@ApiResponses(
			value= {
					@ApiResponse(code=100, message="100 is the message"),
					@ApiResponse(code=200, message="Successfull Hello World")
			}
	)	
	@GetMapping
	public String hello() {
		return "Hello World get";
	}

	@ApiOperation(value="Returns Hello World Session")
	@GetMapping("/session")
	public String helloSession(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		System.out.println("before session uid : " + uid);
		if (uid==null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		System.out.println("after session uid : " + uid.toString());
		return "Hello World get";
	}

	@ApiOperation(value="Returns Post Hello World")
	@PostMapping("/post")
	public String helloPost(@RequestBody final String hello) {
		return hello;
	}

	@ApiOperation(value="Returns Put Hello World")
	@PostMapping("/put")
	public String helloPut(@RequestBody final String hello) {
		return hello;
	}
}
