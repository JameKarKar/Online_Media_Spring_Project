package com.services;

import com.daos.PostDao;
import com.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostDao postDao;

    public void savePosts(Post post){
        postDao.savePost(post);
    }

    public List<Post> getAllPosts(){
       return postDao.getAllPost();
    }

    public Post getPostsById(int id){
        return postDao.getPostById(id);
    }

    public void updatePosts(Post post){
        postDao.updatePost(post);
    }

    public void deletePost(int id){
        postDao.postDelete(id);
    }
}
