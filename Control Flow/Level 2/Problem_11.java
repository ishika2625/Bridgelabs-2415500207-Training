import java.util.Scanner;

public class Problem_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();
        
        if(number <= 0 || number >= 100) {
            System.out.println("Invalid input.");
            sc.close();
            return;
        }
        
        for(int i = 1; i < 100; i++) {
            if(i % number == 0)
                System.out.println(i);
        }
        sc.close();
    }
}
