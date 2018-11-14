package com.example.admin.preorder;

public class GetDataPre {
    String fruitId,fruitName,price,productName,quantity,unit;
    public GetDataPre(String fruitId,String fruitName,String price,String productName,String quantity,String unit){
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
        this.unit = unit;
    }
    public String getFruitId() {
        return fruitId;
    }
    public String getFruitName() {
        return fruitName;
    }
    public String getPrice() {
        return price;
    }
    public String getProductName() {
        return productName;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getUnit() {
        return unit;
    }

}