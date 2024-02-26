package com.blog2.blog_app.controller;


import com.blog2.blog_app.payload.PostDto;
import com.blog2.blog_app.service.postService;
import javax.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class postController {

    private postService service;

    public postController(postService service) {
        this.service = service;
    }

//    @PreAuthorize("hasRole('ADMIN')")  // only admin can access posting features if you login as user you are not able to access
@PostMapping
public ResponseEntity<?> createPost(@RequestBody PostDto postDto){

      PostDto dto =  service.createdPost(postDto);

    return new ResponseEntity<>(dto, HttpStatus.CREATED);
}

//https://localhost:8080/api/posts/all?id=1
    @GetMapping("/all")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){

        PostDto dto = service.getPostById(id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }



    //http://localhost:8080/api/posts?pageNo=0&pageSize=&sortBy=title&sortDir=desc
    @GetMapping
    public List<PostDto> getAllPosts(

            @RequestParam(name = "pageNo", required = false,defaultValue = "0" ) int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir", required = false, defaultValue = "id") String sortDir
    ){

        List<PostDto> postDtos = service.getAllPosts(pageNo,pageSize,sortBy,sortDir);

        return postDtos;
    }




}
