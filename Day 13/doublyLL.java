import java.util.*;
public class doublyLL {
  public static class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
      this.data = data;
      this.prev = null;
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
    newNode.prev = tail;
    tail = newNode;
  }

  public void print() {
    Node temp = head;
    while(temp!=null) {
      System.out.print(temp.data);
      if(temp.next != null) {
        System.out.print("<->");
      }
      temp = temp.next;
    }
    System.out.println();
  }

  private Node getMid(Node head) {
    Node slow = head;
    Node fast = head.next;

    while(fast!=null && fast.next!=null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public Node mergeSort(Node head) {
    if(head == null || head.next == null) {
      return head;
    }
    //find mid
    Node mid = getMid(head);

    //left and right mergeSort
    Node rightHead = mid.next;
    mid.next = null;
    rightHead.prev = null;
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(rightHead);

    //merge
    return merge(newLeft, newRight);
  }

  private Node merge(Node head1, Node head2) {
    Node mergedLL = new Node(-1);
    Node temp = mergedLL;
    while(head1 != null && head2 != null) {
      if(head1.data < head2.data) {
        temp.next = head1;
        head1.prev = temp;
        head1 = head1.next;
        temp = temp.next;
      }
      else {
        temp.next = head2;
        head2.prev = temp;
        head2 = head2.next;
        temp = temp.next;
      }
    }

    while(head1 != null) {
      temp.next = head1;
      head1.prev = temp;
      head1 = head1.next;
      temp = temp.next;
    }
    while(head2 != null) {
      temp.next = head2;
      head2.prev = temp;
      head2 = head2.next;
      temp = temp.next;
    }
    Node result = mergedLL.next;
    mergedLL.prev = null;
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    doublyLL dll = new doublyLL();
    int n = sc.nextInt();
    sc.nextLine();
    String values[] = sc.nextLine().split(" ");

    for(String val : values) {
      dll.addLast(Integer.parseInt(val));
    }
    dll.head = dll.mergeSort(dll.head);
    dll.print();
  }
}
