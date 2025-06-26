import java.util.*;
public class SortedArrayToBST {
  static class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
      this.val = val;
    }
  }

  public static TreeNode sortedArrayToBST(int nums[]) {
    return build(nums, 0, nums.length - 1);
  }

  private static TreeNode build(int nums[], int left, int right) {
    if(left > right) {
      return null;
    }

    int mid = left + (right - left) / 2;
    TreeNode node = new TreeNode(nums[mid]);

    node.left = build(nums, left, mid - 1);
    node.right = build(nums, mid + 1, right);
    return node;
  }

  public static List<String> levelOrder(TreeNode root) {
    List<String> result = new ArrayList<>();
    if(root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      TreeNode curr = queue.poll();

      if(curr == null) {
        result.add("null");
        continue;
      }

      result.add(String.valueOf(curr.val));
      queue.offer(curr.left);
      queue.offer(curr.right);
    }

    int i = result.size() - 1;
    while(i >= 0 && result.get(i).equals("null")) {
      result.remove(i);
      i--;
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the sorted array elements:");
    String tokens[] = sc.nextLine().trim().split("\\s+");
    int nums[] = new int[tokens.length];

    for(int i=0; i<tokens.length; i++) {
      nums[i] = Integer.parseInt(tokens[i]);
    }

    TreeNode root = sortedArrayToBST(nums);
    List<String> levelOrderList = levelOrder(root);

    System.out.println("Level-order traversal of BST:");
    System.out.println(levelOrderList);
    sc.close();
  }
}