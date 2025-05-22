import java.util.*;
public class maxStockProfit {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of days: ");
    int n = sc.nextInt();
    int prices[] = new int[n];
    System.out.print("Enter the stock prices for each day: ");
    for(int i=0; i<n; i++) {
      prices[i] = sc.nextInt();
    }
    int minPrice = prices[0];
    int maxProfit = 0;

    for(int i=1; i<n; i++) {
      int profit = prices[i] - minPrice;
      if(profit > maxProfit) {
        maxProfit = profit;
      }
      if(prices[i] < minPrice) {
        minPrice = prices[i];
      }
    }
    if(maxProfit >=2) {
      System.out.println(maxProfit);
    }
    else {
      System.out.println(0);
    }
    sc.close();
  }
}
