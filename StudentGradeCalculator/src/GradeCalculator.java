import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        int total = 600;
        Scanner sc = new Scanner(System.in);

        //Getting all subject marks individually
        System.out.println("Enter Your Obtained Marks in Each Subject");
        System.out.println("Enter your marks in english: ");
        int english = sc.nextInt();
        System.out.println("Enter your marks in Hindi: ");
        int hindi = sc.nextInt();
        System.out.println("Enter your marks in Maths: ");
        int maths = sc.nextInt();
        System.out.println("Enter your marks in Science: ");
        int science = sc.nextInt();
        System.out.println("Enter your marks in History: ");
        int history = sc.nextInt();
        System.out.println("Enter your marks in Geography: ");
        int geography = sc.nextInt();

        //Calculating total obtained marks
        int sum = english+hindi+maths+science+history+geography;
        System.out.println("Your total obtained marks: "+sum);

        //Calcultating average obtained marks
        int avg = sum/6;
        System.out.println("Your average marks: "+avg);

        switch(avg/10){
            case 9:case 10:
                System.out.println("Your Grade: O");
                break;
            case 8:
                System.out.println("Your Grade: A");
                break;
            case 7:
                System.out.println("Your Grade: B");
                break;
            case 6:
                System.out.println("Your Grade: C");
                break;
            case 5:
                System.out.println("Your Grade: D");
                break;
            default:
                System.out.println("Your are Failed, better luck next time");
        }
    }
}