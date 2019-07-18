public class Sorting {

  private void bubbleSort(int[] arr) {

    int rightIndex = arr.length - 1;
    while (rightIndex >= 0) {
      for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          swapElements(i, i + 1, arr);
        }
      }
      rightIndex--;
    }

    for (int x : arr) {
      System.out.println(x + " ");
    }
  }

  private void swapElements(int a, int b, int arr[]) {

    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  private void performQuickSort(int arr[]) {

    quickSort(arr, 0, arr.length);
    for (int x : arr) {
      System.out.print(x + " ");
    }
  }

  private void quickSort(int[] arr, int start, int end) {
    if (end - start < 2) {
      return;
    }
    int pivotIndex = performSorting(arr, start, end);
    quickSort(arr, start, pivotIndex);
    quickSort(arr, pivotIndex + 1, end);
  }

  private int performSorting(int arr[], int start, int end) {
    int i = start;
    int j = end;
    int pivotIndex = arr[start];

    while (i < j) {
      while (i < j && arr[--j] >= pivotIndex) ;
      if (i < j) {
        arr[i] = arr[j];
      }
      while (i < j && arr[++i] <= pivotIndex) ;
      if (i < j) {
        arr[j] = arr[i];
      }
    }
    arr[j] = pivotIndex;
    return j;
  }

  public static void main(String args[]) {

    Sorting ss = new Sorting();
    int[] arr = {20, 15, 7, 35, 1, 55, -22};

    // ss.bubbleSort(arr);
    ss.performQuickSort(arr);
  }
}
