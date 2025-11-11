import java.util.Scanner;

public class Problem_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.print("Enter Power:");
        int pow = sc.nextInt();
        int result = 1;
        int i=1;
        while(i<=pow)
        {
            result *= number;
            i++;
        }
        System.out.println("The number "+number+ " to the power "+pow+" is: "+result);
        sc.close();
    }
}