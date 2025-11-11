import java.util.Scanner;

public class AverageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double one = sc.nextDouble();
        double two = sc.nextDouble();
        double three = sc.nextDouble();
        double avg = (one + two + three) / 3;
        System.out.println("Average of " + one + ", " + two + " and " + three + " is: " + avg);
        sc.close();
    }
}
