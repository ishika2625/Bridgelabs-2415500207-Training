import java.util.Scanner;
public class VoteChecker{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age[]=new int[10];
        for(int i=0;i<age.length;i++){
            System.out.print("Enter the Age of the "+(i+1)+ " Student:");
            age[i]=sc.nextInt();
        }
        for(int i=0;i<age.length;i++){
            if(age[i]<0){
                System.out.println("Invalid Age");
            }else if (age[i]>=18){
                System.out.println("The "+(i+1)+" student can vote");
            }else{
                System.out.println("The "+(i+1)+" student can not vote");
            }
        }
    }
}