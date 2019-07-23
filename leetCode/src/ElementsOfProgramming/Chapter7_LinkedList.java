package ElementsOfProgramming;

import java.util.HashSet;
import java.util.Set;

public class Chapter7_LinkedList {
  private static Node head;
  private static Node head1;
  private static Node head2;

  // EPI 7.1

  private Node mergeTwoLinkedList(Node root, Node root1) {

    Node newHead = new Node(-1);
    Node mover = newHead;

    while (root != null || root1 != null) {
      if (root != null && root1 != null) {
        int x = root.data;
        int y = root1.data;

        if (x > y) {
          mover = mover.next;
          mover = new Node(y);
          root1 = root1.next;
        } else {
          mover = mover.next;
          mover = new Node(x);
          root = root.next;
        }
      } else if (root == null) {
        mover = mover.next;
        mover = new Node(root1.data);
        root1 = root1.next;
      } else if (root1 == null) {
        mover = mover.next;
        mover = new Node(root.data);
        root = root.next;
      }
    }
    return newHead.next;
  }

  // EPI 7.2

  private Node reverseList(Node root) {

    Node prev = null;
    Node curr = head;
    Node foll = head;

    while (curr != null) {
      foll = foll.next;
      curr.next = prev;
      prev = curr;
      curr = foll;
    }
    return prev;
  }

  // EPI 7.3

  private boolean cyclicity(Node root) {

    Node slow = head;
    Node fast = head.next;

    while (fast.next != null && fast.next.next != null) {
      if (fast == slow) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  // EPI 7.4 (Overlapping list with no cycles)

  private Node overLappingLists(Node head1, Node head2) {

    int len1 = findLength(head1);
    int len2 = findLength(head2);

    if (len1 > len2) {
      moveNode(len1 - len2, head1);
    } else {
      moveNode(len2 - len1, head2);
    }

    while (head1 != null && head2 != null && head1 != head2) {
      head1 = head1.next;
      head2 = head2.next;
    }
    return head1;
  }

  private void moveNode(int k, Node head) {
    while (k > 0) {
      head = head.next;
      k--;
    }
  }

  private int findLength(Node head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  // EPI 7.5 Overlapping list with Cycles

  private boolean overlappingListWithCycles(Node head1, Node head2) {

    // Add a linkedList to Set which has cycle

    Node adder;
    Node checker;

    if (cyclicity(head1)) {
      adder = head1;
      checker = head2;
    } else {
      adder = head2;
      checker = head1;
    }

    Set<Node> store = new HashSet<>();
    while (!store.contains(adder)) {
      store.add(adder);
      adder = adder.next;
    }
    while (checker != null) {
      if (store.contains(checker)) {
        return true;
      }
      checker = checker.next;
    }
    return false;
  }
}
