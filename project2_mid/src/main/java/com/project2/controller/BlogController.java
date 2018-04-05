package com.project2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project2.Dao.BlogDao;
import com.project2.Model.Blog;

@RestController
public class BlogController {

	
	@Autowired
	BlogDao blogDao;
	
	@PostMapping(value="/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreatedDate(new java.util.Date());
		blog.setUsername("Nithya");
		blog.setStatus("A");
		System.out.println("Rest Controller Blog Invoked!!!");
		if(blogDao.insertBlog(blog))
			
		return new ResponseEntity<String>("Success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping(value="/listBlog")
	public ResponseEntity<List<Blog>> listBlog()
	{
		List<Blog> list=blogDao.listBlog("Nithya");
		if(list.size()>0)
			return new ResponseEntity<List<Blog>>(list,HttpStatus.OK);
		else
			return new ResponseEntity<List<Blog>>(list,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value="/delBlog/{id}")
	public ResponseEntity<String> deleteBlog(@PathVariable("id") int blogId)
	{
		Blog blog=blogDao.getBlog(blogId);
		boolean b=blogDao.deleteBlog(blog);
		if(b)
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		
	}
	
}