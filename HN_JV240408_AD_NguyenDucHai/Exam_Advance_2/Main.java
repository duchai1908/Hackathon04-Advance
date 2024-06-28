package Advance.HN_JV240408_AD_NguyenDucHai.Exam_Advance_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ISBN number (10 digits)");
        String numberIsbn = scanner.nextLine();

        //Check if the number is 10 digits
        if (numberIsbn.length() != 10) {
            System.out.println("The ISBN number must have exactly 10 digits");
            return;
        }
        int sum = 0;
        Stack<Integer> digits = new Stack<>();
        try {

            //push 10 digits to stack
            for (int i = 0; i < 10; i++) {
                int digit = Character.getNumericValue(numberIsbn.charAt(i));
                digits.push(digit);
            }
            int multiplier = 1;

            // Calculate multiplication and sum until stack is empty
            while (!digits.isEmpty()) {
                sum += multiplier * digits.pop();
                multiplier++;
            }

            // Check if sum divisible by 11
            if (sum % 11 == 0) {
                System.out.println("Valid ISBN number");
            } else {
                System.out.println("Invalid ISBN number");
            }
        } catch (NumberFormatException e) {
            System.out.println("The input string is not a number");
        }
    }
}
