package com.example.jspreview.controller;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 1. 컴포넌트 스캔에 'Controller'로 잡히게 만들어야한다
// 2. Mapping 설정 -> url 대응
// 3. 어떤 jsp로 응답해줄까 resolver.
@Controller
public class MainController {
    @Value("${google.apikey}")
    private String apiKey;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println(apiKey);
        Client client = Client.builder()
                .apiKey(apiKey)
                .build();
        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash-lite", "오늘 점심 뭐 먹지?", null);
        model.addAttribute("text",  response.text());

        return "index"; // ? WEB-INF 보안경로
    }

}
