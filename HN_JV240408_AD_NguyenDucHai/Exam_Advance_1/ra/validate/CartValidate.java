package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.validate;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model.CartItem;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model.Product;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service.CartService;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service.IGenericService;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service.ProductService;

import java.util.Scanner;

public class CartValidate {
    private static IGenericService<Product,String> products = new ProductService();
    public static int inputCartId(){
        if(!CartService.cartItems.isEmpty()){
            int max = CartService.cartItems.get(0).getCartItemId();
            for(CartItem cart : CartService.cartItems){
                if(cart.getCartItemId() > max){
                    max = cart.getCartItemId();
                }
            }
            return max +1;
        }
        return 1;
    }

    public static Product inputProduct(String productId) {
        for (Product pr: products.getAll()){
            if (pr.getProductId().equals(productId)) {
                return pr;
            }
        }
        return null;
    }

    public static int inputCategoryQuantiry(Scanner sc, Product product) {
        int qtyProduct;
        while (true){
            while (true){
                try{
                    System.out.println("Enter quantity products");
                     qtyProduct = Integer.parseInt(sc.nextLine());
                    break;
                }catch (NumberFormatException e){
                    System.err.println("You must enter a number, please try again");
                }
            }
            if(product.getStock() < qtyProduct){
                System.err.println("The purchase quantity cannot be greater than the warehouse");
            }else {
                return qtyProduct;
            }
        }
    }
}
