/**
 * @file Test.java
 * @author afcfzf(9301462@qq.com)
 */


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 4, 5, 1};
        Arrays.sort(arr, new Comp());

        System.out.println(Arrays.toString(arr));
    }
}

class Comp implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
