import java.util.*;
public class checkBoardPattern {

  public static void seatingArrangement(int n) {
    int arr[][] = new int[n][n];
    int total=0;
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        if((i+j)%2 == 0) {
          arr[i][j]=1;
          total++;
        }
      }
    }

    //print
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(arr[i][j]);
        if(j!=n-1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }

    System.out.println("Total students seated: "+total);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of row and columns in the hall: ");
    int n = sc.nextInt();
    seatingArrangement(n);
    sc.close();
  }
}