package ru.my.model;

import java.util.*;

public class ForMe {


    public static void main(String[] args) {
        TreeMap<Integer, Product> treeMap = new TreeMap<>();
        Product product1 = new Product(1, "milk");
        Product product2 = new Product(2, "bread");
        Product product3 = new Product(45, "bear");
//        Product product4 = new Product(3, "meat");
        List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product3);
        list.add(product2);


        Collections.sort(list);

        int index = 0;

//        String tempDown = list.get(index - 1).getName();
//        String temp = list.get(index).getName();
//        list.get(index-1).setName(temp);
//        list.get(index).setName(tempDown);

        int i = 0;


//        System.out.println(list);
//        treeMap.put(product1.getPosition(), product1);
//        treeMap.put(product3.getPosition(), product3);
//        treeMap.put(product2.getPosition(), product2);
//        Product tempProduct = treeMap.get(product3.getPosition());
//        Collection c = treeMap.values();
//        Iterator itr = c.iterator();
//        Product nextProduct = null;
//        while (itr.hasNext()) {
//            Product temp = (Product) itr.next();
//            if (temp.equals(tempProduct)){
//                if (itr.hasNext()) {
//                    nextProduct = treeMap.get(((Product) itr.next()).getPosition());
//                }
//                int er =0;
//            }
//            int k =0;
//            //System.out.println(itr.next());
//        }
        int p = 0;

//        Product tempP = treeMap.get(product2.getPosition());
//        List<Integer> temp = new ArrayList<>();
//        for (Map.Entry<Integer, Product> entry : treeMap.entrySet()) {
//            temp.add(entry.getValue().getPosition());
//        }
//        ListIterator<Integer> iterator = temp.listIterator();
//        LinkedHashMap<Integer, Product> linkedHashMap = new LinkedHashMap<>(treeMap);
//        linkedHashMap.

//        linkedHashMap.putAll(treeMap);
//        Product tempR;
//        while (iterator.hasNext()) {
//            if (iterator.next() == tempP.getPosition()) {
//                if (iterator.hasNext()) {
//                    int number = iterator.next();
//                    tempR = treeMap.get(number);
//                    int p = 0;
//                }
//                int p = 0;
//            }
//        }
//
//        int r = 0;


        //int p = 0;


    }
}
