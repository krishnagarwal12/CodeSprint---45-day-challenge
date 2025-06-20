import java.util.*;
public class nChooseR {

  public static int nCr(int n, int r) {
    if(r == 0 || r == n) {
      return 1;
    }
    return nCr(n-1, r) + nCr(n-1, r-1);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the values of N and r:");
    int n = sc.nextInt();
    int r = sc.nextInt();
    System.out.println(nCr(n,r));
    sc.close();
  }
}