package com.example.word_split.service;

/**
 * @author wll
 * @Description
 * @create 2020-08-07 19:54
 */
public interface WordService {
    /**
     * split
     */
    void split();

    /**
     * splitOne
     *
     * @param title
     * @return
     */
    String splitOne(String title);
}
