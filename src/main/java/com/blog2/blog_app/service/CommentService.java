package com.blog2.blog_app.service;

import com.blog2.blog_app.payload.CommentDto;
import org.springframework.stereotype.Service;


public interface CommentService {

   CommentDto createComment(CommentDto commentDto,long postId);

    void deleteComment(long id);
}
