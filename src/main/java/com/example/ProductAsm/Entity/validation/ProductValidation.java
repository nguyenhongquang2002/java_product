package com.example.ProductAsm.Entity.validation;

import com.example.ProductAsm.Constant.ValidationConstant;
import com.example.ProductAsm.Entity.Product;
import com.example.ProductAsm.util.ValidationRegexHelper;

import java.util.HashMap;

public class ProductValidation extends Product {
    private static HashMap<String, String> productErrors;

    public ProductValidation() {
        productErrors = new HashMap<>();
    }

    public ProductValidation(String name, String description, String detail, double price, String thumbnail, String manufactureEmail, String manufacturePhone) {
        super(name, description, detail, price, thumbnail, manufactureEmail, manufacturePhone);
        productErrors = new HashMap<>();
    }

    public static HashMap<String, String> getProductErrors() {
        return productErrors;
    }

    public boolean isValid() {
        return this.checkValid();
    }

    public boolean checkValid() {
        if(getName() == null || getName() == "") {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_NAME, ValidationConstant.PRODUCT_ERROR_MESSAGE_NAME_REQUIRED);
        }
        if(getPrice() == 0) {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_PRICE, ValidationConstant.PRODUCT_ERROR_MESSAGE_PRICE_REQUIRED);
        }
        if(getThumbnail() == "" || getThumbnail() == null) {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_THUMBNAIL, ValidationConstant.PRODUCT_ERROR_MESSAGE_THUMBNAIL_REQUIRED);
        }
        if(getManufactureEmail() == "" || getManufactureEmail() == null) {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_EMAIl, ValidationConstant.PRODUCT_ERROR_MESSAGE_MANUFACTURE_EMAIl_REQUIRED);
        }
        if(getManufacturePhone() == "" || getManufacturePhone() == null) {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_PHONE, ValidationConstant.PRODUCT_ERROR_MESSAGE_MANUFACTURE_PHONE_REQUIRED);
        }
        if(getManufactureEmail() != "" && !ValidationRegexHelper.validateEmail(getManufactureEmail())) {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_EMAIl, ValidationConstant.PRODUCT_ERROR_MESSAGE_MANUFACTURE_EMAIl_INVALID);
        }
        if(getManufacturePhone() != "" && !ValidationRegexHelper.validateVietnamesePhone(getManufacturePhone())) {
            productErrors.put(ValidationConstant.PRODUCT_ERROR_KEY_MANUFACTURE_PHONE, ValidationConstant.PRODUCT_ERROR_MESSAGE_MANUFACTURE_PHONE_INVALID);
        }
        return productErrors.size() == 0;
    }
}
