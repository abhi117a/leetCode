public class LinkedListPart2 {

  private static Node head;
  private static Node head1;

  private void addAtTheEnd(int data) {
    if (head == null) {
      head = new Node(data);
    } else {
      Node p = head;
      while (p.next != null) {
        p = p.next;
      }
      p.next = new Node(data);
    }
  }

  private void addAtTheEndpart2(int data) {
    if (head1 == null) {
      head1 = new Node(data);
    } else {
      Node p = head;
      while (p.next != null) {
        p = p.next;
      }
      p.next = new Node(data);
    }
  }

  private Node addTwoList(Node head, Node head1) {
    Node p = head;
    Node k = head1;
    Node newNode = new Node(0);
    Node kl = newNode;
    int carry = 0;

    while (p != null || k != null) {
      int x = p != null ? p.data : 0;
      int y = k != null ? k.data : 0;

      int sum = carry + x + y;
      carry = sum / 10;
      kl.next = new Node(sum % 10);
      kl = kl.next;
      if (p != null) {
        p = p.next;
      }
      if (k != null) {
        k = k.next;
      }
    }
    if (carry > 0) {
      kl.next = new Node(carry);
    }
    return kl.next;
  }

  // Merge SortedLinkedList

  private void mergeList(Node head, Node head1) {

    Node p = head;
    Node q = head1;
    Node dummyHead = new Node(0);
    Node temp = dummyHead;

    while (p != null || q != null) {
      if (p != null && q != null) {
        int value = 0;
        if (p.data >= q.data) {
          value = p.data;
          p = p.next;
        } else {
          value = q.data;
          q = q.next;
        }

        temp.next = new Node(value);

      } else if (p == null) {
        temp.next = new Node(q.data);
        q = q.next;
      } else if (q == null) {
        temp.next = new Node(p.data);
        p = p.next;
      }
    }
  }

  private void printLinkedList(Node head) {
    Node printing = head;
    while (printing != null) {
      System.out.println(printing.data);
      printing = printing.next;
    }
  }

  public static void main(String args[]) {

    LinkedListPart2 lp2 = new LinkedListPart2();
    lp2.addAtTheEnd(1);
    lp2.addAtTheEnd(2);
    lp2.addAtTheEnd(3);
    lp2.addAtTheEnd(4);
    lp2.addAtTheEndpart2(1);
    lp2.addAtTheEndpart2(2);
    lp2.addAtTheEndpart2(3);
    lp2.addAtTheEndpart2(4);
    lp2.addTwoList(head, head1);
  }
}
