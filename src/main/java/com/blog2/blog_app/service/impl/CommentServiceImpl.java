package com.blog2.blog_app.service.impl;

import com.blog2.blog_app.entity.Comment;
import com.blog2.blog_app.entity.Post;
import com.blog2.blog_app.exception.ResourceNotFoundException;
import com.blog2.blog_app.payload.CommentDto;
import com.blog2.blog_app.repository.CommentRepository;
import com.blog2.blog_app.repository.PostRepository;
import com.blog2.blog_app.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {


    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {

      Post post =  postRepository.findById(postId).orElseThrow(

               ()-> new ResourceNotFoundException("Post not found with id:"+ postId)
       );


        Comment comment = new Comment();

        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());

        comment.setPost(post);

       Comment savedComment =  commentRepository.save(comment);

       CommentDto dto = new CommentDto();
       dto.setId(savedComment.getId());
       dto.setEmail(savedComment.getEmail());
       dto.setText(savedComment.getText());

        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post not found with id: " + postId)
        );


        Comment find = commentRepository.findById(id).orElseThrow(

                ()-> new ResourceNotFoundException("Comment Not found" + id)

        );


             Comment c =  mapToEntity(commentDto);
                     c.setId(find.getId());
                     c.setPost(post);




        Comment savedComment = commentRepository.save(c);
        return mapToDto(savedComment);
    }


    CommentDto mapToDto(Comment comment){

        CommentDto dto = modelMapper.map(comment, CommentDto.class);

        return  dto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);

        return  comment;
    }


}
