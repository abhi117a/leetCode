public class QuickSort {

  private void quickSortbegin(int[] arr) {
    int i = 0;
    int j = arr.length - 1;
    performQuickSort(arr, i, j);
    for (int x : arr) {
      System.out.println(x);
    }
  }

  private void performQuickSort(int[] arr, int i, int j) {

    if (j - i < 2) {
      return;
    }

    int pivotIndex = doQuickSort(arr, i, j);
    performQuickSort(arr, pivotIndex, j);
    performQuickSort(arr, i, pivotIndex);
  }

  private int doQuickSort(int[] arr, int i, int j) {
    int pivotIndex = arr[i];
    while (i < j) {
      if (i < j && arr[--j] >= pivotIndex) ;
      if (i < j) {
        arr[i] = arr[j];
      }
      if (i < j && arr[++i] <= pivotIndex) ;
      if (i < j) {
        arr[j] = arr[i];
      }
    }
    arr[j] = pivotIndex;
    return j;
  }
}
