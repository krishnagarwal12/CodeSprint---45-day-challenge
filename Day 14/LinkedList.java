import java.util.*;
public class LinkedList {
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

  public void addLast(int data) {
    Node newNode = new Node(data);
    if(head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public void print(Node node) {
    System.out.print("[");
    while(node != null) {
      System.out.print(node.data);
      if(node.next != null) {
        System.out.print(",");
      }
      node = node.next;
    }
    System.out.println("]");
  }

  public Node findMid(Node head) {
    Node slow = head;
    Node fast = head;

    while(fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String args[]) {
    LinkedList ll = new LinkedList();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of nodes: ");
    int n = sc.nextInt();
    System.out.println("Enter the values:");
    for(int i=0; i<n; i++) {
      int val = sc.nextInt();
      ll.addLast(val);
    }
    Node mid = ll.findMid(head);
    System.out.println("Output: ");
    ll.print(mid);
    sc.close();
  }
}