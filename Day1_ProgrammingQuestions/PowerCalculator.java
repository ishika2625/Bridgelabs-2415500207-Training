import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        double exp = sc.nextDouble();
        double val = Math.pow(num, exp);
        System.out.println(num + " raised to the power " + exp + " is: " + val);
        sc.close();
    }
}
