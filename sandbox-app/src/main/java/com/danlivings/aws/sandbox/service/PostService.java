package com.danlivings.aws.sandbox.service;

import com.danlivings.aws.sandbox.entity.Post;
import com.danlivings.aws.sandbox.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostService {

    private final PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getPosts() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Post::getPostedAt))
                .collect(Collectors.toList());
    }

    public void addPost(Post post) {
        repository.save(post);
    }
}
