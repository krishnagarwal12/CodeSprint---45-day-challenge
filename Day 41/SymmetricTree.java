import java.util.*;
class TreeNode {
  int val;
  TreeNode left, right;
  TreeNode(int x) {
    val = x;
  }
}

public class SymmetricTree {
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

  public static boolean isSymmetric(TreeNode root) {
    return root == null || isMirror(root.left, root.right);
  }

  public static boolean isMirror(TreeNode t1, TreeNode t2) {
    if(t1 == null && t2 == null) {
      return true;
    }
    if(t1 == null || t2 == null) {
      return false;
    }
    return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input:");
    String inputLine = sc.nextLine();
    String nodes[] = inputLine.split(" ");
    TreeNode root = buildTree(nodes);
    System.out.println("Output: " + isSymmetric(root));
    sc.close();
  }
}
