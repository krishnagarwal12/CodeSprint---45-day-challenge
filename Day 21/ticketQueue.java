import java.util.*;
public class ticketQueue {

  public static int calculateTime(int tickets[], int k) {
    int time = 0;
    for(int i=0; i<tickets.length; i++) {
      if(i<=k) {
        time = time + Math.min(tickets[i], tickets[k]);
      }
      else {
        time = time + Math.min(tickets[i], tickets[k]-1);
      }
    }
    return time;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of people who want t0 buy tickets: ");
    int n = sc.nextInt();
    sc.nextLine();
    int tickets[] = new int[n];
    System.out.println("Enter the number of tickets each person wants:");
    for(int i=0; i<n; i++) {
      tickets[i] = sc.nextInt();
    }
    System.out.print("Enter the initial position of target visitor in the queue: ");
    int k = sc.nextInt();
    System.out.println("Time = "+calculateTime(tickets,k));
    sc.close();
  }
}