package com.example.word_split.controller;

import com.example.word_split.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wll
 * @Description
 * @create 2020-08-07 19:52
 */
@RestController
public class WordSplitController {

    @Autowired
    private WordService wordService;

    @GetMapping(value = "/split")
    public void split() {
        wordService.split();
    }

    @GetMapping(value = "/splitOne")
    public Object splitOne(@RequestParam(value = "title") String title) {
        return wordService.splitOne(title);
    }

}
