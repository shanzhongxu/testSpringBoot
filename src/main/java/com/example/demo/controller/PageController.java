package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @ResponseBody
    @RequestMapping("/indexStr")
    public String index(){
        return "indexStr";
    }

    @ResponseBody
    @RequestMapping("/indexMv")
    public ModelAndView indexMv(){
        return new ModelAndView("index");
    }

    @RequestMapping(value="/indexpage",method= RequestMethod.GET)
    public String indexpage(Model model){
        model.addAttribute("sb", "this is EL");
        return "index";
    }

    @ResponseBody
    @RequestMapping(value="/toJson",method= RequestMethod.GET,
            produces={ "application/json;charset=UTF-8" })
    public R indexpage(){
        R r= new R();
        r.setCode("0000");
        r.setMsg("Is Ok!");
        return r;
    }

    @RequestMapping(value="/tocTag",method= RequestMethod.GET)
    public String cTag(){
        return "cTag";
    }


    public class R{
        public String code ;
        public String msg;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
