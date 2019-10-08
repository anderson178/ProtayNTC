package ru.my.controller;


import org.springframework.web.bind.annotation.*;
import ru.my.model.Product;
import ru.my.model.ProductDAO;

import java.util.List;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.10.2019
 */
@RestController
@RequestMapping("/")
public class ProductController {
    private ProductDAO productDAO = new ProductDAO();

    /**
     * Метод запроса получения всех элементов в хранилище
     *
     * @return - входящий объект (Product)
     */
    @GetMapping(value = "/getAll")
    public List<Product> getAll() {
        return productDAO.getList();
    }

    /**
     * Метод добавления элемента в хранилище
     *
     * @param product - входящий объект (Product)
     */
    @RequestMapping(value = "/addProduct")
    public void add(@RequestBody Product product) {
        productDAO.add(product);
    }

    /**
     * Метод удаления продукта из хранилища
     *
     * @param product - входящий объект (Product)
     */
    @PostMapping(value = "/removeProduct")
    public void remove(@RequestBody Product product) {
        productDAO.remove(product);
    }

    /**
     * Метод перемещения элемента на одну позицию выше
     *
     * @param product - входящий объект (Product)
     */
    @PostMapping(value = "/moveUpProduct")
    public void moveUp(@RequestBody Product product) {
        productDAO.moveUp(product);
    }

    /**
     * Метод перемещения элемента на одну позицию ниже
     *
     * @param product - входящий объект (Product)
     */
    @PostMapping(value = "/moveDownProduct")
    public void moveDown(@RequestBody Product product) {
        productDAO.moveDown(product);
    }

    /**
     * Метод сортировки элементов в хранилище
     */
    @PostMapping(value = "/sortProduct")
    public void sortProduct() {
        productDAO.sort();
    }


}
