import java.util.*;
public class missingBadge {

  public static int findMissingBadge(int nums[]) {
    int n = nums.length;
    int totalSum = n * (n + 1)/2;
    int arraySum = 0;

    for(int i=0; i<n; i++) {
      arraySum = arraySum + nums[i];
    }

    return totalSum - arraySum;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the length of the array: ");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array:");
    for(int i=0; i<n; i++) {
      nums[i] = sc.nextInt();
    }

    System.out.println("Missing badge number = "+ findMissingBadge(nums));
    sc.close();
  }
}