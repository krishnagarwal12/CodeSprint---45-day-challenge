import java.util.*;
public class largestPossibleNumber {

  public static String largestNumber(int nums[]) {
    String numStrs[] = new String[nums.length];
    
    //convert integers to s
    for(int i=0; i<nums.length; i++) {
      numStrs[i] = String.valueOf(nums[i]);
    }

    //sort string based on custom comparator
    Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

    //if largest no. is "0", return "0"
    if(numStrs[0].equals("0")) {
      return "0";
    }

    //build the largest no.
    StringBuilder result = new StringBuilder();
    for(String numStr : numStrs) {
      result.append(numStr);
    }
    return result.toString();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of tiles: ");
    int n = sc.nextInt();

    int nums[] = new int[n];
    System.out.println("Enter the numbers on the tiles:");
    for(int i=0; i<n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Result: "+largestNumber(nums));
    sc.close();
  }
}