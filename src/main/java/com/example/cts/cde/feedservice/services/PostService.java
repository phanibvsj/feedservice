package com.example.cts.cde.feedservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cts.cde.feedservice.model.Post;
import com.example.cts.cde.feedservice.model.PostRequest;

@Service
public interface PostService {

	void createPost(long userId, PostRequest postRequest);
	List<Post> findByUserId(long userId);
	List<Post> findByUserIdAndPostId(long userId, long postId);
}
