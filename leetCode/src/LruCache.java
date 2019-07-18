import java.util.LinkedHashMap;

public class LruCache extends LinkedHashMap<Integer, Integer> {

  LruCache(int capacity) {
    super(capacity, 0.75F, true);
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  public int put(int key, int value) {
    return super.put(key, key);
  }
}
