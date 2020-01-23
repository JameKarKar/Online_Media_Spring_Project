package com.daos;

import com.models.Post;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostDao {

    void savePost(Post post);

    List<Post> getAllPost();

    Post getPostById(int id);

    void updatePost(Post post);

    void postDelete(int id);

}
