/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp2motorph;

import java.util.Scanner;
import java.time.LocalTime;

public class TaxableWageCalculator {
    
    private double hrlyRate;
    private double taxableWage;
    
    public TaxableWageCalculator(double hrlyRate) {
        this.hrlyRate = hrlyRate;
    }
    
    public double calculateTaxableWage() {
        double totHrs = 0;
        double totRG = 0;
        double totOT = 0;
        taxableWage = 0;
        
        System.out.println("Calculate the weekly salary based on the hours worked by entering the number of days below:");
        System.out.print("\n" + "Enter the number of days you would like to enter: ");
        Scanner noDaysScanner = new Scanner(System.in);
        int noOfDays = noDaysScanner.nextInt();
        
        for (int i = 1; i <= noOfDays; i++) {
            System.out.println("\nDay " + i + ": ");
            System.out.print("Enter login time (HH:mm): ");
            Scanner loginScanner = new Scanner(System.in);
            String loginTimeString = loginScanner.next();
            
            System.out.print("Enter logout time (HH:mm): ");
            Scanner logoutScanner = new Scanner(System.in);
            String logoutTimeString = logoutScanner.next();
            
            double totHrs1 = calculateTotalHoursWorked(loginTimeString, logoutTimeString);
            double regHrs1 = calculateRegularHours(totHrs1);
            double otHrs1 = calculateOverTime(totHrs1);
            
            totHrs += totHrs1;
            totRG += regHrs1;
            totOT += otHrs1;
        }
        
        System.out.println("\nTotal Login Hours:     " + totHrs + "\n" +
                           "Total Regular Hours:    " + totRG + "\n" +
                           "Total Over-Time Hours:  " + totOT + "\n");
        
        if (totOT == 0) {
            taxableWage = totRG * hrlyRate;
            taxableWage = Math.round(taxableWage * 100.0) / 100.0;
            System.out.println("Total taxable earnings =    " + taxableWage);
        } else {
            System.out.print("Would you like to pay the overtime hours? Type yes or no: ");
            Scanner otQScanner = new Scanner(System.in);
            String otAns = otQScanner.next();
            
            if ("no".equals(otAns.toLowerCase())) {
                taxableWage = totRG * hrlyRate;
                taxableWage = Math.round(taxableWage * 100.0) / 100.0;
                System.out.println("Total taxable earnings =    " + taxableWage);
            } else if ("yes".equals(otAns.toLowerCase())) {
                System.out.print("Enter OverTime Rate (example enter 1.25 for 125% rate): ");
                Scanner otRScanner = new Scanner(System.in);
                double otRate = otRScanner.nextDouble();
                
                double taxableRGWage = (totRG * hrlyRate);
                taxableRGWage = Math.round(taxableRGWage * 100.0) / 100.0;
                double taxableOTWage = ((totOT * hrlyRate) * otRate);
                taxableOTWage = Math.round(taxableOTWage * 100.0) / 100.0;
                taxableWage = taxableRGWage + taxableOTWage;
                taxableWage = Math.round(taxableWage * 100.0) / 100.0;
                
                System.out.println("Taxable earnings from regular hours:    " + taxableRGWage + "\n" +
                                   "Taxable earnings from overtime hours:   " + taxableOTWage + "\n" +
                                   "Total taxable earnings =                " + taxableWage);
            } else {
                System.out.println("Invalid input for overtime payment choice.");
            }
        }
        
        return taxableWage;
    }
    
    public double getTaxableWage() {
        return taxableWage;
    }
    
    public double calculateTotalHoursWorked(String loginTimeString, String logoutTimeString) {
        LocalTime officeStartTime = LocalTime.of(8, 0); // 8:00 AM
        LocalTime officeEndTime = LocalTime.of(17, 0); // 5:00 PM
        int gracePeriodMinutes = 10;

        LocalTime loginTime = LocalTime.parse(loginTimeString);
        LocalTime actualLoginTime = loginTime;
        
        if (loginTime.isAfter(officeStartTime)) {
            long minutesAfterStart = officeStartTime.until(loginTime, java.time.temporal.ChronoUnit.MINUTES);
            if (minutesAfterStart > gracePeriodMinutes) {
                actualLoginTime = loginTime;
            } else {
                actualLoginTime = officeStartTime;
            }
        }

        LocalTime logoutTime = LocalTime.parse(logoutTimeString);
        double totalHoursWorked = actualLoginTime.until(logoutTime, java.time.temporal.ChronoUnit.MINUTES) / 60.0;
        
        System.out.print("Would you like to deduct 1 hour lunch for this day? Type yes or no: ");
        Scanner d_lunch = new Scanner(System.in);
        String lunch = d_lunch.next();
        
        if ("no".equals(lunch.toLowerCase())) {
            totalHoursWorked = Math.round(totalHoursWorked * 100.0) / 100.0;
            System.out.println("Total hours worked for the day =    " + totalHoursWorked);
        } else if ("yes".equals(lunch.toLowerCase())) {
            totalHoursWorked = (Math.round(totalHoursWorked * 100.0) / 100.0);
            totalHoursWorked = totalHoursWorked - 1;
            System.out.println("Total hours worked for the day =    " + totalHoursWorked);
        } else {
            System.out.println("Invalid entry for lunch deduction choice.");
        }
        
        return totalHoursWorked;
    }
    
    public double calculateRegularHours(double totHrs) {
        double rgHrs = 0;
        if (totHrs > 8) {
            rgHrs = 8;
        } else {
            rgHrs = totHrs;
        }
        System.out.println("Total regular hours worked for the day =    " + rgHrs);
        return rgHrs;
    }
    
    public double calculateOverTime(double totHrs) {
        double otHrs = 0;
        if (totHrs > 8) {
            otHrs = totHrs - 8;
            System.out.println("Total over-time hours worked for the day =    " + otHrs);
        } else {
            otHrs = 0;
        }
        return otHrs;
    } 
}