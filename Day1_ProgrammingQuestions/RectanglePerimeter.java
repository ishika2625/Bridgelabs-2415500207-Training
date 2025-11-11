import java.util.Scanner;

public class RectanglePerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double rLength = sc.nextDouble();
        double rWidth = sc.nextDouble();
        double rPerimeter = 2 * (rLength + rWidth);
        System.out.println("Perimeter of Rectangle is: " + rPerimeter);
        sc.close();
    }
}
