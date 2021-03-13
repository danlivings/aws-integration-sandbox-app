package com.danlivings.aws.sandbox.repository;

import com.danlivings.aws.sandbox.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends CrudRepository<Post, UUID> {
}
