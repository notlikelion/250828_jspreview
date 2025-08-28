package com.example.jspreview.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 1. 컴포넌트 스캔에 'Controller'로 잡히게 만들어야한다
// 2. Mapping 설정 -> url 대응
// 3. 어떤 jsp로 응답해줄까 resolver.
@Controller
public class MainController {
    @Value("${google.apikey}")
    private String apiKey;

    @GetMapping("/")
    public String index(Model model) {
//        System.out.println(apiKey);
//        Client client = Client.builder()
//                .apiKey(apiKey)
//                .build();
//        GenerateContentResponse response = client.models.generateContent(
//                "gemini-2.5-flash-lite", "다이어트를 위한 점심 식단을 '마크다운 같은 꾸미는 문법 없이' 평문으로 하되, 전문가 느낌이 나게 작성해줘. 100자 이내로.", null);
//        model.addAttribute("text",  response.text());
        model.addAttribute("text", "뭐든지 물어보세요!");

        return "index"; // ? WEB-INF 보안경로
    }

//    @PostMapping("/")
    @PostMapping
    public String index(Model model,
                        @RequestParam("question") String question) {
        Client client = Client.builder()
                .apiKey(apiKey)
                .build();
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash-lite", question, null);
        model.addAttribute("text", response.text());
        return "index"; // 경로는 같은데 전달된 데이터가 다른 jsp
        }
    }
