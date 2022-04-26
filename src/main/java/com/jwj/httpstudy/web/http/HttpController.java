package com.jwj.httpstudy.web.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
@Controller
public class HttpController {

    @GetMapping("/httpForm")
    public String httpForm(){
        return "http/httpForm";
    }

    @PostMapping("/httpHeaders")
    public String httpHeaders(HttpServletRequest request, HttpServletResponse response){
        Enumeration<String> headerNames = request.getHeaderNames();

        log.info("=================");
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            log.info("header {}", headerName + ":" + request.getHeader(headerName));
        }
        log.info("=================");

        return "http/httpForm";
    }
}
