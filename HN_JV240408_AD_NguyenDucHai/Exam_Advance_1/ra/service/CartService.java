package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model.CartItem;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class CartService {
    public static ArrayList<CartItem> cartItems = new ArrayList<>();
    private static IGenericService<Product, String> products = new ProductService();

    //Dispay all Product
    public static void displayAllProduct() {
        int count = 0;
        for (Product product : products.getAll()) {
            System.out.println(product);
            count++;
        }
        System.out.println("Shop has " + count + " products");
    }

    //Add to cart
    public static void addToCart(Scanner sc) {
        System.out.println("Enter product id you want to add in your cart");
        String productId = sc.nextLine();
        boolean checkProductCart = false;
        for(Product product: products.getAll()){
            if(product.getProductId().equals(productId)){
                checkProductCart = true;
                boolean check = false;
                for (CartItem carts : CartService.cartItems){
                    if(carts.getProduct().getProductId().equals(productId)){
                        int qtyProduct;
                        while (true){
                            System.out.println("Product already in your cart, please enter quantity you want to add");
                             qtyProduct = Integer.parseInt(sc.nextLine());
                            if( qtyProduct > product.getStock()){
                                System.err.println("Out of Stock, please try again");
                            }else{
                                break;
                            }
                        }
                        carts.setQuantity(carts.getQuantity() + qtyProduct);
                        product.setStock(product.getStock() - qtyProduct);
                        System.out.println("Add to cart success");
                        check = true;
                        break;
                    }
                }
                if(!check){
                    CartItem newCart = new CartItem();
                    newCart.inputData(sc,productId);
                    CartService.cartItems.add(newCart);
                    product.setStock(product.getStock() - newCart.getQuantity());
                    System.out.println("Add to cart success");
                    break;
                }
            }
        }
        if(!checkProductCart){
            System.err.println("Cant find productId: "+productId);
        }
    }

    //display all cart
    public static void displayAllCart() {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        int count = 0;
        for(CartItem cartItem: cartItems){
            cartItem.displayData();
            count++;
        }
        System.out.println("Cart has " + count + " products");
    }


    //Change Quantity Product in cart
    public static void changeQtyProductInCart(Scanner sc) {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        int cartId;
        while (true){
            try{
                System.out.println("Enter cart id");
                 cartId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("You must enter a number, please try again");
            }
        }
        int qtyCart;
        while (true){
            try {
                System.out.println("Enter quantity you want to add");
                 qtyCart = Integer.parseInt(sc.nextLine());
                 break;
            }catch (NumberFormatException e){
                System.err.println("You must enter a number, please try again");
            }
        }
        boolean check = false;
        for(CartItem carts: cartItems){
            if(carts.getCartItemId() == cartId){
                carts.setQuantity(qtyCart);
                System.out.println("Update quantity success");
                check = true;
                break;
            }
        }
        if(!check){
            System.err.println("Not found Cart with id: "+cartId);
        }
    }

    //Delete One Product In Cart
    public static void deleteACart(Scanner sc) {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        int cartId;
        while (true){
            try{
                System.out.println("Enter cart id you want to delete");
                cartId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("You must enter a number, please try again");
            }
        }
        boolean check = false;
        for(CartItem carts: cartItems){
            if(carts.getCartItemId() == cartId){
                cartItems.remove(carts);
                System.out.println("Remove quantity success");
                check = true;
                break;
            }
        }
        if(!check){
            System.err.println("Not found Cart with id: "+cartId);
        }
    }

    //Delete All Product In Cart
    public static void deleteAllCart() {
        if(cartItems == null || cartItems.isEmpty()){
            System.err.println("List is empty");
            return;
        }
        cartItems = null;
        System.err.println("Delete success");
    }
}
