package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.validate.ProductValidate;

import java.util.Scanner;

public class Product {
    private String productId,productName,description;
    private double productPrice;
    private int stock;
    private Catalog catalog;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, String description, double productPrice, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Input Data Product
    public void inputData(Scanner sc){
        this.productId = ProductValidate.inputProductId(sc);
        this.productName = ProductValidate.inputProductName(sc);
        this.productPrice = ProductValidate.inputProductPrice(sc);
        this.description = ProductValidate.inputProductDescriptions(sc);
        this.catalog = ProductValidate.inputProductCatalog(sc);
        this.stock = ProductValidate.inputProductStock(sc);
        this.status = true;
    }

    //Update Data Product
    public void saveData(Scanner sc){
        this.productName = ProductValidate.inputProductName(sc);
        this.productPrice = ProductValidate.inputProductPrice(sc);
        this.description = ProductValidate.inputProductDescriptions(sc);
        this.catalog = ProductValidate.inputProductCatalog(sc);
        this.stock = ProductValidate.inputProductStock(sc);
        this.status = ProductValidate.inputProductStatus(sc);
    }

    //Display Prduct
    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", productPrice=" + productPrice +
                ", stock=" + stock +
                ", catalog=" + catalog.getCatalogName() +
                ", status=" + (status ?"Sell":"notSell") +
                '}';
    }
}
