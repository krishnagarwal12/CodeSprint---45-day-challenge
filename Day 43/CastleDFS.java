import java.util.*;
public class CastleDFS {
  public static void dfs(int node, List<List<Integer>> adj, boolean visited[], List<Integer> result) {
    visited[node] = true;
    result.add(node);

    for(int i : adj.get(node)) {
      if(!visited[i]) {
        dfs(i, adj, visited, result);
      }
    }
  }

  public static List<Integer> dfsTraversal(int n, List<List<Integer>> adj) {
    boolean visited[] = new boolean[n];
    List<Integer> result = new ArrayList<>();

    dfs(0, adj, visited, result);
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
      String line[] = sc.nextLine().trim().split("\\s+");
      List<Integer> neighbors = new ArrayList<>();
      for(String s : line) {
        if(!s.isEmpty()) {
          neighbors.add(Integer.parseInt(s));
        }
      }
      adj.add(neighbors);
    }
    List<Integer> order = dfsTraversal(n, adj);
    System.out.println("DFS Order: " + order);
    sc.close();
  }
}