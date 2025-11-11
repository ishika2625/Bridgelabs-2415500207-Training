import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // 0=weight, 1=height, 2=BMI
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");

            double weight;
            do {
                System.out.print("Weight (kg): ");
                weight = sc.nextDouble();
            } while (weight <= 0);

            double height;
            do {
                System.out.print("Height (m): ");
                height = sc.nextDouble();
            } while (height <= 0);

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            if (bmi <= 18.4)
                weightStatus[i] = "Underweight";
            else if (bmi <= 24.9)
                weightStatus[i] = "Normal";
            else if (bmi <= 39.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                    personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
    }
}
