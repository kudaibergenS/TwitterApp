package com.sanzhar.twitter.repository;


import com.sanzhar.twitter.model.Blog;
import com.sanzhar.twitter.model.User;

import java.util.List;

public interface BlogRepository {

    public List<Blog> getAllBlogs();
    public List<Blog> getUserBlogs(User user);
    public List<Blog> getBlogsBySearchKey(String key);
    public Blog getBlogById(int id);
    public void removeBlog(int id);
    public void updateBlog(Blog blog);
    public void addBlog(Blog blog);

}
