import java.util.*;
public class KingdomBFS {

  public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
    List<Integer> result = new ArrayList<>();
    boolean visited[] = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();

    queue.offer(0);
    visited[0] = true;

    while(!queue.isEmpty()) {
      int node = queue.poll();
      result.add(node);

      for(int i : adj.get(node)) {
        if(!visited[i]) {
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of castles: ");
    int n = sc.nextInt();
    sc.nextLine();

    List<List<Integer>> adj = new ArrayList<>();
    System.out.println("Enter adjacency list for each castle:");
    for(int i=0; i<n; i++) {
      String parts[] = sc.nextLine().trim().split("\\s+");
      List<Integer> neighbors = new ArrayList<>();
      for(String j : parts) {
        if(!j.isEmpty()) {
          neighbors.add(Integer.parseInt(j));
        }
      }
      adj.add(neighbors);
    }
    List<Integer> order = bfsTraversal(n, adj);
    System.out.println("Order of visiting castles: " + order);
    sc.close();
  }
}