package com.katsura.concurrencyInJava7.chapter5.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katsura on 2017/4/16.
 */
public class ProductListGenerator {
    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<Product>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
