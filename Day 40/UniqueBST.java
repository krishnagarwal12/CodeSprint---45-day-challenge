import java.util.*;
public class UniqueBST {
  public static int countTrees(int n) {
    //base case
    if(n == 0 || n == 1) {
      return 1;
    }

    int total = 0;

    for(int i=1; i<=n; i++) {
      int left = countTrees(i-1);
      int right = countTrees(n-i);
      total += left * right;
    }
    return total;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of unique flowers (nodes): ");
    int n = sc.nextInt();
    System.out.println("Number of unique BSTs: " + countTrees(n));
    sc.close();
  }
}
