package com.example.ProductAsm.Model;

import com.example.ProductAsm.Entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {

    private ProductModel productModel;

    @BeforeEach
    void setUp() {
        productModel = new MySqlProductModel();
    }

    @Test
    void save() {
        Product product = new Product("quang1","desc","detail",123456,"src/img/anh1","quang@gmail.com","0123456789");
        assertEquals(true,productModel.save(product));
    }

    @Test
    void update() {
        List<Product>  products = productModel.findByAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertNotEquals(null, product);
        product.setName("Product updated name");
        productModel.update(product.getId(), product);
        Product productUpdated = productModel.findById(product.getId());
        assertEquals("Product updated name", productUpdated.getName());

    }

    @Test
    void delete() {
        List<Product>  products = productModel.findByAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        assertEquals(true, productModel.delete(product.getId()));
    }

    @Test
    void findById() {
        List<Product>  products = productModel.findByAll();
        assertNotEquals(0, products.size());
        Product product = products.get(0);
        Product productFind = productModel.findById(product.getId());
        assertEquals(product.getId(), productFind.getId());
    }

    @Test
    void findByAll() {
        List<Product> products = productModel.findByAll();
        assertNotEquals(0,products.size());
    }
}