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

@RestController
@RequestMapping("/")
public class ProductController {


    private ProductDAO productDAO = new ProductDAO();

    @GetMapping(value = "/getAll")
    public List<Product> getStr() {
//        List<Product> list = new ArrayList<>();
//        list.add(new Product(1, "bread"));
//        list.add(new Product(2, "tea"));
//        list.add(new Product(3, "milk"));
//        list.add(new Product(4, "meat"));
//        list.add(new Product(5, "bear"));
        return productDAO.getList();
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody Product product) {
        productDAO.add(product);
        int p = 0;
//        ProductDAO
    }


    //    , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    @RequestMapping(value = "/removeProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void remove(@RequestBody String button) {
        int index = Integer.parseInt(button.replace("\"", "").split("_")[1]);
        productDAO.remove(index);
        int p = 0;
    }

    @RequestMapping(value = "/moveUpProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void moveUp(@RequestBody String button) {
        productDAO.moveUp(pars(button));
    }

    @RequestMapping(value = "/moveDownProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void moveDown(@RequestBody String button) {
        productDAO.moveDown(pars(button));
    }

    private int pars(String button) {
        return Integer.parseInt(button.replace("\"", "").split("_")[1]);
    }
}
