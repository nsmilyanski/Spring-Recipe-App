package com.springframework.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {
        System.out.println("Some message to say....1234");
        return "index";
    }
}
