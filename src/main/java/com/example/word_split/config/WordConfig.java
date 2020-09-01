package com.example.word_split.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tencent.ai.texsmart.NluEngine;

import javax.annotation.PostConstruct;

/**
 * @author wll
 * @Description
 * @create 2020-08-07 19:55
 */
@Component
public class WordConfig {

//    @Value("${data.path}")
//    private String dataDir;

//    @PostConstruct
    @Bean
    public static NluEngine init() {
        System.out.println("初始化自定义词库--开始");
//        String dataDir = "/opt/wkitchen/word_split/data/nlu/kb";
        String dataDir = "E:/code/word_test/data/nlu/kb";
        System.out.println(dataDir);

        System.out.println("Creating and initializing the NLU engine...");
        NluEngine engine = new NluEngine();
        int workerCount = 4;
        boolean ret = engine.init(dataDir, workerCount);
        if (!ret) {
            System.out.println("Failed to initialize the engine");
            return null;
        }
        System.out.println("初始化自定义词库--结束");
        return engine;
    }
}
