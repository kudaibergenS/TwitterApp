package com.sanzhar.twitter.controller;

import com.sanzhar.twitter.model.User;
import com.sanzhar.twitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(){

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(){

        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.setAttribute("user", null);

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, HttpSession session, Model model){
        User new_user = userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword());

        if(new_user != null){
            session.setAttribute("user", new_user);

            return "redirect:/blogs/";
        } else {
            model.addAttribute("error_msg", "Incorrect login or password");

            return "login";
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpPage(){

        return "registration";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("user") User user,
                         @RequestParam("repeat_password") String repeat_password,
                         HttpSession session,
                         Model model){
        if(user.getFirstname().equals("") ||
                user.getLastname().equals("") ||
                user.getLogin().equals("") ||
                user.getPassword().equals("")){

            model.addAttribute("error_msg", "All fields must be filled");
            return "registration";
        } else {
            if(user.getPassword().equals(repeat_password)){
                if(userService.getUserByLogin(user.getLogin()) != null){

                    model.addAttribute("error_msg", "This login is already taken");
                    return "registration";
                } else {
                    userService.addUser(user);
                    session.setAttribute("user", user);

                    return "redirect:/blogs/";
                }
            } else {

                model.addAttribute("error_msg", "Password do not match");
                return "registration";
            }
        }

    }
}
