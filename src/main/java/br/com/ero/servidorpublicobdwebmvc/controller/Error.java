package br.com.ero.servidorpublicobdwebmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Error implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest){
        Object status = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                // Tratar erro 404 (Not Found)
                return "/erro/404";

            }else  if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                // Tratar erro 500 (Internal Server Error)
                return  "/erro/500";
            }
        }
        return "error";
    }

    public String getErrorPath(){
        return "/error";
    }
}
