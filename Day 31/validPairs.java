import java.util.*;

public class validPairs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of cards: ");
        int n = sc.nextInt();
        System.out.println("Enter the numbers on the cards:");
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        System.out.println("Output: " + count);
        sc.close();
    }
}