public class sorting {

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

  public Node sort(Node head) {
    if(head == null || head.next == null) {
      return head;
    }

    Node curr = head;
    Node prev = null;

    while(curr != null) {
      if(curr.data < 0 && curr != head) {
        prev.next = curr.next;

        curr.next = head;
        head = curr;

        curr = prev.next;
      }
      else {
        prev = curr;
        curr = curr.next;
      }
    }
    return head;
  }
  public void addLast(int data) {
    Node newNode = new Node(data);
    if(head == null) {
      head = tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public void print() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.data+" -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public static void main(String args[]) {
    sorting ll = new sorting();
    ll.addLast(1);
    ll.addLast(-2);
    ll.addLast(-3);
    ll.addLast(4);
    ll.addLast(-5);

    System.out.print("Original list: ");
    ll.print();

    ll.head = ll.sort(ll.head);
    System.out.print("Resultant list: ");
    ll.print();
  }
}