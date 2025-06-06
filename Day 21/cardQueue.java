import java.util.*;
import java.util.LinkedList;
public class cardQueue {

  public static int[] calculate(int deck[]) {
    Arrays.sort(deck);
    int n = deck.length;
    int result[] = new int[n];
    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<n; i++) {
      q.offer(i);
    }

    for(int i=0; i<n; i++) {
      int idx = q.poll();
      result[idx] = deck[i];

      if(!q.isEmpty()) {
        q.offer(q.poll());
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of cards: ");
    int n = sc.nextInt();
    sc.nextLine();
    int deck[] = new int[n];
    System.out.println("Enter the values on the cards: ");
    for(int i=0; i<n; i++) {
      deck[i] = sc.nextInt();
    }
    int result[] = calculate(deck);
    System.out.println("Output:");
    System.out.println(Arrays.toString(result));
    sc.close();
  }
}
