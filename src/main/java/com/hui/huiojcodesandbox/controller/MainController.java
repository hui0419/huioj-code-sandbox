package com.hui.huiojcodesandbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王程辉
 * @date 2024/10/08 11:45
 */
@RestController("/")
public class MainController {
    @GetMapping("/health")
    public String healthCheck(){
        return "ok";
    }
}
