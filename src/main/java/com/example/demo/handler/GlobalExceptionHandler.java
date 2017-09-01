package com.example.demo.handler;

import com.example.demo.ErrorInfo.ErrorInfo;
import com.example.demo.exception.LoginMyException;
import com.example.demo.exception.ModulViewException;
import com.example.demo.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/5/17.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MyException.class})
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMsg());
        r.setCode(e.getCode());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    @ExceptionHandler(value = {LoginMyException.class})
    @ResponseBody
    public ErrorInfo<String> loginErrorHandler(HttpServletRequest req, LoginMyException e) {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMsg());
        r.setCode(e.getCode());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ErrorInfo<String> nullpinterHandler(HttpServletRequest req, NullPointerException e)  {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("NullPointerException");
        r.setCode(0);
        r.setData("nullpinterHandler");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    public static final String DEFAULT_ERROR_VIEW = "error";




}
