import java.util.Scanner;

public class Problem_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        int[] heights = new int[3];
        
        for(int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextInt();
        }
        
        // Youngest
        int minAge = ages[0], youngestIndex = 0;
        for(int i = 1; i < 3; i++) {
            if(ages[i] < minAge) {
                minAge = ages[i];
                youngestIndex = i;
            }
        }
        System.out.println("Youngest friend: " + names[youngestIndex]);
        
        // Tallest
        int maxHeight = heights[0], tallestIndex = 0;
        for(int i = 1; i < 3; i++) {
            if(heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestIndex = i;
            }
        }
        System.out.println("Tallest friend: " + names[tallestIndex]);
        sc.close();
    }
}
