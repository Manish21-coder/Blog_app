package com.blog2.blog_app.service.impl;

import com.blog2.blog_app.entity.Post;
import com.blog2.blog_app.exception.ResourceNotFoundException;
import com.blog2.blog_app.payload.PostDto;

import com.blog2.blog_app.repository.PostRepository;
import com.blog2.blog_app.service.postService;
import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class postServiceImpl implements postService {



    private PostRepository repo;

    private ModelMapper modelMapper;
    public postServiceImpl(PostRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createdPost(PostDto postDto) {

        Post post = mapToEntity(postDto);

        Post saved = repo.save(post);

        PostDto dtos = mapToDto(saved);

        return dtos;
    }

    @Override
    public PostDto getPostById(long id) {

      Post post= repo.findById(id).orElseThrow(
              ()->new ResourceNotFoundException("Post not found with id: "+ id )
       );
        PostDto dto  = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());


        return dto;

    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

     Sort sort =   (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        // only in assending order sorting will happen
        PageRequest pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

          Page<Post> pagePost = repo.findAll(pageable);
        List<Post> posts = pagePost.getContent();


        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        return dtos;
    }

    PostDto mapToDto(Post post){
       PostDto dto =  modelMapper.map(post,PostDto.class);

//        PostDto dto  = new PostDto();
//        dto.setId(post.getId());
//        dto.setTitle(post.getTitle());
//        dto.setContent(post.getContent());
//        dto.setDescription(post.getDescription());
          return dto;
    }

    Post mapToEntity(PostDto postDto){

       Post post =  modelMapper.map(postDto, Post.class);
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());

        return post;
    }


    // adding pagination features of data show some records of data at one page
    

}
