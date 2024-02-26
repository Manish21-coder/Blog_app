package com.blog2.blog_app.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErroDetails {

    private String message;

    private Date date;

    private String uri;
}
