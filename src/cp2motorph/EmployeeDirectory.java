/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp2motorph;

/**
 *
 * @author amatibag
 */
public class EmployeeDirectory {
    public static void eeDirectory(int employeeNolist[], String lastNamelist[], String firstNamelist[]) {
        var eeNoCount = 1;
        var lastNameCount = 1;
        var firstNameCount = 1;
        System.out.println("Hello," + "\n" + "Here's the list of Motor PH employees." + "\n"
                + "Please choose associate details you want to view by entering Employee Number below:" + "\n");
        do {
            
            var templateEEList = "%2d - %s";
            var eeNoList = employeeNolist[eeNoCount];
            var printEElistName = lastNamelist[lastNameCount] + ", " + firstNamelist[firstNameCount];
            var printEElist = String.format(templateEEList, eeNoList, printEElistName);
            System.out.println(printEElist);
            eeNoCount++;
            lastNameCount++;
            firstNameCount++;
        } while (eeNoCount < employeeNolist.length && 
                 lastNameCount < lastNamelist.length &&
                 firstNameCount < firstNamelist.length);
    }
}

