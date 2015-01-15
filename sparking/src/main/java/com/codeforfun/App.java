package com.codeforfun;

import com.codeforfun.model.Post;
import com.codeforfun.service.Blog;
import com.google.gson.Gson;
import spark.Spark;

public class App {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Blog blog = new Blog();

        Spark.get("/posts", (request, response) -> {
        	response.header("Access-Control-Allow-Origin", "*");
            return gson.toJson(blog);
        });
        
        Spark.options("/posts", (request, response) -> {
        	response.header("Access-Control-Allow-Origin", "*");
        	response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        	return "";
        });
        
        Spark.post("/posts", (request, response) -> {
        	response.header("Access-Control-Allow-Origin", "*");
            Post post = new Post();
            post.setAuthor(request.queryParams("author"));
            post.setTitle(request.queryParams("title"));
            post.setContent(request.queryParams("content"));
            post.setDate(Long.parseLong(request.queryParams("date")));
            blog.add(post);
            return "";
        });

        Spark.get("/posts/:postid", (request, response) -> {
        	response.header("Access-Control-Allow-Origin", "*");
            return gson.toJson(blog.get(Integer.parseInt(request.params(":postid"))));
        });
        
        Spark.delete("/posts/:postid", (request, response) -> {
        	response.header("Access-Control-Allow-Origin", "*");
            String id = request.params(":postid");
            blog.delete(Integer.parseInt(id));
            return "";
        });
    }
}
