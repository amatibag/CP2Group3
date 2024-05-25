/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cp2motorph;

import static cp2motorph.Payslip.generateNBPayslip;
import static cp2motorph.Payslip.generateWPayslip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author amatibag
 */
public class CP2motorPH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //file handling for payroll run summary
            //delete existing file
            File paySumC = new File("paySummary.txt");

            if (paySumC.delete()) {
                System.out.println("Process Reset any existing paySummary.txt will reset to blank.");
            }else{
                System.out.println(" ");
            }

            //create a paysummary file
            File paySum = new File("paySummary.txt");

            try{
            if(paySum.createNewFile()) {
                System.out.println("New paySummary file is created sucessfully." + "\n");
            }else {
                System.out.println(" ");
            }}catch (IOException ex) {
                System.out.println(" ");
            }
            
        //print header into the file
        try{
        FileWriter header = new FileWriter("paySummary.txt");
        PrintWriter prheader = new PrintWriter(header);
        
        prheader.printf("%-15s%-33s%-16s%-12s%-20s%-16s%-24s%-15s%-15s","Employee#","Employee Name","GrossPay","SSS","PhilHealth","PagIbig","WitholdingTax","Benefits","NetPay");
        header.close();
        }catch (IOException ex) {
            System.out.println(" ");
}
            startPayroll();
    }
         
         public static void startPayroll(){
            //list of employee details array
            int[] employeeNo = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
            String[] lastName = {" ", "Garcia", "Lim", "Aquino", "Reyes", "Hernandez", "Villanueva", "San Jose", "Romualdez", "Atienza", "Alvaro", "Salcedo", "Lopez", "Farala", "Martinez", "Romualdez", "Mata", "De Leon", "San Jose", "Rosario", "Bautista", "Lazaro", "Delos Santos", "Santos", "Del Rosario", "Tolentino", "Gutierrez", "Manalaysay", "Villegas", "Ramos", "Maceda", "Aguilar", "Castro", "Martinez", "Santos"};
            String[] firstName = {" ", "Manuel III", "Antonio", "Bianca Sofia", "Isabella", "Eduard", "Andrea Mae", "Brad", "Alice", "Rosie", "Roderick", "Anthony", "Josie", "Martha", "Leila", "Fredrick", "Christian", "Selena", "Allison", "Cydney", "Mark", "Darlene", "Kolby", "Vella", "Tomas", "Jacklyn", "Percival", "Garfield", "Lizeth", "Carol", "Emelia", "Delia", "John Rafael", "Carlos Ian", "Beatriz"};
            String[] birthday = {" ", "10/11/1983", "06/19/1988", "08/04/1989", "06/16/1994", "09/23/1989", "02/14/1988", "03/15/1996", "05/14/1992", "09/24/1948", "03/30/1988", "09/14/1993", "01/14/1987", "01/11/1942", "07/11/1970", "03/10/1985", "10/21/1987", "02/20/1975", "06/24/1986", "10/06/1996", "02/12/1991", "11/25/1985", "02/26/1980", "12/31/1983", "12/18/1978", "05/19/1984", "12/18/1970", "08/28/1986", "12/12/1981", "08/20/1978", "04/14/1973", "01/27/1989", "02/09/1992", "11/16/1990", "08/07/1990"};
            String[] address = {" ", "Valero Carpark Building Valero Street 1227, Makati City", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "460 Solanda Street Intramuros 1000, Manila", "National Highway, Gingoog, Misamis Occidental", "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands", "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi", "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte", "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte", "#284 T. Morato corner, Scout Rallos Street, Quezon City", "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate", "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro", "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte", "37/46 Kulas Roads, Maragondon 0962 Quirino", "22A/52 Lubowitz Meadows, Pililla 4895 Zambales", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "89A Armstrong Trace, Compostela 7874 Maguindanao", "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union", "93A/21 Berge Points, Tapaz 2180 Quezon", "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino", "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino", "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur", "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur", "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque", "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao", "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur", "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur", "66/77 Mann Views, Luisiana 1263 Dinagat Islands", "72/70 Stamm Spurs, Bustos 4550 Iloilo", "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija", "95 Cremin Junction, Surallah 2809 Cotabato", "Hi-way, Yati, Liloan Cebu", "Bulala, Camalaniugan", "Agapita Building, Metro Manila"};
            String[] phoneNumber = {" ", "966-860-270", "171-867-411", "966-889-370", "786-868-477", "088-861-012", "918-621-603", "797-009-261", "983-606-799", "266-036-427", "053-381-386", "070-766-300", "478-355-427", "329-034-366", "877-110-749", "023-079-009", "783-776-744", "975-432-139", "179-075-129", "868-819-912", "683-725-348", "740-721-558", "739-443-033", "955-879-269", "882-550-989", "675-757-366", "512-899-876", "948-628-136", "332-372-215", "250-700-389", "973-358-041", "529-705-439", "332-424-955", "078-854-208", "526-639-511"};
            String[] sssNo = {" ", "44-4506057-3", "52-2061274-9", "30-8870406-2", "40-2511815-0", "50-5577638-1", "49-1632020-8", "40-2400714-1", "55-4476527-2", "41-0644692-3", "64-7605054-4", "26-9647608-3", "44-8563448-3", "45-5656375-0", "27-2090996-4", "26-8768374-1", "49-2959312-6", "27-2090208-8", "45-3251383-0", "49-1629900-2", "49-1647342-5", "45-5617168-2", "52-0109570-6", "52-9883524-3", "45-5866331-6", "47-1692793-0", "40-9504657-8", "45-3298166-4", "40-2400719-4", "60-1152206-4", "54-1331005-0", "52-1859253-1", "26-7145133-4", "11-5062972-7", "20-2987501-5"};
            String[] philhealthNo = {" ", "820126853951", "331735646338", "177451189665", "341911411254", "957436191812", "382189453145", "239192926939", "545652640232", "708988234853", "578114853194", "126445315651", "431709011012", "233693897247", "515741057496", "308366860059", "824187961962", "587272469938", "745148459521", "579253435499", "399665157135", "606386917510", "357451271274", "548670482885", "953901539995", "753800654114", "797639382265", "810909286264", "934389652994", "351830469744", "465087894112", "136451303068", "601644902402", "380685387212", "918460050077"};
            String[] tinNo = {" ", "442-605-657-000", "683-102-776-000", "971-711-280-000", "876-809-437-000", "031-702-374-000", "317-674-022-000", "672-474-690-000", "888-572-294-000", "604-997-793-000", "525-420-419-000", "210-805-911-000", "218-489-737-000", "210-835-851-000", "275-792-513-000", "598-065-761-000", "103-100-522-000", "482-259-498-000", "121-203-336-000", "122-244-511-000", "273-970-941-000", "354-650-951-000", "187-500-345-000", "101-558-994-000", "560-735-732-000", "841-177-857-000", "502-995-671-000", "336-676-445-000", "210-395-397-000", "395-032-717-000", "215-973-013-000", "599-312-588-000", "404-768-309-000", "256-436-296-000", "911-529-713-000"};
            String[] pagibig = {" ", "691295330870", "663904995411", "171519773969", "416946776041", "952347222457", "441093369646", "210850209964", "211385556888", "260107732354", "799254095212", "218002473454", "113071293354", "631130283546", "101205445886", "223057707853", "631052853464", "719007608464", "114901859343", "265104358643", "260054585575", "104907708845", "113017988667", "360028104576", "913108649964", "210546661243", "210897095686", "211274476563", "122238077997", "212141893454", "515012579765", "110018813465", "697764069311", "993372963726", "874042259378"};
            String[] status = {" ", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Regular", "Regular", "Regular"};
            String[] position = {" ", "Chief Executive Officer", "Chief Operating Officer", "Chief Finance Officer", "Chief Marketing Officer", "IT Operations and Systems", "HR Manager", "HR Team Leader", "HR Rank and File", "HR Rank and File", "Accounting Head", "Payroll Manager", "Payroll Team Leader", "Payroll Rank and File", "Payroll Rank and File", "Account Manager", "Account Team Leader", "Account Team Leader", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Sales & Marketing", "Supply Chain and Logistics", "Customer Service and Relations"};
            String[] immediateSupervisor = {" ", "N/A", "Garcia, Manuel III", "Garcia, Manuel III", "Garcia, Manuel III", "Lim, Antonio", "Lim, Antonio", "Villanueva, Andrea Mae", "San, Jose Brad", "San, Jose Brad", "Aquino, Bianca Sofia", "Alvaro, Roderick", "Salcedo, Anthony", "Salcedo, Anthony", "Salcedo, Anthony", "Lim, Antonio", "Romualdez, Fredrick", "Romualdez, Fredrick", "Mata, Christian", "Mata, Christian", "Mata, Christian", "Mata, Christian", "Mata, Christian", "Mata, Christian", "Mata, Christian", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "Reyes, Isabella", "Reyes, Isabella", "Reyes, Isabella"};
            double[] basicSalary = {0, 90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500, 52670, 50825, 38475, 24000, 24000, 53500, 42975, 41850, 22500, 22500, 23250, 23250, 24000, 22500, 22500, 24000, 24750, 24750, 24000, 22500, 22500, 22500, 52670, 52670, 52670};
            double[] riceSubsidy = {0, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500};
            double[] phoneAllowance = {0, 2000, 2000, 2000, 2000, 1000, 1000, 800, 500, 500, 1000, 1000, 800, 500, 500, 1000, 800, 800, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 1000, 1000, 1000};
            double[] clothingAllowance = {0, 1000, 1000, 1000, 1000, 1000, 1000, 800, 500, 500, 1000, 1000, 800, 500, 500, 1000, 800, 800, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 1000, 1000, 1000};
            double[] grossSemiMonthlyRate = {0, 45000, 30000, 30000, 30000, 26335, 26335, 21488, 11250, 11250, 26335, 25413, 19238, 12000, 12000, 26750, 21488, 20925, 11250, 11250, 11625, 11625, 12000, 11250, 11250, 12000, 12375, 12375, 12000, 11250, 11250, 11250, 26335, 26335, 26335};
            double[] hourlyRate = {0, 535.71, 357.14, 357.14, 357.14, 313.51, 313.51, 255.8, 133.93, 133.93, 313.51, 302.53, 229.02, 142.86, 142.86, 318.45, 255.8, 249.11, 133.93, 133.93, 138.39, 138.39, 142.86, 133.93, 133.93, 142.86, 147.32, 147.32, 142.86, 133.93, 133.93, 133.93, 313.51, 313.51, 313.51};
            
        //display employee list
        EmployeeDirectory.eeDirectory(employeeNo, lastName, firstName);
        
       
        //select employee for payroll calculation
        System.out.println("\n"+"Please Enter the employee number of the employee you want to view and calculate salary:"+ "\n");
        Scanner employeNoEntry = new Scanner(System.in);
        int employeeNoSelected = SelectEmployee.selectedEmployee(employeNoEntry);
        
        //print employee details
        EmployeeDetailsPrinter.printDetails(employeeNoSelected, employeeNo, lastName, firstName, birthday, address, phoneNumber, sssNo, philhealthNo, tinNo, pagibig, status, position, immediateSupervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate);
    
        //calculate salary
        try{
        double nonTaxableBenefits = riceSubsidy[employeeNoSelected] + phoneAllowance[employeeNoSelected] + clothingAllowance[employeeNoSelected];
        
        TaxableWageCalculator taxableEarnings = new TaxableWageCalculator(hourlyRate[employeeNoSelected]);
        double taxableEarningsValue = taxableEarnings.calculateTaxableWage();
        
        double sSS = StatutoryDeductions.calculateSSS(basicSalary[employeeNoSelected]);
        double philHealth = StatutoryDeductions.calculatePhilHealth(basicSalary[employeeNoSelected]);
        double pagIbig = StatutoryDeductions.calculatePagibig(basicSalary[employeeNoSelected]);
        double totalDeductions = sSS + philHealth + pagIbig;
        double withEarnings = taxableEarnings.getTaxableWage() - totalDeductions;
        double witHoldingTax = StatutoryDeductions.calculateWitholdingTax(withEarnings);
        
        System.out.println("\n" + "Would you like to add the Non-Taxable Benefits on your calculation? Type yes or no:");
        Scanner refBen = new Scanner(System.in);
        String addBen = refBen.next();
        
        if ("no".equals(addBen.toLowerCase())) {
            payslipNObenefits(taxableEarningsValue, sSS, philHealth, 
                                        pagIbig, witHoldingTax, employeeNo[employeeNoSelected], lastName[employeeNoSelected], firstName[employeeNoSelected]);
            
        }else{
            if ("yes".equals(addBen.toLowerCase())) {
             payslipWITHbenefits(taxableEarningsValue, sSS, philHealth, 
                                        pagIbig, witHoldingTax, nonTaxableBenefits,
                                        riceSubsidy[employeeNoSelected], employeeNo[employeeNoSelected], lastName[employeeNoSelected], firstName[employeeNoSelected], phoneAllowance[employeeNoSelected], clothingAllowance[employeeNoSelected]);   
            }}
    
        System.out.println("\n" + "\n");
        EmployeeDirectory.eeDirectory(employeeNo, lastName, firstName);;
        }
        catch(Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");
            EmployeeDirectory.eeDirectory(employeeNo, lastName, firstName);}
       
       } 
         
    public static void payslipNObenefits(double netGross, double sssDed, double pHealthDed, 
                                        double pagIbigDed, double withHTax, int eeNo, String lastN, String firstN) {
            double sssPHpi = sssDed + pHealthDed + pagIbigDed;
            sssPHpi = (Math.round(sssPHpi*100.0)/100.0);
            double net = netGross - sssPHpi;
            net = (Math.round(net*100.0)/100.0);
            double netPay = net - withHTax;
            netPay = (Math.round(netPay*100.0)/100.0);
            String compN = lastN + ", " + firstN;
           
            System.out.println("\n" + "     Employee Number:     " + eeNo);
            System.out.println("     Employee Name:       " + compN);
            System.out.println("    ---------------------------------------------------------------");
            System.out.println("    Total Earnings:                                 " + netGross + "\n");
            System.out.println("    SSS Deduction:                                  " + sssDed);
            System.out.println("    Philhealth Deduction:                           " + pHealthDed);
            System.out.println("    Pag-ibig Deduction:                             " + pagIbigDed);
            System.out.println("    TOTAL DEDUCTIONS:                               " + sssPHpi + "\n");
            System.out.println("    TAXABLE INCOME (Salary - Total Deductions):     " + net + "\n");
            System.out.println("    WITHHOLDING TAX:                                " + withHTax + "\n");
            System.out.println("    ---------------------------------------------------------------");
            System.out.println("    NET PAY:                                        " + netPay);
            System.out.println("    ---------------------------------------------------------------" + "\n");
            
            try{
            FileWriter payOutput = new FileWriter("paySummary.txt", true);
            PrintWriter payOut = new PrintWriter(payOutput);
            
            payOut.printf("\n%-15d",eeNo);
            payOut.printf("%-33s",compN);
            payOut.printf("%-16s",netGross);
            payOut.printf("%-12s",sssDed);
            payOut.printf("%-20s",pHealthDed);
            payOut.printf("%-16s",pagIbigDed);
            payOut.printf("%-24s",withHTax);
            payOut.printf("%-15s",0);
            payOut.printf("%-15s",netPay);

            System.out.println("paySummary File updated..."+ "\n");
            payOutput.close();
            }catch (IOException ex) {
                System.out.println("File append error...");
            }
            generateNBPayslip(eeNo, compN, netGross, sssDed, pHealthDed, pagIbigDed, sssPHpi, net, withHTax, netPay);
            System.out.println("What would you like to do next? "+ "\n" +
                                "A. Calculate Salary for another employee" + "\n" +
                                "B. View payroll input summary file"+ "\n" +
                                "Enter letter of your choice (a or b)");
                Scanner next = new Scanner (System.in);
                String nextTask = next.next();
                if ("a".equals(nextTask.toLowerCase())) {clearConsole(); startPayroll(); }else{
                if ("b".equals(nextTask.toLowerCase())) {viewSummary();}else{
                System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");}}
            clearConsole(); 
            startPayroll();
            
    }



    public static void payslipWITHbenefits(double netGross, double sssDed, double pHealthDed, double pagIbigDed, double withHTax, double nBen, double rice, int eeNo, String lastN, String firstN, double phone, double clothing) {
            double sssPHpi = sssDed + pHealthDed + pagIbigDed;
            sssPHpi = (Math.round(sssPHpi*100.0)/100.0);
            double net = netGross - sssPHpi;
            net = (Math.round(net*100.0)/100.0);
            double netPay = net - withHTax;
            double netPaywithBen = netPay + nBen;
            netPaywithBen = (Math.round(netPaywithBen*100.0)/100.0);
            String compN = lastN + ", " + firstN;
            
            System.out.println("\n" + "Employee Number:     " + eeNo);
            System.out.println("Employee Name:      " + compN);
            System.out.println("    ---------------------------------------------------------------");
            System.out.println("    Total Earnings:                                 " + netGross + "\n");
            System.out.println("    SSS Deduction:                                  " + sssDed);
            System.out.println("    Philhealth Deduction:                           " + pHealthDed);
            System.out.println("    Pag-ibig Deduction:                             " + pagIbigDed);
            System.out.println("    TOTAL DEDUCTIONS:                               " + sssPHpi + "\n");
            System.out.println("    TAXABLE INCOME (Salary - Total Deductions):     " + net + "\n");
            System.out.println("    WITHHOLDING TAX:                                " + withHTax + "\n");
            System.out.println("    Non-Taxable Benefits:                           " + nBen);
            System.out.println("        Rice Subsidy:                      " + rice);
            System.out.println("        Phone Allowance:                   " + phone);
            System.out.println("        Clothing Allowance:                " + clothing  + "\n");
            System.out.println("    ---------------------------------------------------------------");
            System.out.println("    NET PAY:                                        " + netPaywithBen);
            System.out.println("    ---------------------------------------------------------------" + "\n");
            
            try{
            FileWriter payOutput = new FileWriter("paySummary.txt", true);
            PrintWriter payOut = new PrintWriter(payOutput);
            
            payOut.printf("\n%-15d",eeNo);
            payOut.printf("%-33s",compN);
            payOut.printf("%-16s",netGross);
            payOut.printf("%-12s",sssDed);
            payOut.printf("%-20s",pHealthDed);
            payOut.printf("%-16s",pagIbigDed);
            payOut.printf("%-24s",withHTax);
            payOut.printf("%-15s",nBen);
            payOut.printf("%-15s",netPaywithBen);

            System.out.println("paySummary File updated..."+ "\n");
            payOutput.close();
            }catch (IOException ex) {
                System.out.println("File append error...");
            }
            generateWPayslip(eeNo, compN, netGross, sssDed, pHealthDed, pagIbigDed, sssPHpi, net, withHTax, nBen, rice, phone, clothing, netPaywithBen); 
            System.out.println("What would you like to do next? "+ "\n" +
                                "A. Calculate Salary for another employee" + "\n" +
                                "B. View payroll input summary file"+ "\n" +
                                "Enter letter of your choice (a or b)");
                Scanner next = new Scanner (System.in);
                String nextTask = next.next();
                if ("a".equals(nextTask.toLowerCase())) {clearConsole(); startPayroll();}else{
                if ("b".equals(nextTask.toLowerCase())) {viewSummary();}else{
                System.out.println("!!! INVALID ENTRY ENTERED !!!" + "\n");}}
            clearConsole(); 
            startPayroll();
  
    }



    public static void viewSummary() {
        clearConsole();
        //print out list of employee
        System.out.println("\n"+"Hello, Here's the pay data captured on the Pay Summary file" + "\n");
        
        try{
        BufferedReader payrollSummary = new BufferedReader(new FileReader("paySummary.txt"));
        String line;
        while((line = payrollSummary.readLine()) !=null) {
        System.out.println(line);}
        payrollSummary.close();
        }catch (IOException e) {
            System.out.println("Error ecountered reading the file...");
        }
        
        System.out.println("\n"+"Continue with payroll calculation." + "\n");
        startPayroll();
    }

    
    
    public static void clearConsole() {
         // Print 50 empty lines to "clear" the console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("Console cleared!");
    }

}