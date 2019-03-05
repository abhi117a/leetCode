public class LinkedList {

  private static Node head;

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


  private void addAtTheBegining(int data){
      if (head==null){
          head = new Node(data);
      }
      else {
          Node p = new Node(data);
          p.next = head;
          head = p;
      }
  }



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
    ls.addAtTheBegining(1);
    ls.addAtTheBegining(2);
    ls.addAtTheBegining(3);
    ls.viewList(head);
    System.out.println("Program Ended");
  }
}
