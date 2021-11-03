package com.example.chatbot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatApiController {

    @GetMapping("/chat/response")
    public String getResponse(@RequestParam(name = "sentence", required = true) String sentence) {
        if (sentence.startsWith("안녕")) {
            return "반가워";
        } else if (sentence.startsWith("어디")) {
            return "난 서울 살아";
        } else if (sentence.startsWith("그만")) {
            return "오늘 즐거웠어";
        } else {
            return "무슨 말인지 모르겠어 ㅠㅠ '안녕', '어디', '그만'으로 시작하는 단어만 알아들을 수 있어. 더 똑똑해지도록 노력할게!";
        }
    }
}
