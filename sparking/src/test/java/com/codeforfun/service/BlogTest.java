package com.codeforfun.service;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.codeforfun.model.Post;

public class BlogTest {
	
	Blog blog = new Blog();
	
	private long getCurrentTimestamp() {
		return (new Date()).getTime();
	}
	
	@Before
	public void setUp() {
		blog.clear();
	}
	
	@Test
	public void testAdd() {
		Post post = new Post();
		post.setTitle("title");
		post.setAuthor("author");
		post.setDate(getCurrentTimestamp());
		post.setContent("content");
		
		blog.add(post);
		assertTrue(post.getId() >= 0);
		
		List<Post> allPosts = blog.getAll();
		assertTrue(allPosts.size() == 1);
	}

	@Test
	public void testUpdate() {
		Post post = new Post();
		post.setTitle("title");
		post.setAuthor("author");
		post.setDate(getCurrentTimestamp());
		post.setContent("content");
		blog.add(post);
		
		post.setTitle("updated");
		blog.update(post);
		
		List<Post> allPosts = blog.getAll();
		assertTrue(allPosts.size() == 1);
		Post updatedPost = allPosts.get(0);
		
		assertEquals(updatedPost, post);
	}

	@Test
	public void testDelete() {
		Post post = new Post();
		post.setTitle("title");
		post.setAuthor("author");
		post.setDate(getCurrentTimestamp());
		post.setContent("content");
		blog.add(post);
		
		assertTrue(blog.getAll().size() == 1);
		blog.delete(post.getId());
		assertTrue(blog.getAll().size() == 0);
	}

	@Test
	public void testGet() {
		Post post = new Post();
		post.setTitle("title");
		post.setAuthor("author");
		post.setDate(getCurrentTimestamp());
		post.setContent("content");
		blog.add(post);
		
		Post taken = blog.get(post.getId());
		assertEquals(post, taken);
	}

	@Test
	public void testGetAll() {
		Post post1 = new Post();
		post1.setTitle("title1");
		post1.setAuthor("author1");
		post1.setDate(getCurrentTimestamp());
		post1.setContent("content1");
		blog.add(post1);
		Post post2 = new Post();
		post2.setTitle("title2");
		post2.setAuthor("author2");
		post2.setDate(getCurrentTimestamp());
		post2.setContent("content2");
		blog.add(post2);
		
		List<Post> allPosts = blog.getAll();
		assertEquals(2, allPosts.size());
		assertThat(allPosts, hasItems(post1, post2));
	}

}
