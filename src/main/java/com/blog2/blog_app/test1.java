package com.blog2.blog_app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


import static java.util.ArrayList.*;

public class test1 {
//    $2a$10$pNP5GtmPjHBaSepR7aBlVOmL03OKSOHTRDzE2jx4FGKANa6WV2buK


    public static void main(String []args) {

//        Predicate<Integer> evenNumber = a->a%2==0;
//        boolean test = evenNumber.test(11);
//        System.out.println(test);

//           List<String> value = Arrays.asList("Smeit","terankula","mike","Songs","ecommers");
//              List<String> data = value.stream().filter(a->a.startsWith("S")).collect(Collectors.toList());
//                List<String> data1=   value.stream().filter(a->a.contains("e")).collect(Collectors.toList());
//
//              System.out.println(data);
//              System.out.println(data1);

        //  System.out.println(new Random().nextInt(300));
//        Supplier<Integer> x=()->new Random().nextInt(100);
//        Integer y = x.get();
//         System.out.println(y);


        // grouping by

//        List<Login> logins = Arrays.asList(
//                new Login("mannish","kumar"),
//                new Login("vijay","test")
//
//
//        );
//
//        //System.out.println(logins);
//
//        List<LoginDto> dtoos = logins.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
//
//System.out.println(dtoos);
//    }
//
//    static LoginDto mapToDto(Login login){
//        LoginDto dto = new LoginDto();
//        dto.setUserName(login.getUserName());
//        dto.setPassword(login.getPassword());
//        return dto;
//    }


          PasswordEncoder passwordEncoder =new  BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("Testing"));
//        System.out.println(passwordEncoder.upgradeEncoding("Testing"));

    }


}
