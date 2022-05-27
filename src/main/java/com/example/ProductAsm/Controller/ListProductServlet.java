package com.example.ProductAsm.Controller;

import com.example.ProductAsm.Entity.Product;
import com.example.ProductAsm.Model.MySqlProductModel;
import com.example.ProductAsm.Model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productModel.findByAll();
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
    }
}
