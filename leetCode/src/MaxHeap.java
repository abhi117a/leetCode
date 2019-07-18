public class MaxHeap {

  int size = 0;
  int maxSize;
  int[] HeapOfMax;

  MaxHeap(int maxSize) {
    this.maxSize = maxSize;
    HeapOfMax = new int[maxSize];
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
    if (pos > size / 2 && pos <= size) {
      return true;
    }
    return false;
  }

  private void maxHeapify(int pos) {
    if (isLeaf(pos)) {
      if (HeapOfMax[pos] < HeapOfMax[leftChild(pos)]
          || HeapOfMax[pos] < HeapOfMax[rightChild(pos)]) {
        if (HeapOfMax[leftChild(pos)] > HeapOfMax[rightChild(pos)]) {
          int tmp = HeapOfMax[pos];
          HeapOfMax[pos] = HeapOfMax[leftChild(pos)];
          HeapOfMax[leftChild(pos)] = tmp;
          maxHeapify(leftChild(pos));
        }
        if (HeapOfMax[leftChild(pos)] < HeapOfMax[rightChild(pos)]) {
          int tmp = HeapOfMax[pos];
          HeapOfMax[pos] = HeapOfMax[rightChild(pos)];
          HeapOfMax[rightChild(pos)] = tmp;
          maxHeapify(rightChild(pos));
        }
      }
    }
  }

  private void insert(int data) {
    if (size == maxSize) {
      return;
    } else {
      HeapOfMax[++size] = data;
    }
    int curr = size;
    if (HeapOfMax[curr] > HeapOfMax[parent(curr)]) {
      int tmp = HeapOfMax[curr];
      HeapOfMax[curr] = HeapOfMax[parent(curr)];
      HeapOfMax[parent(curr)] = tmp;
    }
  }

  private void doMaxHeapify() {

    for (int pos = size / 2; pos >= 1; pos--) {
      maxHeapify(pos);
    }
  }
}
