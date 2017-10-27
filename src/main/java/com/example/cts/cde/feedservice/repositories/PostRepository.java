package com.example.cts.cde.feedservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.cts.cde.feedservice.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long>{
	
	List<Post> findByUserId(long userId);
	
}
