package com.example.ProductAsm.Model;

import com.example.ProductAsm.Constant.SqlConstant;
import com.example.ProductAsm.Entity.Product;
import com.example.ProductAsm.Entity.StatusEnum.ProductEN;
import com.example.ProductAsm.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel{

    @Override
    public boolean save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_INSERT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDesciption());
            preparedStatement.setString(3,product.getDetail());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setString(5,product.getThumbnail());
            preparedStatement.setString(6,product.getManufactureEmail());
            preparedStatement.setString(7,product.getManufacturePhone());
            preparedStatement.setString(8,product.getCreatedAt().toString());
            preparedStatement.setString(9,product.getUpdatedAt().toString());
            preparedStatement.setString(10,product.getDeletedAt().toString());
            preparedStatement.setInt(11,product.getCreatedBy());
            preparedStatement.setInt(12,product.getUpdatedBy());
            preparedStatement.setInt(13,product.getDeletedBy());
            preparedStatement.setInt(14,product.getProductEN().getValue());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(int id, Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_UPDATE);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDesciption());
            preparedStatement.setString(3,product.getDetail());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setString(5,product.getThumbnail());
            preparedStatement.setString(6,product.getManufactureEmail());
            preparedStatement.setString(7,product.getManufacturePhone());
            preparedStatement.setString(8,product.getCreatedAt().toString());
            preparedStatement.setString(9,product.getUpdatedAt().toString());
            if (product.getDeletedAt() != null){
                preparedStatement.setString(10,product.getDeletedAt().toString());
            }else {
                preparedStatement.setString(10 , null);
            }
            preparedStatement.setInt(11,product.getCreatedBy());
            preparedStatement.setInt(12,product.getUpdatedBy());
            preparedStatement.setInt(13,product.getDeletedBy());
            preparedStatement.setInt(14,product.getProductEN().getValue());
            preparedStatement.setInt(15,id);
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2, ProductEN.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                String detail = rs.getString("detail");
                Double price = rs.getDouble("price");
                String thumbnail = rs.getString("thumbnail");
                String manufactureEmail = rs.getString("manufactureEmail");
                String manufacturePhone = rs.getString("manufacturePhone");
                LocalDateTime createdAt = rs.getTimestamp("createdAt").toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp("updatedAt").toLocalDateTime();
                LocalDateTime deletedAt = null;
                if (rs.getTimestamp("deletedAt") != null) {
                    deletedAt = rs.getTimestamp("deletedAt").toLocalDateTime();
                }
                    int createdBy = rs.getInt("createdBy");
                    int updatedBy = rs.getInt("updatedBy");
                    int deletedBy = rs.getInt("deletedBy");
                    ProductEN status = ProductEN.values()[rs.getInt("status")];
                    Product product = new Product(id ,name,description,detail,price,thumbnail,manufactureEmail,manufacturePhone,createdAt,updatedAt,deletedAt,createdBy,updatedBy,deletedBy,status);
                    return product;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Product> findByAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.PRODUCT_FIND_ALL);
            preparedStatement.setInt(1,ProductEN.ACTIVE.getValue());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = Integer.parseInt(rs.getString(SqlConstant.PRODUCT_FIELD_ID));
                String name = rs.getString(SqlConstant.PRODUCT_FIELD_NAME);
                String description = rs.getString(SqlConstant.PRODUCT_FIELD_DESCRIPTION);
                String detail = rs.getString(SqlConstant.PRODUCT_FIELD_DETAIL);
                Double price = rs.getDouble(SqlConstant.PRODUCT_FIELD_PRICE);
                String thumbnail = rs.getString(SqlConstant.PRODUCT_FIELD_THUMBNAIL);
                String manufactureEmail = rs.getString(SqlConstant.PRODUCT_FIELD_MANUFACTURE_EMAIL);
                String manufacturePhone = rs.getString(SqlConstant.PRODUCT_FIELD_MANUFACTURE_PHONE);
                LocalDateTime createdAt = rs.getTimestamp(SqlConstant.PRODUCT_FIELD_CREATED_AT).toLocalDateTime();
                LocalDateTime updatedAt = rs.getTimestamp(SqlConstant.PRODUCT_FIELD_UPDATED_AT).toLocalDateTime();
                LocalDateTime deletedAt = null;
                if(rs.getTimestamp(SqlConstant.PRODUCT_FIELD_DELETED_AT) != null) {
                    deletedAt = rs.getTimestamp(SqlConstant.PRODUCT_FIELD_DELETED_AT).toLocalDateTime();
                }
                int createdBy = rs.getInt(SqlConstant.PRODUCT_FIELD_CREATED_BY);
                int updatedBy = rs.getInt(SqlConstant.PRODUCT_FIELD_UPDATED_BY);
                int deletedBy = rs.getInt(SqlConstant.PRODUCT_FIELD_DELETED_BY);
                ProductEN status = ProductEN.of(rs.getInt("status"));
                Product product = new Product(id, name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone, createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status);
                return products;
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return products;
    }
}
