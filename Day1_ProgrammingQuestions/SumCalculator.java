import java.util.Scanner;

public class SumCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double sum = a + b;
        System.out.println("Sum of two numbers is: " + sum);
        sc.close();
    }
}
