package com.sanzhar.twitter.service;


import com.sanzhar.twitter.model.Blog;
import com.sanzhar.twitter.model.User;

import java.util.List;

public interface BlogService {

    public List<Blog> getUserBlogs(User user);
    public List<Blog> getAllBlogs();
    public List<Blog> getBlogsBySearchKey(String key);
    public Blog getBlogById(int id);
    public void addBlog(String title, String content, User user);
    public void removeBlog(int id);
    public void updateBlog(int id, String title, String content);

}
