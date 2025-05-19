import java.util.Scanner;
public class matrixPuzzle {

  public static void printPuzzle(int arr[][]) {
    int d=1, ad=arr.length;
    for(int i=0; i<arr.length; i++) {
      for(int j=0; j<arr.length; j++) {
        if(i==j) {
          arr[i][j] = d++;
        }
        if(i+j == arr.length-1) {
          arr[i][j] = ad--;
        }
      }
    }
    for(int i=0; i<arr.length; i++) {
      for(int j=0; j<arr.length; j++) {
        if(arr[i][j] != 0) {
          System.out.print(arr[i][j]);
        }
        else {
          System.out.print("-");
        }
        if(j!=arr.length-1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of square matrix: ");
    int n = sc.nextInt();
    if(n%2 == 0 || n<3 ||n>1000) {
      System.out.println("Invalid input");
      return;
    }
    int arr[][] = new int[n][n];
    printPuzzle(arr);
    sc.close();
  }
}