package com.sanzhar.twitter.repository;

import com.sanzhar.twitter.model.Blog;
import com.sanzhar.twitter.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Blog> getUserBlogs(User user) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Blog where user=:user order by post_date desc")
                .setParameter("user", user).list();
    }

    public List<Blog> getBlogsBySearchKey(String key) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Blog where title like :title or content like :content")
                .setParameter("title", "%" + key + "%")
                .setParameter("content", "%" + key + "%").list();
    }

    public Blog getBlogById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Blog.class, id);
    }

    public List<Blog> getAllBlogs() {
        Session session = this.sessionFactory.getCurrentSession();

        return session.createQuery("from Blog order by post_date desc").list();
    }

    public void addBlog(Blog blog) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(blog);
    }

    public void removeBlog(int id) {
        Session session = sessionFactory.getCurrentSession();
        Blog blog = session.load(Blog.class, new Integer(id));

        if(blog != null){
            session.delete(blog);
        }
    }

    public void updateBlog(Blog blog) {
        Session session = sessionFactory.getCurrentSession();
        session.update(blog);
    }


}
