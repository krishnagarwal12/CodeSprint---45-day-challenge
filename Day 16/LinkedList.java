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
  public Node head;
  public Node tail;

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
    Node temp = node;
    System.out.print("[");
    while(temp != null) {
      System.out.print(temp.data);
      if(temp.next != null) {
        System.out.print(",");
      }
      temp = temp.next;
    }
    System.out.println("]");
  }

  public Node merge(Node head1, Node head2) {
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;

    while(head1 != null && head2 != null) {
      if(head1.data < head2.data) {
        temp.next = head1;
        head1 = head1.next;
      }
      else {
        temp.next = head2;
        head2 = head2.next;
      }
      temp = temp.next;
    }
    while(head1 != null) {
      temp.next = head1;
      head1 = head1.next;
      temp = temp.next;
    }
    while(head2 != null) {
      temp.next = head2;
      head2 = head2.next;
      temp = temp.next;
    }
    return mergedLL.next;
  }

  public static void main(String args[]) {
    LinkedList ll1 = new LinkedList();
    LinkedList ll2 = new LinkedList();

    Scanner sc = new Scanner(System.in);

    System.out.print("\nEnter the number of nodes in the first linked list: ");
    int n1 = sc.nextInt();
    System.out.print("\nEnter the values: ");
    for(int i=0; i<n1; i++) {
      ll1.addLast(sc.nextInt());
    }

    System.out.print("\nEnter the number of nodes in the second linked list: ");
    int n2 = sc.nextInt();
    System.out.print("\nEnter the values: ");
    for(int i=0; i<n2; i++) {
      ll2.addLast(sc.nextInt());
    }
    LinkedList resultLL = new LinkedList();
    Node result = resultLL.merge(ll1.head, ll2.head);

    System.out.println("\nMerged List: ");
    resultLL.print(result);
    sc.close();
  }
}
