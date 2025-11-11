import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if(number <= 0) {
            System.out.println("Enter a natural number.");
            sc.close();
            return;
        }
        
        for(int i = 1; i <= number; i++) {
            if(i % 2 == 0)
                System.out.println(i + " is Even");
            else
                System.out.println(i + " is Odd");
        }
        sc.close();
    }
}
