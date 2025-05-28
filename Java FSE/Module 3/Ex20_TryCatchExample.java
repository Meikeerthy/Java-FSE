import java.util.Scanner;

public class Ex20_TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the numerator: ");
            int numerator = sc.nextInt();

            System.out.println("Enter the denominator: ");
            int denominator = sc.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }
    }
}
