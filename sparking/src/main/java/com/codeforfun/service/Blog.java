package com.codeforfun.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.codeforfun.model.Post;

public class Blog {
	
	private List<Post> posts = new ArrayList<Post>();
	private transient int nextPostId = 0;
	
	public void add(Post post) {
		post.setId(nextPostId++);
		posts.add(post);
	}
	
	public void update(Post post) {
		List<Post> existingPosts = posts.stream().filter( item -> item.getId() == post.getId() ).collect(Collectors.toList());
		if(existingPosts.size() > 0) {
			posts.remove(existingPosts.get(0));
			posts.add(post);
		}
		else {
			throw new RuntimeException("Cannot find element to update");
		}
	}
	
	public void delete(int id) {
		List<Post> existingPosts = posts.stream().filter( item -> item.getId() == id ).collect(Collectors.toList());
		if(existingPosts.size() > 0) {
			posts.remove(existingPosts.get(0));
		}
		else {
			throw new RuntimeException("Cannot find element to delete");
		}
	}
	
	public Post get(int id) {
		List<Post> existingPosts = posts.stream().filter( item -> item.getId() == id ).collect(Collectors.toList());
		if(existingPosts.size() > 0) {
			return existingPosts.get(0);
		}
		else {
			throw new RuntimeException("Cannot find element");
		}
	}
	
	public List<Post> getAll() {
		return posts;
	}
	
	public void clear() {
		posts.clear();
	}

}
