package com.example.jspreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 1. 컴포넌트 스캔에 'Controller'로 잡히게 만들어야한다
// 2. Mapping 설정 -> url 대응
// 3. 어떤 jsp로 응답해줄까 resolver.
@Controller
public class MainController {
    // ?
    @GetMapping("/")
    public String index() {
        return "index"; // ? WEB-INF 보안경로
    }
}
