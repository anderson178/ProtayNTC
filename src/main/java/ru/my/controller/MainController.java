package ru.my.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.my.model.Product;

import java.util.Map;
/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.10.2019
 */
@Controller
public class MainController {
    @Value("${nametable}")
    private String nametable;

    @Value("${namefirstcol}")
    private String nameFirstCol;

    @Value("${namesecondcol}")
    private String nameSecondCol;

    @Value("${namethirdcol}")
    private String nameThirdCol;

    @Value("${namebuttonadd}")
    private String nameButtonAdd;

    @Value("${namebuttonsort}")
    private String nameButtonSort;

    @RequestMapping("/")
    public String getMainPage(Map<String, Object> map) {
        map.put("nameTable", nametable);
        map.put("nameFirstCol", nameFirstCol);
        map.put("nameSecondCol", nameSecondCol);
        map.put("nameThirdCol", nameThirdCol);
        map.put("nameButtonAdd", nameButtonAdd);
        map.put("nameButtonSort", nameButtonSort);

        return "index";
    }
}
