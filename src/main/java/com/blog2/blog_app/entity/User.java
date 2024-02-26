package com.blog2.blog_app.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users",uniqueConstraints = {

        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
   // @Column(unique = true) this is the other way to doing it unique.
    private String username;
    private String email;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles" ,  // this will become table name
    joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id") , // join coloumn is parent for the third table
            inverseJoinColumns =  @JoinColumn(name = "role_id",
            referencedColumnName= "id"))
            private Set<Role> roles;


}
