import java.util.*;
public class PowerOfTwo {
  public static boolean isPowerOfTwo(int n) {
    if(n <= 0) {
      return false;
    }
    if(n == 1) {
      return true;
    }
    if(n % 2 != 0) {
      return false;
    }
    return isPowerOfTwo(n /2);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int n = sc.nextInt();
    System.out.println("Output: " + isPowerOfTwo(n));
    sc.close();
  }
}
