import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class MaxDepth {
  public static TreeNode buildTree(String nodes[]) {
    if(nodes.length == 0 || nodes[0].equals("null")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int i = 1;

    while(i < nodes.length) {
      TreeNode current = queue.poll();

      if(!nodes[i].equals("null")) {
        current.left = new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(current.left);
      }
      i++;

      if(i < nodes.length && !nodes[i].equals("null")) {
        current.right = new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(current.right);
      }
      i++;
    }
    return root;
  }

  public static int maxDepth(TreeNode root) {
    if(root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input:");
    String inputLine = sc.nextLine();
    String nodes[] = inputLine.split(" ");
    TreeNode root = buildTree(nodes);
    int depth = maxDepth(root);
    System.out.println("Output: " + depth);
    sc.close();
  }
}