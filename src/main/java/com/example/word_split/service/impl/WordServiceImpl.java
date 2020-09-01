package com.example.word_split.service.impl;

import com.example.word_split.service.WordService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tencent.ai.texsmart.NluEngine;
import tencent.ai.texsmart.NluOutput;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wll
 * @Description
 * @create 2020-08-07 19:54
 */
@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private NluEngine nluEngine;

    @Override
    public void split() {

        FileInputStream fileInputStream = null;
        try {
//            String name = "C:\\Users\\13162\\Desktop\\标题示例.xlsx";
            String name = "C:\\Users\\13162\\Desktop\\分词测试标题-新旧策略-20200804.xlsx";
            fileInputStream = new FileInputStream(name);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            XSSFSheet sheet = sheets.getSheetAt(1);
            Boolean flag = true;
            int row = 0;
            while (flag) {
                row++;
                XSSFRow row1 = sheet.getRow(row);
                if (sheet.getRow(row) == null) {
                    break;
                }
                String cell = row1.getCell(1).toString();
                print(cell);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String splitOne(String title) {
        return print(title);
    }

    public String print(String text) {
        String options = "{\"ner\":{\"enable\":true,\"fine_grained\":true}}";
//        System.out.println("=======");
//        String text = "网红李子柒，伊能静，言承旭，迪丽热巴，昨晚lolita看了一部电视剧叫做【向往的生活】未定的注定 翻唱【未定事件簿】，优衣库女主角,波比跳一晚上";
        NluOutput output = nluEngine.parseText(text, options);
//        System.out.println("命名实体识别（NER）:");
        Set<String> set = new HashSet<>();
        //ent.type.name  命名实体
        set.add("time.generic");
        set.add("quantity.generic");
        set.add("person.generic");
        set.add("work.broadcast_program");
        set.add("loc.country_region");
        Set<String> result = new HashSet<String>();
//        for (NluOutput.Entity ent : output.entities()) {
////            if (!set.contains(ent.type.name) || ent.str.length() < 2) {
////                continue;
////            }
//            System.out.printf("\t%s\t(%d,%d)\t%s\t%s\n", ent.str, ent.offset, ent.len, ent.type.name, ent.meaning);
//            result.add(ent.str);
//        }
        System.out.println(text);
        System.out.println("粗粒度分词:");
        for (NluOutput.Term phrase : output.phrases()) {
            System.out.printf("\t%s\t(%d,%d)\t%s\n", phrase.str, phrase.offset, phrase.len, phrase.tag);
        }

        System.out.println("命名实体识别（NER）:");
        for (NluOutput.Entity ent : output.entities()) {
            System.out.printf("\t%s\t(%d,%d)\t%s\t%s\n", ent.str, ent.offset, ent.len, ent.type.name, ent.meaning);
            result.add(ent.str);
        }
        String str = StringUtils.join(result.toArray(), ",");
        System.out.println(str);
        return str;
    }


}
