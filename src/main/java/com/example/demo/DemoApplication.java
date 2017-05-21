package com.example.demo;

import com.example.demo.exception.LoginMyException;
import com.example.demo.exception.ModulViewException;
import com.example.demo.exception.MyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/")
	public String greeting() {

		//throw new MyException("发生错误2",123);
		throw new NullPointerException();
		//return "Hello World!";
	}


	@RequestMapping("/{id}")
	public String t1(@PathVariable Integer id, HttpServletRequest req) throws LoginMyException {
		System.out.println(req.getHeader("Accept"));
		System.out.println(req.getHeaderNames());
		if(1==1) {
			switch (id) {
				case 1:
					throw new NullPointerException();

				case 2:
					throw new LoginMyException();

				case 3:


			}
		}
		return "is ok";
	}


	@RequestMapping("/modelview/{id}")
	public ModelAndView  t2(@PathVariable Integer id) throws MyException, ModulViewException {
		switch (id) {
			case 1:

				throw new ModulViewException();
			case 2:
				throw new MyException();
			case 3:
				throw new RuntimeException();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return  modelAndView;
	}
	@RequestMapping("/html")
	public ModelAndView  test(@PathVariable Integer id) throws MyException, ModulViewException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("success");
		return  modelAndView;
	}



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
