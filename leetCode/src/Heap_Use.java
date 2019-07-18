import java.util.*;
import java.util.Arrays;

public class Heap_Use {

  private void kClosestPoints(int[][] points, int K) {

    PriorityQueue<int[]> maxHeapi =
        new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1]));

    for (int[] point : points) {
      System.out.println(point);
      int tmp[][];
      maxHeapi.add(point);
      if (maxHeapi.size() > K) {
        maxHeapi.remove();
      }
    }
    int[][] result = new int[K][2];
    while (K-- > 0) {
      result[K] = maxHeapi.remove();
    }
  }

  private void meetRooms(int[][] intervals) {

    if (intervals == null || intervals.length == 0) {
      return;
    }

    /*Arrays.sort(
    intervals,
    new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        Integer start1 = o1[0];
        Integer start2 = o2[0];

        return start1.compareTo(start2);
      }
    });*/
    // Use Lambda

    Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
    minHeap.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {

      int[] curr = intervals[i];
      int[] earliest = minHeap.remove();
      if (curr[0] >= earliest[1]) {
        earliest[1] = curr[1];
      } else {
        minHeap.add(curr);
      }
      minHeap.add(earliest);
    }
    System.out.println(minHeap.size() + " Size");
  }

  // Merge K sorted List (List of an Array)
  private void mergeKSortedList(ArrayList<ArrayList<Integer>> lists) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    lists.stream().flatMap(x -> x.stream().map(y -> minHeap.add(y))).count();
    while (!minHeap.isEmpty()) {
      System.out.println(minHeap.remove().toString());
    }
  }

  private void SortCharactersByFrequency(String s) {
    HashMap<Character, Integer> hm = new HashMap<>();
    PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));

    for (int i = 0; i < s.length(); i++) {
      int tmp = hm.getOrDefault(s.charAt(i), 0);
      hm.put(s.charAt(i), ++tmp);
    }
    pq.addAll(hm.keySet());

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      char x = pq.remove();
      for (int i = 0; i < hm.get(x); i++) {
        sb.append(x);
      }
    }
  }
  // 215. Kth Largest Element in an Array Leetcode
  private int kthlargestElement(int nums[], int k) {

    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    for (int x : nums) {
      pq.add(x);
    }
    while (k > 1) {
      pq.remove();
      k--;
    }
    int answer = pq.remove();
    return answer;
  }

  public static void main(String[] args) {
    Heap_Use hu = new Heap_Use();

    int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
    int[][] meet = {{2, 4}, {7, 10}};

    // hu.kClosestPoints(points, 2);
    hu.meetRooms(meet);

    //
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    List<Integer> li1 = new ArrayList();
    li1.add(10);
    li1.add(2);
    List<Integer> li2 = new ArrayList<>();
    li2.add(5);
    li2.add(68);
    List<Integer> li3 = new ArrayList<>();
    li3.add(-1);
    li3.add(12);
    lists.add((ArrayList<Integer>) li1);
    lists.add((ArrayList<Integer>) li2);
    lists.add((ArrayList<Integer>) li3);

    hu.mergeKSortedList(lists);
  }
}
