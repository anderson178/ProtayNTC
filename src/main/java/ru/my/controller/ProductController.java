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

    @GetMapping(value = "/test1")
    public TreeMap<Integer,Product> getTest1() {
        TreeMap<Integer, Product> treeMap = new TreeMap<>();
        Product product1 = new Product(1, "milk");
        Product product2 = new Product(2, "bread");
        Product product3 = new Product(3, "bear");
        treeMap.put(0, product1);
        treeMap.put(2, product2);
        treeMap.put(1, product3);
        return treeMap;
        //return productDAO.getList();
    }

    @GetMapping(value = "/test2")
    public List<Product> getTest2() {
        Product product1 = new Product(1, "milk");
        Product product2 = new Product(2, "bread");
        Product product3 = new Product(3, "bear");
        List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        return list;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody Product product) {
        productDAO.add(product);
        int p = 0;
//        ProductDAO
    }


    //    , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void remove(@RequestBody Product product) {
       // int index = Integer.parseInt(button.replace("\"", "").split("_")[1]);
        productDAO.remove(product);
        int p = 0;
    }

    @RequestMapping(value = "/moveUpProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void moveUp(@RequestBody Product product) {
        productDAO.moveUp(product);
    }

    @RequestMapping(value = "/moveDownProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void moveDown(@RequestBody Product product) {
        productDAO.moveDown(product);
    }

    private int pars(String button) {
        return Integer.parseInt(button.replace("\"", "").split("_")[1]);
    }



}
