import java.util.*;

public class LinkedList {

  private static Node head;
  private static Node head1;
  private static Node head2;

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

  /// Leetcode 237. Delete Node in a Linked List
  /*Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.*/
  private void deteletDesired(Node node) {

    node.data = node.next.data;
    node.next = node.next.next;
  }

  // Delete a node with given value

  private void deleteValue(Node head, int val) {

    Node curr = head;
    Node prev = null;

    while (curr.data != val) {
      prev = curr;
      curr = curr.next;
    }

    prev.next = prev.next.next;
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

  // AddTwoNumbers..

  private void addTwoNumbersTwo() {

    Node p = head;
    Node k = head1;

    int carry = 0;
    int val = 0;
    Node summer = new Node(0);
    Node fin = summer;
    while (p != null || k != null) {

      int a = p != null ? p.data : 0;
      int b = k != null ? k.data : 0;
      int sum = a + b + carry;

      carry = sum > 9 ? sum / 10 : 0;
      val = sum < 9 ? sum : sum % 10;

      // fin = new Node(val);
      fin.next = new Node(val);
      fin = fin.next;
      p = p.next;
      k = k.next;
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

  /// Swap two elements of LinkedList////

  private void swapElements(int a, int b) {

    Node one = head;
    Node prevOne = null;
    Node two = head;
    Node prevTwo = null;

    while (one != null && a > 0) {
      prevOne = one;
      one = one.next;
      a--;
    }
    while (two != null && b > 0) {
      prevTwo = two;
      two = two.next;
      b--;
    }

    Node temp = one.next;
    one.next = two.next;
    two.next = temp;
  }

  //// Merging sorted linkedList////

  private void merge2SorterdList() {

    Node p = head;
    Node t = head1;
    int dat = head.data < head1.data ? head.data : head1.data;
    Node n = new Node(dat);
    head2 = n;

    while (p != null || t != null) {

      if (p == null) {
        n = n.next;
        n = new Node(t.data);
        t = t.next;
      } else if (t == null) {
        n = n.next;
        n = new Node(p.data);
        p = p.next;
      } else {
        n = n.next;
        if (t.data < p.data) {
          n = new Node(t.data);
          t = t.next;
        } else {
          n = new Node(p.data);
          p = p.next;
        }
      }
    }
  }

  private void reverseLinkedList(Node head) {
    Node prev = null;
    Node curr = head;
    Node foll = head;
    while (curr != null) {
      foll = foll.next;
      prev = curr.next;
      prev = curr;
      curr = foll;
    }
  }

  // Given a linked list and a value x, partition it such that all nodes less than x come before
  // nodes greater than or equal to x.
  //
  // You should preserve the original relative order of the nodes in each of the two partitions.

  private void partitionList(Node head, int x) {
    Node pLess = head;
    Queue<Integer> qu = new java.util.LinkedList<>();
    while (pLess != null) {
      if (pLess.data < x) {
        qu.offer(pLess.data);
      }
      pLess = pLess.next;
    }

    Node pMore = head;
    while (pMore != null) {
      if (pMore.data >= x) {
        qu.offer(pMore.data);
      }
      pMore = pMore.next;
    }
    Node newHead = new Node(-1);
    Node dummyRun = newHead;
    while (!qu.isEmpty()) {
      while (dummyRun.next != null) {
        dummyRun = dummyRun.next;
      }
      dummyRun.next = new Node(qu.poll());
    }
    Node p = newHead;
    while (p.next != null) {
      System.out.println(p.data);
      p = p.next;
    }
    System.out.println(p.data);
  }

  private void swapTwoAdjacentNodes(Node head) {
    Node p = head;
    Node newStart = p.next;

    while (true) {
      Node q = p.next;
      Node tmp = q.next;
      q.next = p;
      if (tmp == null || tmp.next == null) {
        p.next = tmp;
        break;
      }
      p.next = tmp.next;
      p = tmp;
    }
  }

  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    // Creating a new weaved list of original and copied nodes.
    Node ptr = head;
    while (ptr != null) {
      Node newNode = new Node(ptr.data);
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }
    ptr = head;

    while (ptr != null) {
      // ptr.next.random = ptr.random != null ? ptr.random.next : null;
      ptr = ptr.next.next;
    }

    Node ptr_old = head;
    Node ptr_new = head.next;
    Node head_old = head.next;
    while (ptr_old != null) {
      ptr_old.next = ptr_old.next.next;
      ptr_new.next = (ptr_new.next != null) ? ptr_new.next.next : null;
      ptr_old = ptr_old.next;
      ptr_new = ptr_new.next;
    }
    return head_old;
  }

  private void swapTwoAdjacentList(Node head) {

    Node p = head;
    while (p != null) {
      Node q = p.next;
      Node tmp = q.next;
      q.next = p;
      while (tmp == null || tmp.next == null) {
        p = tmp;
      }
      p.next = tmp.next;
      p = tmp;
    }
  }

  private Node reverseListWithRange(Node head, int m, int n) {

    if (head == null) {
      return null;
    }

    Node curr = head, prev = null;
    while (m > 1) {
      prev = curr;
      curr = curr.next;
      m--;
      n--;
    }

    Node con = prev;
    Node tail = curr;
    Node foll = curr;

    while (n > 0) {
      foll = foll.next;
      curr.next = prev;
      prev = curr;
      curr = foll;
      n--;
    }
    if (con != null) {
      con.next = prev;
    } else {
      head = prev;
    }
    tail.next = curr;
    return head;
  }
  // Find the Middle of the node
  private int findTheMiddleOfList(Node head) {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.data;
  }

  // Detect A cycle LeetCode 141. Linked List Cycle

  private boolean hasCycle(Node head) {

    Node slow = head;
    Node fast = head.next;

    while (slow != fast) {

      slow = slow.next;
      if (fast.next == null || fast.next.next == null) {
        return false;
      }
      fast = fast.next.next;
    }
    return true;
  }

  // 142. Linked List Cycle II return a node where cycle begins

  // Approach 1 Use a Hashset

  private Node detectCycleHashsetII(Node root) {
    Set<Node> store = new HashSet<>();
    while (root != null) {
      if (store.contains(root)) {
        return root;
      } else {
        store.add(root);
      }
      root = root.next;
    }
    return null;
  }

  // Slow and faster Approach

  private Node detectCycleII(Node head) {

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {

      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        break;
      }
    }

    if (fast == null || fast.next == null || fast.next.next == null) {
      return null;
    }

    Node starter = head;

    while (starter != slow) {
      starter = starter.next;
      slow = slow.next;
    }
    return slow;
  }

  // 876. Middle of the Linked List

  private Node middle(Node root) {

    Node slow = head;
    Node fast = head;
    while (fast != null || fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // Leetcode 83. Remove Duplicates from Sorted List

  private Node deleteDuplicate(Node root) {
    Node current = head;

    while (current != null && current.next != null) {
      if (current.next.data == current.data) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
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
    ls.addAtTheEnd(4);
    ls.addAtTheEnd(3);
    ls.addAtTheEnd(9);
    ls.addAtTheEnd(5);
    // ls.addAtTheEnd(2);
    // ls.reverseList();
    // ls.viewList(head);
    /*ls.addAtTheEnd1(4);
    ls.addAtTheEnd1(5);
    ls.addAtTheEnd1(6);
    ls.merge2SorterdList();*/
    // ls.addTwoNumbers();

    // ls.viewList(head);

    // ls.deleteValue(head, 9);
    System.out.println(ls.findTheMiddleOfList(head));
    // ls.viewList(head);

    // ls.partitionList(head, 3);

    System.out.println("Program Ended");
  }
}
