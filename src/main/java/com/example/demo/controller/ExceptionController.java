package com.example.demo.controller;

import com.example.demo.exception.LoginMyException;
import com.example.demo.exception.ModulViewException;
import com.example.demo.exception.MyException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ExceptionController {

    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
    }

    @RequestMapping("/success")
    public ModelAndView modelview(@PathVariable Integer id) throws MyException{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
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
    public ModelAndView t2(@PathVariable Integer id, HttpServletResponse rq) throws MyException, ModulViewException {
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



    public  void t(){
        System.out.println("this is test commit");
    }
}
