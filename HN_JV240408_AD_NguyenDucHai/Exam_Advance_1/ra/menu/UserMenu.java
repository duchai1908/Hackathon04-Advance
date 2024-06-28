package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.menu;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.service.CartService;

import java.util.Scanner;

public class UserMenu {
    public static void showMenuUser(Scanner sc) {
        while (true) {
            System.out.println("**************************MENU-USER**************************");
            System.out.println("1. Display Product List");
            System.out.println("2. Add To Cart");
            System.out.println("3. Display All Cart List");
            System.out.println("4. Change Quantity Product In Cart");
            System.out.println("5. Delete 1 Product In Cart");
            System.out.println("6. Delete All Product In Cart");
            System.out.println("7. Back");
            byte choice;
            while (true) {
                try {
                    System.out.println("Enter your choice");
                    choice = Byte.parseByte(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("You must enter a number, please try again");
                }
            }
            switch (choice) {
                case 1:
                    CartService.displayAllProduct();
                    break;
                case 2:
                    CartService.addToCart(sc);
                    break;
                case 3:
                    CartService.displayAllCart();
                    break;
                case 4:
                    CartService.changeQtyProductInCart(sc);
                    break;
                case 5:
                    CartService.deleteACart(sc);
                    break;
                case 6:
                    CartService.deleteAllCart();
                    break;
                case 7:
                    return;
                default:
                    System.err.println("You must choice option 1 -> 7");
            }
        }
    }
}
