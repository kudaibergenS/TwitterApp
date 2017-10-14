package com.sanzhar.twitter.service;

import com.sanzhar.twitter.model.Blog;
import com.sanzhar.twitter.model.User;
import com.sanzhar.twitter.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public List<Blog> getUserBlogs(User user) {

        return blogRepository.getUserBlogs(user);
    }

    @Transactional
    public List<Blog> getAllBlogs() {

        return blogRepository.getAllBlogs();
    }

    @Transactional
    public List<Blog> getBlogsBySearchKey(String key) {
        return blogRepository.getBlogsBySearchKey(key);
    }

    @Transactional
    public void addBlog(String title, String content, User user) {
        Blog blog = new Blog();

        blog.setTitle(title);
        blog.setContent(content);
        blog.setPost_date(new Date());
        blog.setUser(user);
        blog.setActive(1);

        blogRepository.addBlog(blog);
    }

    @Transactional
    public Blog getBlogById(int id) {

        return blogRepository.getBlogById(id);
    }

    @Transactional
    public void removeBlog(int id) {
        blogRepository.removeBlog(id);
    }

    @Transactional
    public void updateBlog(int id, String title, String content) {
        Blog blog = blogRepository.getBlogById(id);
        if(blog != null){
            blog.setTitle(title);
            blog.setContent(content);

            blogRepository.updateBlog(blog);
        }
    }

}
