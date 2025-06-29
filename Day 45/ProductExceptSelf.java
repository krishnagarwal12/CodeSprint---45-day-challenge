import java.util.*;
public class ProductExceptSelf {
  public static int[] productExceptSelf(int nums[]) {
    int n = nums.length;
    int result[] = new int[n];

    int prefix[] = new int[n];
    int suffix[] = new int[n];

    prefix[0] = 1;
    for(int i=1; i<n; i++) {
      prefix[i] = prefix[i-1] * nums[i-1];
    }

    suffix[n-1] = 1;
    for(int i=n-2; i>=0; i--) {
      suffix[i] = suffix[i+1] * nums[i+1];
    }

    for(int i=0; i<n; i++) {
      result[i] = prefix[i] * suffix[i];
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of crystals:");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the original energy levels of the crystals:");
    for(int i=0; i<n; i++) {
      nums[i] = sc.nextInt();
    }
    int output[] = productExceptSelf(nums);

    System.out.println("Output");
    for(int num : output) {
      System.out.print(num + " ");
    }
    sc.close();
  }
}