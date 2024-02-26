package com.blog2.blog_app.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {



    private  String name;
    private String username;
    private String email;
    private String password;

    private String roleType;



}