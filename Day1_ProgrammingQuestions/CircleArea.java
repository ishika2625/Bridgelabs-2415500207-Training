import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double rad = sc.nextDouble();
        double pi = 22.0 / 7.0;
        double area = pi * Math.pow(rad, 2);
        System.out.println("Area of circle is: " + area);
        sc.close();
    }
}
