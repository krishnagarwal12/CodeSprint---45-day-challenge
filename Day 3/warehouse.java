import java.util.Scanner;
public class warehouse {

  public static void overstocked(int stock[][]) {
    int count=0, overstocked=0;
    for(int i=0; i<stock.length; i++) {
      count=0;
      for(int j=0; j<stock[i].length; j++) {
        if(stock[i][j] >= 100) {
          count++;
        }
      }
      if(count >= 3) {
        overstocked++;
      }
    }
    System.out.println(overstocked);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of warehouses and the number of product types: ");
    int r = sc.nextInt();
    int c = sc.nextInt();
    int stock[][] = new int[r][c];
    System.out.println("Enter the stock levels of the warehouses: ");
    for(int i=0; i<r; i++) {
      for(int j=0; j<c; j++) {
        stock[i][j] = sc.nextInt();
      }
      System.out.println();
    }
    overstocked(stock);
    sc.close();
  }
}