import java.util.*;
public class DoublyLL {

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
    System.out.print("head -> ");
    while(temp != null) {
      System.out.print(temp.data);
      if(temp.next != null) {
        System.out.print(" <-> ");
      }
      temp = temp.next;
    }
    System.out.println();
  }

  public Node removeTarget(int target) {
    Node temp = head;
    while(temp != null) {
      if(temp.data == target) {
        if(temp == head && temp == tail) {
          head = tail = null;
        }
        else if(temp == head) {
          head = temp.next;
          head.prev = null;
        }
        else if(temp == tail) {
          tail = temp.prev;
          tail.next = null;
        }
        else {
          temp.prev.next = temp.next;
          temp.next.prev = temp.prev;
        }
      }
      temp = temp.next;
    }
    return head;
  }

  public static void main(String args[]) {
    DoublyLL ll = new DoublyLL();
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter the number of nodes: ");
    int n = sc.nextInt();
    System.out.println("Enter the values: ");
    for(int i=0; i<n; i++) {
      int val = sc.nextInt();
      ll.addLast(val);
    }
    System.out.println("Original List: ");
    ll.print();
    System.out.print("target = ");
    int target = sc.nextInt();
    ll.head = ll.removeTarget(target);
    System.out.println("Resultant List: ");
    ll.print();
    sc.close();
  }
}