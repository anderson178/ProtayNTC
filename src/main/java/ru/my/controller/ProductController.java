package ru.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.my.model.Product;
import ru.my.model.ProductDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@RestController
@RequestMapping("/")
public class ProductController {


    private ProductDAO productDAO = new ProductDAO();

    @GetMapping(value = "/getAll")
    public List<Product> getStr() {
        return productDAO.getList();
    }



    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody Product product) {
        productDAO.add(product);
    }


    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void remove(@RequestBody Product product) {
        productDAO.remove(product);
    }

    @RequestMapping(value = "/moveUpProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void moveUp(@RequestBody Product product) {
        productDAO.moveUp(product);
    }

    @RequestMapping(value = "/moveDownProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void moveDown(@RequestBody Product product) {
        productDAO.moveDown(product);
    }

//    private int pars(String button) {
//        return Integer.parseInt(button.replace("\"", "").split("_")[1]);
//    }



}
