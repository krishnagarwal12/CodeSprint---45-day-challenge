import java.util.*;
public class removeCycle {

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  public static Node head;
  public static Node tail;

  public static boolean detectAndRemoveCycle() {
    //detect cycle
    Node slow = head;
    Node fast = head;
    boolean hasCycle = false;
    while(fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        hasCycle = true;
        break;
      }
    }

    if(!hasCycle) {
      return true;
    }

    //remove cycle
    slow = head;
    Node prev = null;
    while(slow!=fast) {
      prev = fast;
      slow = slow.next;
      fast = fast.next;
    }
    if(prev!=null) {
      prev.next = null;
      return true;
    }
    return false;
  }

  public static void createCycle(int pos) {
    if(pos<=0) {
      return;
    }
    Node cycleNode = null;
    Node temp = head;
    int idx = 1;

    while(temp != null) {
      if(idx == pos) {
        cycleNode = temp;
      }
      if(temp.next == null) {
        temp.next = cycleNode;
        return;
      }
      temp = temp.next;
      idx++;
    }
  }

  public static void printList() {
    Node temp = head;
    while(temp!=null) {
      System.out.print(temp.data);
      if(temp.next!=null) {
        System.out.print("->");
      }
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String args[]) {
    head = new Node(1);
    head.next = new Node(3);
    head.next.next = new Node(4);
    head.next.next.next = new Node(5);
    tail = head.next.next.next;

    printList();
    Scanner sc = new Scanner(System.in);
    System.out.print("pos = ");
    int pos = sc.nextInt();
    createCycle(pos);

    System.out.println("Result: "+detectAndRemoveCycle());
    sc.close();
    
  }
}
