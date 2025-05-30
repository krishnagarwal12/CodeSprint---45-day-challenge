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

  public void print(Node head) {
    Node temp = head;
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

  public Node add(Node head1, Node head2) {
    Node result = new Node(0);
    Node ptr = result;

    int carry = 0;

    while(head1 != null || head2 != null) {
      int sum = 0+carry;

      if(head1 != null) {
        sum+=head1.data;
        head1 = head1.next;
      }
      if(head2 != null) {
        sum+=head2.data;
        head2 = head2.next;
      }
      carry = sum/10;
      sum = sum%10;
      ptr.next = new Node(sum);
      ptr = ptr.next;
    }
    if(carry == 1) {
      ptr.next = new Node(1);
    }
    return result.next;
  }

  public static void main(String args[]) {
    LinkedList ll1 = new LinkedList();
    LinkedList ll2 = new LinkedList();
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of digits in the first number: ");
    int n1 = sc.nextInt();
    System.out.println("Enter the digits: ");
    for(int i=0; i<n1; i++) {
      ll1.addLast(sc.nextInt());
    }

    System.out.print("Enter the number of digits in the secong number: ");
    int n2 = sc.nextInt();
    System.out.println("Enter the digits: ");
    for(int i=0; i<n2; i++) {
      ll2.addLast(sc.nextInt());
    }

    LinkedList resultLL = new LinkedList();
    Node result = resultLL.add(ll1.head, ll2.head);

    System.out.println("Result: ");
    resultLL.print(result);
  }
}
