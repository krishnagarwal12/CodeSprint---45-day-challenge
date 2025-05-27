public class sorting2 {

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

  public void print() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.data+"->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public Node sort(Node head) {
    int count0 = 0, count1 = 0, count2 = 0;
    Node temp = head;

    while(temp!=null) {
      if(temp.data == 0) {
        count0++;
      }
      else if(temp.data == 1) {
        count1++;
      }
      else {
        count2++;
      }
      temp = temp.next;
    }

    temp = head;
    while(count0-- > 0) {
      temp.data = 0;
      temp = temp.next;
    }
    while(count1-- > 0) {
      temp.data = 1;
      temp = temp.next;
    }
    while(count2-- > 0) {
      temp.data = 2;
      temp = temp.next;
    }
    return head;
  }

  public static void main(String args[]) {
    sorting2 ll = new sorting2();
    ll.addLast(2);
    ll.addLast(1);
    ll.addLast(0);
    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(0);

    System.out.print("Original list: ");
    ll.print();

    ll.head = ll.sort(ll.head);
    System.out.print("Sorted list: ");
    ll.print();
  }
}
