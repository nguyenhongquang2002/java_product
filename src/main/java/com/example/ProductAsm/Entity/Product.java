package com.example.ProductAsm.Entity;

import com.example.ProductAsm.Entity.StatusEnum.ProductEN;
import com.example.ProductAsm.Entity.base.BaseEntity;
import com.example.ProductAsm.Entity.validation.ProductValidation;

import java.time.LocalDateTime;

public class Product extends BaseEntity {
    private int id;
    private String name;
    private String desciption;
    private String detail;
    private double price;
    private String thumbnail;
    private String manufactureEmail;
    private String manufacturePhone;

    public Product() {
        this.name ="";
        this.desciption ="";
        this.detail ="";
        this.thumbnail ="";
        this.manufactureEmail ="";
        this.manufactureEmail ="";
    }

    @Override
    public Object getDescription() {
        return null;
    }

    public Product(int id, String name, String desciption, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone,LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, int createdBy, int updatedBy, int deletedBy, ProductEN productEN ) {
        super(createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, productEN);
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
    }

    public Product(String name, String desciption, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone) {
        this.name = name;
        this.desciption = desciption;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
    }

    public Product(int id, String name, String desciption, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.detail = detail;
        this.price = price;
        this.thumbnail = thumbnail;
        this.manufactureEmail = manufactureEmail;
        this.manufacturePhone = manufacturePhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getManufactureEmail() {
        return manufactureEmail;
    }

    public void setManufactureEmail(String manufactureEmail) {
        this.manufactureEmail = manufactureEmail;
    }

    public String getManufacturePhone() {
        return manufacturePhone;
    }

    public ProductValidation getProductValidation() {
        return new ProductValidation(this.name, this.desciption, this.detail, this.price, this.thumbnail, this.manufactureEmail, this.manufacturePhone);
    }
}
