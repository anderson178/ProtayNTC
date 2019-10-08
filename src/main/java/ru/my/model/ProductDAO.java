package ru.my.model;


import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Денис Мироненко
 * @version $Id$
 * @since 08.10.2019
 */
public class ProductDAO implements DAO {

    private List<Product> products = new ArrayList<>();

    /**
     * Метод доабвления элемента в коллекцию
     *
     * @param product - объект Product
     */
    @Override
    public void add(Product product) {
        int index = indexOf(product);
        if (index == -1) {
            products.add(product);
        } else {
            products.get(index).setName(product.getName());
        }

    }

    /**
     * Метод удаления элемента из коллекции
     *
     * @param product - объект Product
     */
    @Override
    public void remove(Product product) {
        products.remove(product);
    }

    /**
     * Метод получения индекса элемента в коллекции по его номеру позиции
     *
     * @param product - элемент Product
     * @return - если найден. то вернет валидный индекс иначе -1
     */
    private int indexOf(Product product) {
        return IntStream.range(0, products.size())
                .filter(i -> products.get(i).getPosition().equals(product.getPosition()))
                .findFirst()
                .orElse(-1);
    }

    /**
     * Метод перемещения элемента на позицию выше
     *
     * @param product - элемент Product
     */
    @Override
    public void moveUp(Product product) {
        int index = this.indexOf(product);
        if (index > 0) {
            this.changeProducts(index, index - 1);
        }
    }

    /**
     * Метод меняется местами заданые позиции
     *
     * @param source      - индекс изначального элемента перемещения
     * @param destenation - индекс конечного элемента перемещения
     */
    private void changeProducts(Integer source, Integer destenation) {
        Product temp = products.get(source);
        products.set(source, products.get(destenation));
        products.set(destenation, temp);
    }

    /**
     * Метод перемещения элемента на позицию ниже
     *
     * @param product - объект Product
     */
    @Override
    public void moveDown(Product product) {
        int index = this.indexOf(product);
        if (index != -1 && index < products.size() - 1) {
            this.changeProducts(index, index + 1);
        }
    }


    /**
     * Метод возвращает все элементы коллекции
     *
     * @return - список элементов коллекции
     */
    @Override
    public List<Product> getList() {
        return products;
    }

    /**
     * Метод сортирует коллекцию по номеру позиции продукта
     */
    @Override
    public void sort() {
        Collections.sort(products);
    }
}
