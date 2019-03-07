public class LinkedList {

  private static Node head;

  ////// Add at the end///////

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

  ////// Add at the begining//////

  private void addAtTheBegining(int data) {
    if (head == null) {
      head = new Node(data);
    } else {
      Node p = new Node(data);
      p.next = head;
      head = p;
    }
  }

  /////// Add at the desired location//////

  private void addAtLocation(int loc, int data) {

    Node p = head;
    while (p.next != null && loc > 1) {
      p = p.next;
      loc--;
    }
    if (loc == 1) {
      Node k = new Node(data);
      k.next = p.next;
      p.next = k;
    }
  }

  //// Remove from the end///////

  private void removeEnd() {
    if (head != null) {
      Node p = head;
      while (p.next.next != null) {
        p = p.next;
      }
      p.next = null;
    }
  }

  //// Remove from the begining////

  private void removeStart() {
    if (head != null) {
      Node p = head;
      p = null;
      head = head.next;
    }
  }

  //// View The Linked List//////
  private void viewList(Node head) {
    Node p = head;
    while (p.next != null) {
      System.out.println(p.data);
      p = p.next;
    }
    System.out.println(p.data);
  }

  public static void main(String[] args) {

    LinkedList ls = new LinkedList();
    ls.addAtTheEnd(1);
    ls.addAtTheEnd(2);
    ls.addAtTheEnd(3);
    ls.addAtLocation(1, 10);
    ls.viewList(head);
    ls.removeStart();
    ls.viewList(head);
    System.out.println("Program Ended");
  }
}
