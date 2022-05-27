package com.example.ProductAsm.Entity.StatusEnum;

public enum ProductEN {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1),
    UNDEFINE(2);

    private int value;

    ProductEN(int value){this.value = value;}

    public int getValue() {
        return value;
    }

    public static ProductEN of (int value){
        for (ProductEN productEN : ProductEN.values()){
            if(productEN.getValue() == value){
                return productEN;
            }
        }
        return ProductEN.UNDEFINE;
    }
}
