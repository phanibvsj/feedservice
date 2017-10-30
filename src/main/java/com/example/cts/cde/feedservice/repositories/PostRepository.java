package com.example.cts.cde.feedservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.example.cts.cde.feedservice.domain.Post;

public interface PostRepository extends Repository<Post, Long>{
	
	List<Post> findByUserId(long userId);
	@Query("SELECT p FROM Post p where p.userId = :userId and p.postId = :postId") 
	Post findByUserIdAndPostId(@Param("userId") long userId, @Param("postId") long postId);
	void save(Post post);
}
