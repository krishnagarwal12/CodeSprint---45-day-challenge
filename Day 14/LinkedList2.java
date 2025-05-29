import java.util.*;
public class LinkedList2 {

  public static class Node {
    int val;
    Node next;

    public Node(int data) {
      this.val = data;
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

  public void print(Node head) {
    Node temp = head;
    System.out.print("[");
    while(temp != null) {
      System.out.print(temp.val);
      if(temp.next != null) {
        System.out.print(",");
      }
      temp = temp.next;
    }
    System.out.println("]");
  } 

  public Node doubleIt(Node head) {
    Node temp = head;
    if(head.val > 4) {
      Node newNode = new Node(1);
      newNode.next = head;
      head = newNode;
    }
    while(temp != null) {
      int carry = 0;
      if(temp.next != null && temp.next.val > 4) {
        carry = 1;
      }
      int newVal = (temp.val*2 + carry)%10;
      temp.val = newVal;
      temp = temp.next;
    }
    return head;
  }

  public static void main(String args[]) {
    LinkedList2 ll = new LinkedList2();
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of nodes: ");
    int n = sc.nextInt();
    System.out.println("Enter the values:");
    for(int i=0; i<n; i++) {
      int val = sc.nextInt();
      ll.addLast(val);
    }
    head = ll.doubleIt(head);
    System.out.println("Result: ");
    ll.print(head);
    sc.close();
  }
}