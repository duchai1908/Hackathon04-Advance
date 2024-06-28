package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.feature;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model.Product;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service.IGenericService;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service.ProductService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductFeature {
    private static IGenericService<Product, String> product = new ProductService();

    //Add new Product
    public static void addNewProduct(Scanner sc) {
        int number;
        while (true) {
            try {
                System.out.println("Enter the number product you want to add ");
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("You must enter a number, please try again");
            }
        }
        for (int i = 0; i < number; i++) {
            Product newProduct = new Product();
            System.out.println("Add Product " + (i + 1));
            newProduct.inputData(sc);
            product.save(newProduct);
        }
        System.out.println("Add " + number + " product success");

    }

    //Display all product
    public static void displayAllProduct() {
        int count = 0;
        for (Product product : product.getAll()) {
            System.out.println(product);
            count++;
        }
        System.out.println("Shop has " + count + " products");
    }

    //Sort products by price in descending order
    public static void sortProduct() {
        List<Product> sortedList = product.getAll().stream()
                .sorted(Comparator.comparingDouble(Product::getProductPrice).reversed())
                .toList();
        for (Product product : sortedList) {
            System.out.println(product);
        }
        System.out.println("Sort success");
    }

    //Delete product by Id
    public static void deleteProductById(Scanner sc) {
        if (product.getAll().isEmpty()) {
            System.err.println("List product is empty");
            return;
        }
        System.out.println("Enter product Id you want to delete");
        String productId = sc.nextLine();
        product.delete(productId);
    }

    //Search Product By ProductName
    public static void searchProductByName(Scanner sc) {
        if (product.getAll().isEmpty()) {
            System.err.println("List product is empty");
            return;
        }
        System.out.println("Enter product name you want to search");
        String productName = sc.nextLine();
        int count = 0;
        for (Product product : product.getAll()) {
            if (product.getProductName().contains(productName)) {
                System.out.println(product);
                count++;
            }
        }
        System.out.println("Found " + count + " products");
    }

    //Update Product by ProductId
    public static void updateProductInformation(Scanner sc) {
        if (product.getAll().isEmpty()) {
            System.err.println("List product is empty");
            return;
        }
        System.out.println("Enter product id you want to update");
        String productId = sc.nextLine();
        if(product.findById(productId) != null){
            product.save(product.findById(productId));
        }else{
            System.err.println("Not found product with Id: " + productId);
        }
    }
}
