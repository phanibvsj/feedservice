package com.example.cts.cde.feedservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cts.cde.feedservice.model.Post;
import com.example.cts.cde.feedservice.model.PostRequest;
import com.example.cts.cde.feedservice.services.PostService;

@RestController
@RequestMapping(path="/posts/")
public class PostController {

	@Autowired
	PostService postService;
	
	@RequestMapping(path="/{userid}",method=RequestMethod.GET)
	public List<Post> getPosts(@PathVariable(name="userid") long userId){
		System.out.println("Requested posts for: " + userId);
		return postService.findByUserId(userId);
	}
	
	@RequestMapping(path="/{userid}",method=RequestMethod.POST)
	public void createPost(@PathVariable(name="userid") long userId, @RequestBody PostRequest request){
		System.out.println("Requested create post for: " + userId);
		postService.createPost(userId, request);
	}
}
