import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cTemp = sc.nextDouble();
        double fTemp = (cTemp * 9 / 5) + 32;
        System.out.println("Temperature in Fahrenheit is: " + fTemp);
        sc.close();
    }
}
