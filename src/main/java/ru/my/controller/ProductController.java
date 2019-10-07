package ru.my.controller;


import org.springframework.web.bind.annotation.*;
import ru.my.model.Product;
import ru.my.model.ProductDAO;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
    private ProductDAO productDAO = new ProductDAO();

    @GetMapping(value = "/getAll")
    public List<Product> getAll() {
        return productDAO.getList();
    }

    @RequestMapping(value = "/addProduct")
    public void add(@RequestBody Product product) {
        productDAO.add(product);
    }

    @PostMapping(value = "/removeProduct")
    public void remove(@RequestBody Product product) {
        productDAO.remove(product);
    }

    @PostMapping(value = "/moveUpProduct")
    public void moveUp(@RequestBody Product product) {
        productDAO.moveUp(product);
    }

    @PostMapping(value = "/moveDownProduct")
    public void moveDown(@RequestBody Product product) {
        productDAO.moveDown(product);
    }

    @PostMapping(value = "/sortProduct")
    public void sortProduct() {
        productDAO.sort();
    }


}
