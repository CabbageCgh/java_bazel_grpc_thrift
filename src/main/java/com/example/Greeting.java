package com.example;

import com.example.model.User;
import com.example.thrift.gencode.HelloService;
import com.google.gson.Gson;

public class Greeting {

    public static void sayHi() {
        Gson gson = new Gson();

        HelloService helloService = new HelloService();

        User user = new User();
        user.setId(1);
        user.setName("Mr.Zhang");

        System.out.println(gson.toJson(user));
        System.out.println("Hi!");
    }

}
