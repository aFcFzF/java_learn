import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.IntStream;

public class MultiplesOfThreeOrFive {
  private int[] sum(int count) {
    int[] nums = { 3, 5, 6, 9 };
    HashMap<Integer, int[]> map = new HashMap<>();

    int l = 0;
    int r = nums.length > 1 ? nums.length - 1 : 0;
    while (l < r) {
      for (int i = l; i < r; i++) {
        int end = i + 1;
        int[] part = IntStream.rangeClosed(l, end).map(idx -> nums[idx]).toArray();
        int sum = IntStream.of(part).reduce(0, (a, b) -> a + b);

        map.put(nums[l] + nums[end], new int[] { nums[l], nums[end] });
        map.put(sum, part);
      }

      l++;
    }

    // 这样不行，为啥不行，理解不了
    // Integer[][] res = Arrays.copyOf(map.values().toArray(), map.size(),
    // Integer[][].class);
    int[][] res = map.values().toArray(new int[0][]);
    return map.get(count);
  }

  public static void main(String[] args) {
    MultiplesOfThreeOrFive ins = new MultiplesOfThreeOrFive();
    int[] result = ins.sum(20);
    System.out.println("结果: " + Arrays.toString(result));
    System.out.println("结果2: " + ins.splitNum(10));
  }

  private int splitNum(int number) {
    ArrayList<Integer> result = new ArrayList<>();
    int l = 3;
    while (l < number) {
      if (Objects.equals(l % 3, 0) || Objects.equals(l % 5, 0)) {
        result.add(l);
      }
      l++;
    }

    int[] arr = result.stream().mapToInt(Integer::valueOf).toArray();
    System.out.println("结果: " + Arrays.toString(arr));
    return Arrays.stream(arr).reduce(0, (all, item) -> all + item);
  }
}
