import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner Int = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = Int.nextInt();
        
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        
        System.out.println("Factorial of " + number + ": " + factorial);
        
       
    }
}
