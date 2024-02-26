package com.blog2.blog_app.controller;


import com.blog2.blog_app.payload.CommentDto;
import com.blog2.blog_app.service.CommentService;
import com.blog2.blog_app.service.impl.CommentServiceImpl;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {


      private CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/posts?pageNo=0&pageSize=&sortBy=title&sortDir=desc
    //http://localhost:8080/api/comments?postId=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @RequestParam long postId){

                        CommentDto dto= commentService.createComment(commentDto,postId);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){

        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is Deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable long id,@RequestBody CommentDto commentDto ,@PathVariable long postId){

        CommentDto dto = commentService.updateComment(id, commentDto,postId);

        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
