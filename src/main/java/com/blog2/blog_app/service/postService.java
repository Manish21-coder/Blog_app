package com.blog2.blog_app.service;


import com.blog2.blog_app.payload.PostDto;

import java.util.List;

public interface postService {

   public  PostDto createdPost(PostDto postDto);

    public PostDto getPostById(long id);

    List<PostDto> getAllPosts(int pageNo, int no, String sortBy, String sortDir);
}
