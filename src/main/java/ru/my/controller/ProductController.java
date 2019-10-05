package ru.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void add(@RequestBody Product product) {
//        ProductDAO
    }
}
