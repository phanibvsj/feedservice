package com.example.cts.cde.feedservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cts.cde.feedservice.domain.Post;
import com.example.cts.cde.feedservice.model.PostRequest;
import com.example.cts.cde.feedservice.repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;
	
	@Override
	public void createPost(long userId, PostRequest postRequest) {
		Post post = new Post();
		post.setUserId(userId);
		post.setPostType(postRequest.getPostType());
		post.setPostTitle(postRequest.getPostTitle());
		post.setPostContent(postRequest.getPostContent());
		post.setCreatedDate(new Date());
		postRepository.save(post);
	}

	@Override
	public List<com.example.cts.cde.feedservice.model.Post> findByUserId(long userId) {
		List<Post> postLst = postRepository.findByUserId(userId);
		List<com.example.cts.cde.feedservice.model.Post> posts = new ArrayList<>();
		for( Post post : postLst){
			com.example.cts.cde.feedservice.model.Post model = new com.example.cts.cde.feedservice.model.Post();
			model.setUserId(post.getUserId());
			model.setPostTitle(post.getPostTitle());
			model.setPostContent(post.getPostContent());
			model.setPostType(post.getPostType());
			model.setCreatedDate(post.getCreatedDate());
			posts.add(model);
		}
		return posts;
	}
	
	@Override
	public List<com.example.cts.cde.feedservice.model.Post> findByUserIdAndPostId(long userId, long postId) {
		Post post = postRepository.findByUserIdAndPostId(userId, postId);
		List<com.example.cts.cde.feedservice.model.Post> posts = new ArrayList<>();
		if ( post != null ){
			com.example.cts.cde.feedservice.model.Post model = new com.example.cts.cde.feedservice.model.Post();
			model.setUserId(post.getUserId());
			model.setPostTitle(post.getPostTitle());
			model.setPostContent(post.getPostContent());
			model.setPostType(post.getPostType());
			model.setCreatedDate(post.getCreatedDate());
			posts.add(model);
		}
		
		return posts;
	}

}
