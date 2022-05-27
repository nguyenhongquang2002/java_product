package com.example.ProductAsm.Controller;

import com.example.ProductAsm.Entity.Product;
import com.example.ProductAsm.Entity.validation.ProductValidation;
import com.example.ProductAsm.Model.MySqlProductModel;
import com.example.ProductAsm.Model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/product/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        Double price = Double.parseDouble(req.getParameter("price"));
        String manufactureEmail = req.getParameter("manufactureEmail");
        String manufacturePhone = req.getParameter("manufacturePhone");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Product product = new Product(name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone);
        if(product.getProductValidation().isValid()) {
            productModel.save(product);
            resp.sendRedirect("/products");
        }else {
            req.setAttribute("product", product);
            req.setAttribute("errors", ProductValidation.getProductErrors());
            req.getRequestDispatcher("/product/create.jsp").forward(req, resp);
        }
    }

}
