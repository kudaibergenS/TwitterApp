package com.sanzhar.twitter.controller;


import com.sanzhar.twitter.model.Blog;
import com.sanzhar.twitter.model.User;
import com.sanzhar.twitter.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;


@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private SimpleDateFormat dateFormat;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String profile(Model model, @RequestAttribute("user") User user){
        model.addAttribute("user", user);
        model.addAttribute("blogs", blogService.getAllBlogs());
        model.addAttribute("dateFormat", dateFormat);

        return "profile";
    }

    @RequestMapping(value = "/myblogs", method = RequestMethod.GET)
    public String userBlogs(Model model, @RequestAttribute("user") User user){
        model.addAttribute("user", user);
        model.addAttribute("blogs", blogService.getUserBlogs(user));
        model.addAttribute("dateFormat", dateFormat);

        return "profile";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchBlogs(@RequestAttribute("user") User user,
                              @RequestParam("key") String key,
                              Model model){
        model.addAttribute("user", user);
        model.addAttribute("blogs", blogService.getBlogsBySearchKey(key));
        model.addAttribute("dateFormat", dateFormat);

        return "profile";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBlogPage(Model model, @RequestAttribute("user") User user){
        model.addAttribute("user", user);

        return "addblog";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBlog(@ModelAttribute("blog") Blog blog, @RequestAttribute("user") User user, Model model){
        if(blog.getId() == 0){
            blogService.addBlog(blog.getTitle(), blog.getContent(), user);
        } else {
            blogService.updateBlog(blog.getId(), blog.getTitle(), blog.getContent());
        }

        return "redirect:/blogs/";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeBlog(@PathVariable("id") int id){
        blogService.removeBlog(id);

        return "redirect:/blogs/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBlog(@PathVariable("id") int id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));

        return "addblog";
    }
}
