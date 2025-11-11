import java.util.Scanner;

public class Problem_13 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number n: ");
        int n = sc.nextInt();

        if (n > 0) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }

            int formulaSum = n * (n + 1) / 2;

            System.out.println("Sum using for loop = " + sum);
            System.out.println("Sum using formula = " + formulaSum);
        } else {
            System.out.println("Not a natural number.");
        }
        sc.close();
    }
}
