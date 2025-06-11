import java.util.*;
public class enchantedLibrary {

  public static int[] findErrorNums(int nums[]) {
    int result[] = new int[2];
    int n = nums.length;
    boolean seen[] = new boolean[n+1];

    for(int num : nums) {
      if(seen[num]) {
        result[0] = num;
      }
      seen[num] = true;
    }

    for(int i=1; i<=n; i++) {
      if(!seen[i]) {
        result[1] = i;
        break;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of enchantment codes: ");
    int n = sc.nextInt();

    int nums[] = new int[n];
    System.out.println("Enter the enchantment codes: ");
    for(int i=0; i<n; i++) {
      nums[i] = sc.nextInt();
    }

    int result[] = findErrorNums(nums);
    System.out.println("Output: ["+result[0]+", "+result[1]+"]");
    sc.close();
  }
}