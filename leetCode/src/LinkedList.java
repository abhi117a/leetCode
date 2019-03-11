import java.util.ArrayList;
import java.util.Collections;

public class LinkedList {

  private static Node head;
  private static Node head1;

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

  //// Creatign a new linkedList and adding elements/////
  private void addAtTheEnd1(int data) {
    if (head1 == null) {
      head1 = new Node(data);
    } else {
      Node p = head1;
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

  //// Remove from the beginning////

  private void removeStart() {
    if (head != null) {
      Node p = head;
      p = null;
      head = head.next;
    }
  }

  ///// Adding Two Numbers (Easy no edge case single element)/////

  private void addTwoNumbersEasy() {

    Node p = head;
    Node k = head1;
    int total = 0;
    while (p.next != null) {
      total += p.data + k.data;
    }
  }

  private void addTwoNumbers() {
    Node p = head;
    Node k = head1;
    int carry = 0;
    int sum = 0;
    ArrayList<Integer> out = new ArrayList<Integer>();

    while (p != null) {
      if (k != null) {
        sum += carry + p.data + k.data;
      } else {
        sum += carry + p.data;
      }
      if (sum > 9) {
        out.add(sum % 10);
        carry = 1;
        sum = 0;
      } else {
        out.add(sum);
        carry = 0;
        sum = 0;
      }
      p = p.next;
    }
    if (carry == 1) {
      out.add(1);
    }

    Collections.reverse(out);

    for (int i = 0; i < out.size(); i++) {
      System.out.print(out.get(i));
    }
  }

  /// Reverse a LinkedList/////

  private void reverseList() {

    Node previous = null;
    Node current = head;
    Node following = head;

    while (current != null) {
      following = following.next;
      current.next = previous;
      previous = current;
      current = following;
    }
    head = previous;
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
    /*
    ls.addAtTheEnd1(13);
    ls.addAtTheEnd1(12);
    ls.addAtTheEnd1(11);
    ls.addAtTheEnd(1);
    ls.addAtTheEnd(2);
    ls.addAtTheEnd(3);
    ls.addAtLocation(1, 10);
    ls.viewList(head);
    ls.removeStart();
    ls.viewList(head);
    ls.viewList(head1);
    */

    //////// Add Two Numbers /////////

    ls.addAtTheEnd(1);
    ls.addAtTheEnd(2);
    ls.addAtTheEnd(3);
    ls.reverseList();
    ls.viewList(head);
    ls.addAtTheEnd1(9);
    ls.addAtTheEnd1(9);
    ls.addAtTheEnd1(9);

    // ls.addTwoNumbers();

    System.out.println("Program Ended");
  }
}
