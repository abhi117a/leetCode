public class MinHeap {

  private int size = 0;
  private int maxSize;
  private final int FRONT = 1;
  int[] Heap;

  MinHeap(int maxSize) {
    this.maxSize = maxSize;
    Heap = new int[maxSize + 1];
    Heap[0] = Integer.MIN_VALUE;
  }

  private int parent(int pos) {
    return pos / 2;
  }

  private int leftChild(int pos) {
    return pos * 2;
  }

  private int rightChild(int pos) {
    return (pos * 2) + 1;
  }

  private boolean isLeaf(int pos) {

    return ((pos >= (size / 2) && pos <= size) ? true : false);
  }

  private void swap(int fPos, int lPos) {
    int tmp = Heap[fPos];
    Heap[fPos] = Heap[lPos];
    Heap[lPos] = tmp;
  }

  private void minheapify(int pos) {
    if (!isLeaf(pos)) {

      if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

        if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
          swap(pos, leftChild(pos));
          minheapify(leftChild(pos));
        } else {
          swap(pos, rightChild(pos));
          minheapify(rightChild(pos));
        }
      }
    }
  }

  private void insert(int Value) {
    if (size == maxSize) {
      return;
    } else {
      Heap[++size] = Value;
    }
    int current = size;
    while (Heap[current] < Heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  private void doMinHeap() {
    for (int pos = size / 2; pos >= 1; pos--) {
      minheapify(pos);
    }
  }
}
