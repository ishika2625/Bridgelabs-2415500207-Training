import java.util.Scanner;
public class Problem_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a>0){
            int sum = a * ((a + 1)/2);
            System.out.println("The sum of "+ a +" natural numbers is "+ sum);
        }
        else{
            System.out.println("The number "+ a + " is not a natural number");
        }
        sc.close();
    }
}
