import java.util.Scanner;

public class KilometerToMiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km = sc.nextDouble();
        double mile = km * 0.621371;
        System.out.println(km + " in miles is: " + mile);
        sc.close();
    }
}
