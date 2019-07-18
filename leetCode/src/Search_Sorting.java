import java.util.Arrays;

public class Search_Sorting {

  private int binarySearch(int[] arr, int lo, int hi, int target) {

    if (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] > target) {
        return binarySearch(arr, lo, mid - 1, target);
      } else {
        return binarySearch(arr, mid + 1, hi, target);
      }
    }
    return -1;
  }

  private boolean binarySearchRoatatd(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) return true;

      if (nums[left] < nums[mid]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[left] > nums[mid]) {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        left++;
      }
    }

    return false;
  }

  public static void main(String args[]) {
    Search_Sorting ss = new Search_Sorting();
    int[] arr = {1, 2, 3, 4, 5, 6};
    System.out.println(Arrays.binarySearch(arr, 5));
    // System.out.println(ss.binarySearch(arr, 0, 6, 5));
  }
}
