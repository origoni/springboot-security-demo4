package com.millky.demo.security.four;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
public class UserSessionInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        log.debug("request.getRequestURI() = {}; authentication = {}; ", request.getRequestURI(), authentication);

        if (authentication != null) {
            String currentPrincipalName = authentication.getName();
            if (!currentPrincipalName.equals("anonymousUser")) {
//            if (authentication.isAuthenticated()) {
                User user = (User) authentication.getPrincipal();
                request.setAttribute("_USER", user);
            }
        }

        return true;
    }
}
