/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cp2motorph;

import static cp2motorph.CP2motorPH.viewSummary;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author amatibag
 */
public class Payslip {
    public static void generateNBPayslip(int eeNo, String compN, double netGross, double sssDed, double pHealthDed, double pagIbigDed,
                                         double sssPHpi, double net, double withHTax, double netPay) {

        // File handling for payroll run summary
        // Delete existing file
        File paySlipC = new File("Employee_" + eeNo + "_payslip.txt");

        if (paySlipC.delete()) {
            System.out.println("Existing paySlip.txt deleted successfully.");
        } else {
            System.out.println("No existing paySlip.txt found to delete.");
        }

        // Create a new payslip file
        try {
            if (paySlipC.createNewFile()) {
                System.out.println("New paySlip file created successfully.\n");
            } else {
                System.out.println("Failed to create new paySlip file.");
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while creating the file: " + ex.getMessage());
        }

        // Print header into the file
        try (FileWriter paySlip = new FileWriter("Employee_" + eeNo + "_payslip.txt");
             PrintWriter payData = new PrintWriter(paySlip)) {

            payData.printf("\n     Employee Number:     %d\n", eeNo);
            payData.printf("     Employee Name:       %s\n", compN);
            payData.println("    ---------------------------------------------------------------");
            payData.printf("      Total Earnings:                                 %.2f\n\n", netGross);
            payData.printf("      SSS Deduction:                                  %.2f\n", sssDed);
            payData.printf("      Philhealth Deduction:                           %.2f\n", pHealthDed);
            payData.printf("      Pag-ibig Deduction:                             %.2f\n", pagIbigDed);
            payData.printf("      TOTAL DEDUCTIONS:                               %.2f\n\n", sssPHpi);
            payData.printf("      TAXABLE INCOME (Salary - Total Deductions):     %.2f\n\n", net);
            payData.printf("      WITHHOLDING TAX:                                %.2f\n\n", withHTax);
            payData.println("    ---------------------------------------------------------------");
            payData.printf("      NET PAY:                                        %.2f\n", netPay);
            payData.println("    ---------------------------------------------------------------\n");

        } catch (IOException ex) {
            System.out.println("Error occurred while writing to the file: " + ex.getMessage());
        }
        
        

        // Create and configure JLabels
        ImageIcon motorPHheader = new ImageIcon("MotorPHHeader.png");
        JLabel paySlipHeader = new JLabel();
        paySlipHeader.setText("Motor PH - CP2 | Group 3: Payslip Viewer");
        paySlipHeader.setIcon(motorPHheader);
        paySlipHeader.setOpaque(true);
        paySlipHeader.setHorizontalTextPosition(JLabel.CENTER);
        paySlipHeader.setVerticalTextPosition(JLabel.TOP);
        paySlipHeader.setForeground(Color.white);
        paySlipHeader.setFont(new Font("Arial", Font.BOLD, 30));
        paySlipHeader.setIconTextGap(1);
        paySlipHeader.setBackground(new Color(0x0E3171));
        paySlipHeader.setVerticalAlignment(JLabel.TOP);
        paySlipHeader.setHorizontalAlignment(JLabel.CENTER);
        paySlipHeader.setBounds(0, 0, 1250, 475);

        JLabel bodyLabel = new JLabel();
        bodyLabel.setOpaque(true);
        bodyLabel.setBackground(new Color(255, 255, 255, 250));
        bodyLabel.setBounds(50, 50, 1150, 900);

        JLabel eeName = new JLabel();
        eeName.setText("Employee #: " + eeNo + " | " + compN);
        eeName.setOpaque(true);
        eeName.setForeground(Color.white);
        eeName.setFont(new Font("Arial", Font.BOLD, 20));
        eeName.setBackground(new Color(0x0E3171));
        eeName.setVerticalAlignment(JLabel.TOP);
        eeName.setHorizontalAlignment(JLabel.CENTER);
        eeName.setBounds(50, 50, 1150, 30);

        // Format the pay details text
        String payDetailsText = String.format(
            "<pre>" +
            "    --------------------------------------------------------------------\n" +
            "      Total Earnings:                                  %-30.2f\n\n" +
            "      SSS Deduction:                                   %-30.2f\n" +
            "      Philhealth Deduction:                            %-30.2f\n" +
            "      Pag-ibig Deduction:                              %-30.2f\n" +
            "      TOTAL DEDUCTIONS:                                %-30.2f\n\n" +
            "      TAXABLE INCOME (Salary - Total Deductions):      %-30.2f\n\n" +
            "      WITHHOLDING TAX:                                 %-30.2f\n\n" +
            "    --------------------------------------------------------------------\n" +
            "      NET PAY:                                         %-30.2f\n" +
            "    --------------------------------------------------------------------\n" +
            "</pre>",
            netGross, sssDed, pHealthDed, pagIbigDed, sssPHpi, net, withHTax, netPay
        );

        JLabel payDetails = new JLabel("<html>" + payDetailsText.replace("\n", "<br>") + "</html>");
        payDetails.setOpaque(true);
        payDetails.setHorizontalTextPosition(JLabel.CENTER);
        payDetails.setForeground(new Color(0x0E3171));
        payDetails.setFont(new Font("Arial", Font.PLAIN, 16));
        payDetails.setBackground(new Color(255, 255, 255, 0));
        payDetails.setVerticalAlignment(JLabel.TOP);
        payDetails.setHorizontalAlignment(JLabel.CENTER);
        payDetails.setBounds(50, 150, 1150, 900);
        
        JButton closeButtonA = new JButton();
        closeButtonA.setBounds(450, 850, 350, 30);
        closeButtonA.setText("Calculate Salary for another employee");
        closeButtonA.setFocusable(false);
        closeButtonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the JFrame when the button is clicked
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(closeButtonA);
                frame.dispose();
                // Call the startPayroll method
                CP2motorPH.startPayroll();
            }
        });
        
        JButton closeButtonB = new JButton();
        closeButtonB.setBounds(450, 900, 350, 30);
        closeButtonB.setText("View payroll input summary file");
        closeButtonB.setFocusable(false);
        closeButtonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the JFrame when the button is clicked
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(closeButtonA);
                frame.dispose();
                // Call the startPayroll method
                CP2motorPH.viewSummary();
            }
        });
        
        JButton paySlip = new JButton();
        paySlip.setBounds(450, 800, 350, 30);
        paySlip.setText("View payslip file");
        paySlip.setFocusable(false);
        paySlip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Call the startPayroll method
                CP2motorPH.slipLauncher(eeNo);
            }
        });

        
        // Create layered pane and add components
        JLayeredPane headerPane = new JLayeredPane();
        headerPane.setBounds(0, 0, 1500, 1000);
        headerPane.add(paySlipHeader, Integer.valueOf(0));
        headerPane.add(bodyLabel, Integer.valueOf(1));
        headerPane.add(eeName, Integer.valueOf(2));
        headerPane.add(payDetails, Integer.valueOf(3));
        headerPane.add(closeButtonA, Integer.valueOf(4));
        headerPane.add(closeButtonB, Integer.valueOf(4));
        headerPane.add(paySlip, Integer.valueOf(4));


        // Create and configure JFrame
        JFrame homeframe = new JFrame("JLayeredPane");
        homeframe.add(headerPane);
        homeframe.setTitle("Motor PH - CP2 | Group 3");
        homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeframe.getContentPane().setBackground(new Color(0x0E3171));
        homeframe.setSize(new Dimension(1265, 1000));
        ImageIcon appLogo = new ImageIcon("logo.png");
        homeframe.setIconImage(appLogo.getImage());
        homeframe.setVisible(true);
    
    }
    
    
    
    
    
    public static void generateWPayslip(int eeNo, String compN, double netGross, double sssDed, double pHealthDed, double pagIbigDed,
                                         double sssPHpi, double net, double withHTax, double nBen, double rice, 
                                         double phone, double clothing, double netPaywithBen) {

        // File handling for payroll run summary
        // Delete existing file
        File paySlipWB = new File("Employee_" + eeNo + "_payslip.txt");

        if (paySlipWB.delete()) {
            System.out.println("Existing paySlip.txt deleted successfully.");
        } else {
            System.out.println("No existing paySlip.txt found to delete.");
        }

        // Create a new payslip file
        try {
            if (paySlipWB.createNewFile()) {
                System.out.println("New paySlip file created successfully.\n");
            } else {
                System.out.println("Failed to create new paySlip file.");
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while creating the file: " + ex.getMessage());
        }

        // Print header into the file
        try (FileWriter paySlipWBN = new FileWriter("Employee_" + eeNo + "_payslip.txt");
             PrintWriter payDataWB = new PrintWriter(paySlipWBN)) {

            payDataWB.printf("\n          Employee Number:     %d\n", eeNo);
            payDataWB.printf("          Employee Name:       %s\n", compN);
            payDataWB.printf("    ---------------------------------------------------------------"+ "\n");
            payDataWB.printf("      Total Earnings:                                 %.2f\n\n", netGross);
            payDataWB.printf("      SSS Deduction:                                  %.2f\n", sssDed);
            payDataWB.printf("      Philhealth Deduction:                           %.2f\n", pHealthDed);
            payDataWB.printf("      Pag-ibig Deduction:                             %.2f\n", pagIbigDed);
            payDataWB.printf("      TOTAL DEDUCTIONS:                               %.2f\n\n", sssPHpi);
            payDataWB.printf("      TAXABLE INCOME (Salary - Total Deductions):     %.2f\n\n", net);
            payDataWB.printf("      WITHHOLDING TAX:                                %.2f\n\n", withHTax);
            payDataWB.printf("      Non-Taxable Benefits:                           %.2f\n", nBen);
            payDataWB.printf("          Rice Subsidy:                      %.2f\n", rice);
            payDataWB.printf("          Phone Allowance:                   %.2f\n", phone);
            payDataWB.printf("          Clothing Allowance:                %.2f\n\n", clothing);
            payDataWB.printf("    ---------------------------------------------------------------"+ "\n");
            payDataWB.printf("      NET PAY:                                        %.2f\n", netPaywithBen);
            payDataWB.printf("    ---------------------------------------------------------------\n");
        } catch (IOException ex) {
            System.out.println("Error occurred while writing to the file: " + ex.getMessage());
        }
        // Create and configure JLabels
        ImageIcon motorPHheader = new ImageIcon("MotorPHHeader.png");
        JLabel paySlipHeader = new JLabel();
        paySlipHeader.setText("Motor PH - CP2 | Group 3: Payslip Viewer");
        paySlipHeader.setIcon(motorPHheader);
        paySlipHeader.setOpaque(true);
        paySlipHeader.setHorizontalTextPosition(JLabel.CENTER);
        paySlipHeader.setVerticalTextPosition(JLabel.TOP);
        paySlipHeader.setForeground(Color.white);
        paySlipHeader.setFont(new Font("Arial", Font.BOLD, 30));
        paySlipHeader.setIconTextGap(1);
        paySlipHeader.setBackground(new Color(0x0E3171));
        paySlipHeader.setVerticalAlignment(JLabel.TOP);
        paySlipHeader.setHorizontalAlignment(JLabel.CENTER);
        paySlipHeader.setBounds(0, 0, 1250, 475);

        JLabel bodyLabel = new JLabel();
        bodyLabel.setOpaque(true);
        bodyLabel.setBackground(new Color(255, 255, 255, 250));
        bodyLabel.setBounds(50, 50, 1150, 900);

        JLabel eeName = new JLabel();
        eeName.setText("Employee #: " + eeNo + " | " + compN);
        eeName.setOpaque(true);
        eeName.setForeground(Color.white);
        eeName.setFont(new Font("Arial", Font.BOLD, 20));
        eeName.setBackground(new Color(0x0E3171));
        eeName.setVerticalAlignment(JLabel.TOP);
        eeName.setHorizontalAlignment(JLabel.CENTER);
        eeName.setBounds(50, 50, 1150, 30);

        // Format the pay details text
        String payDetailsText = String.format(
            "<pre>" +
            "    --------------------------------------------------------------------\n" +
            "      Total Earnings:                                  %-30.2f\n\n" +
            "      SSS Deduction:                                   %-30.2f\n" +
            "      Philhealth Deduction:                            %-30.2f\n" +
            "      Pag-ibig Deduction:                              %-30.2f\n" +
            "      TOTAL DEDUCTIONS:                                %-30.2f\n\n" +
            "      TAXABLE INCOME (Salary - Total Deductions):      %-30.2f\n\n" +
            "      WITHHOLDING TAX:                                 %-30.2f\n\n" +
            "      Non-Taxable Benefits:                            %-30.2f\n" +
            "      Rice Subsidy:                      %-20.2f\n" +
            "      Phone Allowance:                   %-20.2f\n" +
            "      Clothing Allowance:                %-20.2f\n" +
            "      --------------------------------------------------------------------\n" +
            "      NET PAY:                                        %-30.2f\n" +
            "      --------------------------------------------------------------------\n" +
            "</pre>",
            netGross, sssDed, pHealthDed, pagIbigDed, sssPHpi, net, withHTax, nBen, rice, phone, clothing, netPaywithBen
        );

        JLabel payDetails = new JLabel("<html>" + payDetailsText.replace("\n", "<br>") + "</html>");
        payDetails.setOpaque(true);
        payDetails.setHorizontalTextPosition(JLabel.CENTER);
        payDetails.setForeground(new Color(0x0E3171));
        payDetails.setFont(new Font("Arial", Font.PLAIN, 16));
        payDetails.setBackground(new Color(255, 255, 255, 0));
        payDetails.setVerticalAlignment(JLabel.TOP);
        payDetails.setHorizontalAlignment(JLabel.CENTER);
        payDetails.setBounds(50, 150, 1150, 900);
        
        JButton closeButtonA = new JButton();
        closeButtonA.setBounds(450, 850, 350, 30);
        closeButtonA.setText("Calculate Salary for another employee");
        closeButtonA.setFocusable(false);
        closeButtonA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the JFrame when the button is clicked
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(closeButtonA);
                frame.dispose();
                // Call the startPayroll method
                CP2motorPH.startPayroll();
            }
        });
        
        
        JButton closeButtonB = new JButton();
        closeButtonB.setBounds(450, 900, 350, 30);
        closeButtonB.setText("View payroll input summary file");
        closeButtonB.setFocusable(false);
        closeButtonB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the JFrame when the button is clicked
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(closeButtonA);
                frame.dispose();
                // Call the startPayroll method
                CP2motorPH.viewSummary();
            }
        });
        
        JButton paySlip = new JButton();
        paySlip.setBounds(450, 800, 350, 30);
        paySlip.setText("View payslip file");
        paySlip.setFocusable(false);
        paySlip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Call the startPayroll method
                CP2motorPH.slipLauncher(eeNo);
            }
        });
        
        // Create layered pane and add components
        JLayeredPane headerPane = new JLayeredPane();
        headerPane.setBounds(0, 0, 1500, 1000);
        headerPane.add(paySlipHeader, Integer.valueOf(0));
        headerPane.add(bodyLabel, Integer.valueOf(1));
        headerPane.add(eeName, Integer.valueOf(2));
        headerPane.add(payDetails, Integer.valueOf(3));
        headerPane.add(closeButtonA, Integer.valueOf(4));
        headerPane.add(closeButtonB, Integer.valueOf(4));
        headerPane.add(paySlip, Integer.valueOf(4));

        // Create and configure JFrame
        JFrame homeframe = new JFrame("JLayeredPane");
        homeframe.add(headerPane);
        homeframe.setTitle("Motor PH - CP2 | Group 3");
        homeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeframe.getContentPane().setBackground(new Color(0x0E3171));
        homeframe.setSize(new Dimension(1265, 1000));
        homeframe.setVisible(true);
        ImageIcon appLogo = new ImageIcon("logo.png");
        homeframe.setIconImage(appLogo.getImage());
    
    }
}