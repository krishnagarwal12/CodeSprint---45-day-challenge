import java.util.*;
public class BinaryTable {
  public static int findSymbol(int n, int k) {
    if(n == 1) {
      return 0;
    }
    int mid = (int) Math.pow(2, n-1)/2;

    if(k <= mid) {
      return findSymbol(n-1, k);
    }
    else {
      return 1 - findSymbol(n-1, k-mid);
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the row number:");
    int n = sc.nextInt();
    System.out.println("Enter the position in the "+n+"th row:");
    int k = sc.nextInt();
    System.out.println(findSymbol(n,k));
    sc.close();
  }
}
