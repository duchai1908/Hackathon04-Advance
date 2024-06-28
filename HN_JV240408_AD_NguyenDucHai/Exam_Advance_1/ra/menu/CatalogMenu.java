package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.menu;

import Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_1.ra.feature.CatalogFeature;

import java.util.Scanner;

public class CatalogMenu {
    public static void showCatalogMenu(Scanner sc) {
        while (true) {
            System.out.println("********************CATALOG-MANAGEMENT********************");
            System.out.println("1. Enter the number of newly added categories and enter information for each category");
            System.out.println("2. Display information of all categories");
            System.out.println("3. Edit the category name according to the category id");
            System.out.println("4. Delete categories by category code (note: do not delete when there are products)");
            System.out.println("5. Back");
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
                    CatalogFeature.addNewCatalog(sc);
                    break;
                case 2:
                    CatalogFeature.displayAllCatalog();
                    break;
                case 3:
                    CatalogFeature.UpdateNameCatalogById(sc);
                    break;
                case 4:
                    CatalogFeature.deleteCatalogById(sc);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("You must choice option 1 -> 5");
            }
        }
    }

}
