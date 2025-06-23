import java.util.*;
public class goodDigitStrings {
  public static int countGoodStrings(int n) {
    return helper(0, n);
  }

  public static int helper(int index, int n) {
    if(index == n) {
      return 1;
    }
    
    int total = 0; 

    if(index % 2 == 0) {
      //even index : 5 choices (0, 2, 4, 6 ,8)
      return 5*helper(index+1, n);
    }

    //odd index : 4 choices (2,3,5,7)
    return 4*helper(index+1, n);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the length of the digit string:");
    int n = sc.nextInt();
    System.out.println("Output: " + countGoodStrings(n));
    sc.close();
  }
}
