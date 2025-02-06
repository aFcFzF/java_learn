package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 数组
 * 1. 定义： 字面量？对象？
 * 2. 添加元素
 * 3. 拼接
 * 4. 删除元素
 * 5. 排序：正序、倒序
 * 6. 深拷贝
 * 7. 联合类型
 */
public class ArrayLearn {
  public static void main(String[] args) {
    int[] ids = { 1, 2, 3 };
    String[] strings = { "1", "2" };
    char[] chars = new char[3];

    System.out.printf("%s%s%s\n", ids, strings, chars);

    // 添加元素
    LinkedList<Integer> arr = new LinkedList();
    for (int i : ids) {
      arr.add(i);
    }
    arr.add(1, 0);

    LinkedList<Integer> arr2 = new LinkedList<>();
    arr2.add(9);
    arr2.addAll(arr);

    arr2.remove(2);
    // arr2.remove(0);

    // 排序
    arr2.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer a, Integer b) {
        return a - b;
      }
    });

    // toArray 还需要转类型?
    Integer[] arr3 = Arrays.copyOf(arr2.toArray(), arr2.size(), Integer[].class);

    Arrays.sort(arr3, (a, b) -> b - a);
    System.out.println("==arr result: " + Arrays.deepToString(arr2.toArray()));
    System.out.println("==arr3 result: " + Arrays.toString(arr3));

    Integer[] cArr = {1, 2, 3};
    Integer[] dArr = Arrays.copyOf(cArr, cArr.length);
    dArr[0] = 999;

    System.out.println("==cArr result: " + Arrays.deepToString(cArr));
    System.out.println("==dArr result: " + Arrays.deepToString(dArr));

    ArrayLearn ins = new ArrayLearn();
    ins.union();
  }

  private void union() {

  }
}
