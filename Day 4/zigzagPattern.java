import java.util.*;
public class zigzagPattern {
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of days Abhik trained: ");
    int n = sc.nextInt();
    int total = 0;

    if(n > 10) {
      System.out.println("Abhik's marathon journey intensifies! Let's see his detailed zig-zag progress chart: ");
    }

    int maxWidth = n*4-1;
    for(int day=1; day<=n; day++) {
      int rowWidth = day*4-1;
      int padding = (maxWidth-rowWidth)/2;
      //spaces
      for(int p=0; p<padding; p++) {
        System.out.print(" ");
      }
      //numbers
      if(day%2 == 0) {
        for(int i=day; i>=1; i--) {
          System.out.print(i);
          total++;
          if(i!=1) {
            System.out.print("   ");
          }
        }
      }
      else {
        for(int i=1; i<=day; i++) {
          System.out.print(i);
          total++;
          if(i!=day) {
            System.out.print("   ");
          }
        }
      }
      System.out.println();
    }
    System.out.println("Total numbers printed: "+total);
    sc.close();
    
  }
}