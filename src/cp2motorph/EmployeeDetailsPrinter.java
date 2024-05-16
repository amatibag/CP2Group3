/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp2motorph;

/**
 *
 * @author amatibag
 */
public class EmployeeDetailsPrinter {
    public static void printDetails(int employeeNoSelected, int[] employeeNo, String[] lastName, String[] firstName, String[] birthday, String[] address, String[] phoneNumber, String[] sssNo, String[] philhealthNo, String[] tinNo, String[] pagibig, String[] status, String[] position, String[] immediateSupervisor, double[] basicSalary, double[] riceSubsidy, double[] phoneAllowance, double[] clothingAllowance, double[] grossSemiMonthlyRate, double[] hourlyRate) {
        System.out.printf("\nHere are the details based on the Employee Number you entered: %n" +
                "Employee #:                %d%n" +
                "Last Name:                 %s%n" +
                "First Name:                %s%n" +
                "Birthday:                  %s%n" +
                "Address:                   %s%n" +
                "Phone Number:              %s%n" +
                "SSS Number:                %s%n" +
                "Philhealth Number:         %s%n" +
                "TIN Number:                %s%n" +
                "Pag-ibig Number:           %s%n" +
                "Status:                    %s%n" +
                "Position:                  %s%n" +
                "Immediate Supervisor:      %s%n" +
                "Basic Salary:              %.2f%n" +
                "Rice Subsidy:              %.2f%n" +
                "Phone Allowance:           %.2f%n" +
                "Clothing Allowance:        %.2f%n" +
                "Gross Semi-monthly Rate:   %.2f%n" +
                "Hourly Rate:               %.2f%n",
                employeeNo[employeeNoSelected],
                lastName[employeeNoSelected],
                firstName[employeeNoSelected],
                birthday[employeeNoSelected],
                address[employeeNoSelected],
                phoneNumber[employeeNoSelected],
                sssNo[employeeNoSelected],
                philhealthNo[employeeNoSelected],
                tinNo[employeeNoSelected],
                pagibig[employeeNoSelected],
                status[employeeNoSelected],
                position[employeeNoSelected],
                immediateSupervisor[employeeNoSelected],
                basicSalary[employeeNoSelected],
                riceSubsidy[employeeNoSelected],
                phoneAllowance[employeeNoSelected],
                clothingAllowance[employeeNoSelected],
                grossSemiMonthlyRate[employeeNoSelected],
                hourlyRate[employeeNoSelected]);
    }
}
