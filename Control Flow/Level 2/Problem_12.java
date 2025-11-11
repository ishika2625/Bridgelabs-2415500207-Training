import java.util.Scanner;

public class Problem_12 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.print("Enter Power:");
        int pow = sc.nextInt();
        int result = 1;

        for (int i = 1;i<=pow;i++){
            result *= number;
        }
        System.out.println("The number "+number+ " to the power "+pow+" is: "+result);
        sc.close();
    }
}
