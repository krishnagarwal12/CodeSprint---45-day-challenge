
public class LinkedList {
  public static class Node{
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node removeDuplicates(Node head) {
    if(head == null || head.next == null) {
      return head;
    }
    Node prev = head;
    Node temp = head.next;

    while(temp != null) {
      if(temp.data == prev.data) {
        temp = temp.next;
      }
      else {
        prev.next = temp;
        prev = temp;
        temp = temp.next;
      }
    }
    prev.next = null;
    return head;
  }

  public static void printList(Node node) {
    while(node != null) {
      System.out.print(node.data);
      if(node.next != null) {
        System.out.print("->");
        
      }
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String args[]) {
    Node head = new Node(1);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    head.next.next.next.next = new Node(3);
    System.out.println("Original list:");
    printList(head);
    head = removeDuplicates(head);
    System.out.println("After removing duplicates: ");
    printList(head);
  }
}