import java.util.*;
public class CountNodes {
  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
      this.val = val;
    }
  }

  public static int countNodes(TreeNode root) {
    if(root == null) {
      return 0;
    }
    int leftDepth = getDepth(root, true);
    int rightDepth = getDepth(root, false);

    if(leftDepth == rightDepth) {
      return (1 << leftDepth) - 1;
    }

    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  private static int getDepth(TreeNode node, boolean goLeft) {
    int depth = 0;
    while(node != null) {
      depth++;
      node = goLeft ? node.left : node.right;
    }
    return depth;
  }

  public static TreeNode buildTree(List<String> input) {
    if(input.isEmpty() || input.get(0).equals("null")) {
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(input.get(0)));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int i = 1;
    while(!queue.isEmpty() && i < input.size()) {
      TreeNode current = queue.poll();

      if(i < input.size() && !input.get(i).equals("null")) {
        current.left = new TreeNode(Integer.parseInt(input.get(i)));
        queue.offer(current.left);
      }
      i++;

      if(i < input.size() && !input.get(i).equals("null")) {
        current.right = new TreeNode(Integer.parseInt(input.get(i)));
        queue.offer(current.right);
      }
      i++;
    }
    return root;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Input:");
    String input = sc.nextLine();

    String tokens[] = input.split(",");
    List<String> inputList = new ArrayList<>();
    for(String token : tokens) {
      inputList.add(token.trim());
    }
    TreeNode root = buildTree(inputList);
    int result = countNodes(root);
    System.out.println("Output: "+ result);
    sc.close();
  }
}