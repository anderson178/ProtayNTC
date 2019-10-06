package ru.my.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.my.model.Product;

import java.util.Map;

@Controller
//@PropertySource(value = "classpath:application.properties", encoding = "ISO-8859-1")
public class MainController {
    @Value("${nametable}")
    private String nametable;

    @Value("${namefirstcol}")
    private String nameFirstCol;

    @Value("${namesecondcol}")
    private String nameSecondCol;

    @RequestMapping("/")
    public String getMainPage(Map<String, Object> map) {
        map.put("1", nametable);
        map.put("2", nameFirstCol);
        map.put("3", nameSecondCol);
        return "index";
    }
}
