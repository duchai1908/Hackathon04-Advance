package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.run;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.menu.CatalogMenu;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.menu.ProductMenu;
import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.menu.UserMenu;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("************************BASIC-MENU************************");
            System.out.println("1.Category Management");
            System.out.println("2.Product Management");
            System.out.println("3.For User (***)");
            System.out.println("4.Exit");
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
                    CatalogMenu.showCatalogMenu(sc);
                    break;
                case 2:
                    ProductMenu.showProductMenu(sc);
                    break;
                case 3:
                    UserMenu.showMenuUser(sc);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.err.println("You must choice option 1 -> 3");

            }
        }

    }
}
