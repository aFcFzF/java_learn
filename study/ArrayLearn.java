package study;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 数组
 * 1. 定义： 字面量？对象？
 * 2. 添加元素
 * 3. 拼接
 * 4. 删除元素
 * 5. 排序：正序、倒序
 * 6. 拷贝
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
    arr2.remove(0);
    System.out.println("==arr result: " + Arrays.deepToString(arr2.toArray()));

    // 排序
  }
}
