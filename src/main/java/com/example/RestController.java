package com.example;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Андрей on 10/8/2017.
 */

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/test")
    public String intryPoint(){
        return ("It's app");
    }

}
