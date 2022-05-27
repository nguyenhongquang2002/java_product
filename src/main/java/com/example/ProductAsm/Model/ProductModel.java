package com.example.ProductAsm.Model;

import com.example.ProductAsm.Entity.Product;

import java.util.List;

public interface ProductModel {
    boolean save(Product product);
    boolean update(int id ,Product product);
    boolean delete(int id);
    List<Product> findByAll();
    Product findById(int id);
}
