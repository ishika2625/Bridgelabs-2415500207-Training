import java.util.Scanner;

public class Problem_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        
        if(number <= 0) {
            System.out.println("Enter a positive integer.");
            sc.close();
            return;
        }
        
        for(int i = 1; i < number; i++) {
            if(number % i == 0)
                System.out.println(i);
        }
        sc.close();
    }
}
