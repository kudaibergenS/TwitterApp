package com.sanzhar.twitter.util;


import com.sanzhar.twitter.model.User;
import com.sanzhar.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User current_user = this.getCurrentUser(request);

        if(current_user != null){
            request.setAttribute("user", current_user);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

        return true;
    }

    public User getCurrentUser(HttpServletRequest request){
        User current_user = null;
        User session_user = (User) request.getSession().getAttribute("user");

        if(session_user != null){
            current_user = this.userService
                    .getUserByLoginAndPassword(session_user.getLogin(), session_user.getPassword());
        }

        return current_user;
    }

}
