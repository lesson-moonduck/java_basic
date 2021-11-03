package com.example.chatbot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatApiController {
    private String selectResponse(String givenSentence) {
        if (givenSentence.contains("안녕")) {
            return "반가워";
        } else if (givenSentence.contains("어디")) {
            return "난 서울 살아";
        } else if (givenSentence.contains("그만")) {
            return "오늘 즐거웠어";
        } else if (givenSentence.contains("꺼져")) {
            return "그.. 그래(총총총)";
        } else {
            return "무슨 말인지 모르겠어 ㅠㅠ '안녕', '어디', '그만', '꺼져'가 포함된 단어만 알아들을 수 있어. 더 똑똑해지도록 노력할게!";
        }
    }

    @CrossOrigin("*")
    @RequestMapping(path="/chat/response", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getResponse(@RequestParam(name="sentence", required=true) String sentence) {
        return selectResponse(sentence);
    }
}
