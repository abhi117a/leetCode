// Implementation of Min Heap
public class MinHeap {
  private int size;
  private int maxSize;
  private int[] Heap;

  public MinHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    Heap = new int[maxSize + 1];
    Heap[0] = Integer.MIN_VALUE; // We start our heap from index 1
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

  private void swap(int fpos, int spos) {
    int temp = Heap[fpos];
    Heap[fpos] = Heap[spos];
    Heap[spos] = temp;
  }

  private boolean isLeaf(int pos) {
    if (pos >= size / 2 && pos <= size) {
      return true;
    }
    return false;
  }

  private void minHeapify(int pos) {

    if (!isLeaf(pos)) {

      if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
        if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
          swap(pos, leftChild(pos));
          minHeapify(leftChild(pos));
        } else {
          swap(pos, rightChild(pos));
          minHeapify(rightChild(pos));
        }
      }
    }
  }
}
