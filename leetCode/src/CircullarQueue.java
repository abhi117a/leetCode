public class CircullarQueue {

  int MaxSize;
  int size = 0;
  int Capacity = MaxSize;
  int start = 0;
  int end = 0;
  int[] circularArray = new int[MaxSize];

  CircullarQueue(int MaxSize) {
    this.MaxSize = MaxSize;
  }

  private void enQueue(int data) {

    if (!isFull()) {
      circularArray[++size] = data;
      end = end + 1 % Capacity;
    }
  }

  private void dQueue(int data) {
    if (size >= 0) {
      int val = circularArray[size--];
      start = start + 1 % Capacity;
      System.out.println(val);
    } else {
      System.out.println("cannot remove");
    }
  }

  private boolean isFull() {

    if (end == Capacity) {
      return true;
    }
    return false;
  }
}
