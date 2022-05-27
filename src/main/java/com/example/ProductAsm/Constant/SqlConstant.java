package com.example.ProductAsm.Constant;

public class SqlConstant {
    public static final String PRODUCT_INSERT = "INSERT INTO products (name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone," +
            "createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String PRODUCT_UPDATE = "UPDATE products SET name = ?, description = ?, detail = ?, price = ?, thumbnail = ?, manufactureEmail = ?, manufacturePhone = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?;";
    public static final String PRODUCT_DELETE = "DELETE FROM products WHERE id = ?;";
    public static final String PRODUCT_FIND_BY_ID = "SELECT * FROM products WHERE id = ? AND status = ?;";
    public static final String PRODUCT_FIND_ALL = "SELECT * FROM products WHERE status = ?;";
    public static final String PRODUCT_FIELD_STATUS = "status";
    public static final String PRODUCT_FIELD_ID = "id";
    public static final String PRODUCT_FIELD_NAME = "name";
    public static final String PRODUCT_FIELD_DESCRIPTION = "description";
    public static final String PRODUCT_FIELD_DETAIL = "detail";
    public static final String PRODUCT_FIELD_PRICE = "price";
    public static final String PRODUCT_FIELD_THUMBNAIL = "thumbnail";
    public static final String PRODUCT_FIELD_MANUFACTURE_EMAIL = "manufactureEmail";
    public static final String PRODUCT_FIELD_MANUFACTURE_PHONE = "manufacturePhone";
    public static final String PRODUCT_FIELD_CREATED_AT = "createdAt";
    public static final String PRODUCT_FIELD_UPDATED_AT = "updatedAt";
    public static final String PRODUCT_FIELD_DELETED_AT = "deletedAt";
    public static final String PRODUCT_FIELD_CREATED_BY = "createdBy";
    public static final String PRODUCT_FIELD_UPDATED_BY = "updatedBy";
    public static final String PRODUCT_FIELD_DELETED_BY = "deletedBy";

}
