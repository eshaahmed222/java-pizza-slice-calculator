
/*
 *
 * @Author:  Esha Minhaj
 *  Date: February 12, 2026
 *  Description: This program asks the user to enter the diameter of a pizza (between 6 and 24 inches).
 * Based on the size entered, the program determines how many slices the pizza
 * should be cut into. It then calculates and displays the area of each slice.
 * All results are rounded to two decimal places).
 */

import java.util.Scanner;

public class PizzaSlices {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double diameter = readValidDiameter(input);
        int slices = determineSlices(diameter);

        double radius = diameter / 2.0;
        double pizzaArea = Math.PI * radius * radius;
        double areaPerSlice = pizzaArea / slices;

        System.out.println();
        System.out.printf("A %.0f\" pizza will yield %d slices.%n", diameter, slices);
        System.out.printf("Each slice will have an area of %.2f square inches.%n", areaPerSlice);

        input.close();
    }

    /**
     * Repeatedly prompts the user until they enter a valid numeric diameter
     * in the range 6 to 24 inclusive.
     */
    private static double readValidDiameter(Scanner input) {
        double diameter;

        while (true) {
            System.out.print("Please enter the diameter of your pizza (6\" to 24\"): ");

            if (!input.hasNextDouble()) {
                String badValue = input.next(); // consume invalid token
                System.out.printf("Error: \"%s\" is not a number. Please enter a numeric diameter.%n", badValue);
                continue;
            }

            diameter = input.nextDouble();

            if (diameter < 6 || diameter > 24) {
                System.out.println("Error: Pizza must have a diameter in the range of 6\" to 24\" inclusive! Please try again.");
                continue;
            }

            // Valid
            return diameter;
        }
    }

    /**
     * Determines number of slices based on the diameter rules provided.
     */
    private static int determineSlices(double diameter) {
        if (diameter >= 6 && diameter < 8) {
            return 4;
        } else if (diameter >= 8 && diameter < 12) {
            return 6;
        } else if (diameter >= 12 && diameter < 14) {
            return 8;
        } else if (diameter >= 14 && diameter < 16) {
            return 10;
        } else if (diameter >= 16 && diameter < 20) {
            return 12;
        } else { // 20 to 24 inclusive
            return 16;
        }
    }
}
