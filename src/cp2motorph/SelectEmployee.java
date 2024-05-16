/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp2motorph;

import java.util.Scanner;

/**
 *
 * @author amatibag
 */
public class SelectEmployee {
    public static int selectedEmployee(Scanner scannerEENo) {
        int selectedEEno = 0;
        boolean validEENo = false;
        while (!validEENo) {
            System.out.print("Enter an employee number between 1 and 34: ");
            if (scannerEENo.hasNextInt()) {
                selectedEEno = scannerEENo.nextInt();
                if (selectedEEno >= 1 && selectedEEno <= 34) {
                    validEENo = true;
                } else {
                    System.out.println("Invalid entry. Please enter a number between 1 and 34.");
                }
            } else {
                System.out.println("Invalid entry. Please enter a number between 1 and 34.");
                scannerEENo.next();  // Clear the invalid input
            }
        }
        return selectedEEno;
    }
    
}
