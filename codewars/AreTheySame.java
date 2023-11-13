import java.util.LinkedList;
import java.util.List;

public class AreTheySame {
  public static void main(String[] args) {
    Integer[] arr = { 1, 2, 3, 4, 3 };
    AreTheySame ins = new AreTheySame();
    Integer[] nextArr = ins.removeEl(arr, 3);
    // System.out.println(String.join(",", nextArr));
  }

  private <T> T[] removeEl(T[] arr, T el) {
    List<T> result = new LinkedList<>();

    boolean hasDeled = false;
    for (T element : arr) {
      if (!hasDeled && element.equals(el)) {
        hasDeled = true;
        continue;
      }
      result.add(element);
    }

    T[] res = result.toArray(arr); // cannot convert from Object[] to T[]
    return res;
  }
}
