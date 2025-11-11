import java.util.Scanner;

public class CylinderVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double radCylinder = sc.nextDouble();
        double heightCylinder = sc.nextDouble();
        double pi = 22.0 / 7.0;
        double vol = pi * Math.pow(radCylinder, 2) * heightCylinder;
        System.out.println("Volume of cylinder is: " + vol);
        sc.close();
    }
}
