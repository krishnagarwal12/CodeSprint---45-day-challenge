import java.util.*;
public class reverseSublist {

  public static List<String> reverse(List<String> head, int left, int right) {
    //convert to 0 based index
    int start = left - 1;
    int end = right - 1;

    //reverse
    while(start < end) {
      String temp = head.get(start);
      head.set(start, head.get(end));
      head.set(end, temp);
      start++;
      end--;
    }
    return head;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    List<String> head = new ArrayList<>();
    System.out.print("Enter the number of items: ");
    int n = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the items: ");
    for(int i=0; i<n; i++) {
      String item = sc.nextLine();
      head.add(item);
    }
    System.out.println("Enter the starting and ending position: ");
    int left = sc.nextInt();
    int right = sc.nextInt();

    System.out.println("Original List: ");
    System.out.println(head);
    List<String> result = reverse(head, left, right);
    System.out.println("Resultant List: ");
    System.out.println(result);
    sc.close();
  }
}