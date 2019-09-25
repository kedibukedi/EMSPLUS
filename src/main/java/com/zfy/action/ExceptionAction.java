package com.zfy.action;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionAction implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       ModelAndView mv=new ModelAndView();
       if(e instanceof  RuntimeException){
           mv.addObject("message",e.getMessage());
       }
       mv.setViewName("exception");
        return mv;
    }
}
