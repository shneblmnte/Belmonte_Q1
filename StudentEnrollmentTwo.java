import java.util.Scanner;

//Base class
class Student {
    private String studentName;
    private String course;
    private String courseCode;
    private int totalUnits;
    
    //Constructor to initialize student details
    public Student(String studentName, String course, String courseCode) {
        this.studentName = studentName;
        this.course = course;
        this.courseCode = courseCode;
        this.totalUnits = 0;
    }

    //Method to add units for each subject
    public void addUnits(int units) {
        totalUnits += units;
    }

    // Method to calculate the total enrollment fee
    public int getTotalFee() {
        return totalUnits * 1000;
    }

    //Use getter methods to access student information
    public String getName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getTotalUnits() {
        return totalUnits;
    }
}

//Main class
public class StudentEnrollmentTwo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Input the needed information
        System.out.print("Enter Student Name: ");
        String studentName = input.nextLine();
        
        System.out.print("Enter Course: ");
        String course = input.nextLine();
        
        System.out.print("Enter Course Code: ");
        String courseCode = input.nextLine();
        
        //Create a new Student object
        Student student = new Student(studentName, course, courseCode);
        
        //Input number of subjects
        int numberOfSubjects;
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
            student.addUnits(units);
        }

        //Display the summary of student information and total enrollment fee
        System.out.println("\n---- Student Enrollment Information ----");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Course Code: " + student.getCourseCode());
        System.out.println("Number of Units (Maximum number of subjects is 10): " + student.getTotalUnits());

        //Calculate the enrollment fee
        int totalFee = student.getTotalFee();
        System.out.println("Total Enrollment Fee: " + totalFee + " PHP");

        System.out.print("\nEnter payment amount: ");
        int paymentAmount = input.nextInt();

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
