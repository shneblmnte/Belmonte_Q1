import java.util.Scanner;

public class StudentEnrollment {
    public static void main(String[] args) {
        //Input the needed information
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();
        System.out.print("Enter Course: ");
        String course = input.nextLine();
        System.out.print("Enter Course Code: ");
        String courseCode = input.nextLine();

        int totalUnits = 0;
        int numberOfSubjects;
        
        //Input number of subjects
        do {
            System.out.print("Enter Number of Subjects (Maximum number of subjects is 10): ");
            numberOfSubjects = input.nextInt();
            if (numberOfSubjects > 0 && numberOfSubjects <= 10) {
            } else {
                System.out.println();
                System.out.println("Invalid number of subjects. Please enter a value from 1 to 10.");
            }
        } while (numberOfSubjects < 1 || numberOfSubjects > 10);


        //Input units for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter Number of Units (Maximum number of subjects is 10) " + i + ": ");
            int units = input.nextInt();
            totalUnits += units;
        }

        //Calculate the enrollment fee
        int totalFee = totalUnits * 1000;
        
        //Display the summary of student information and total enrollment fee
        System.out.println("\n---- Student Enrollment Information ----");
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Number of Units (Maximum number of subjects is 10): " + totalUnits);
        System.out.println("Total Enrollment Fee: " + totalFee + " PHP");
        
        System.out.println();
        System.out.print("Enter payment amount: ");
        int paymentAmount= input.nextInt();
        
        if (paymentAmount == totalFee) {
            System.out.println("Status: Fully Paid");
        } else if (paymentAmount < totalFee) {
            System.out.println("Status: Partial Payment");
            System.out.println("Amount Paid: " + paymentAmount + " PHP");
        } else {
            System.out.println("Status: Overpayment");
            System.out.println("Change: " + (paymentAmount - totalFee) + " PHP");
        }
        
        input.close();
    }
}