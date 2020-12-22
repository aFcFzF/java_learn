/**
 * @file RotateMatrix.java
 * @author afcfzf(9301462@qq.com)
 */

import java.util.*;

// 暴力
public class RotateMatrix {
    public static void main(String[] params) {
        final int[][] mtx = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        final String[] str = Arrays.toString(new RotateMatrix().rotate(mtx));
        System.out.println(str);
        System.out.println(Arrays.toString(new M2().rotate(mtx)));
    }

    public void rotate(int[][] mtx) {
        int last = mtx[0].length - 1;
        int[][] mtxNew = new int[last + 1][last + 1];

        for (int i = last; i >= 0; i--) {
            for (int j = 0; j <= last; j++) {
                mtxNew[i][last - j] = mtx[j][i];
            }
        }

        for (int i = 0; i <= last; i++) {
            for (int j = 0; j <= last; j++) mtx[i][j] = mtxNew[i][j];
        }
    }
}

public class M2 {
    public void rotate(int[][] mtx) {
        int last = mtx[0].length - 1;
        int[][] mtxNew = new int[last + 1][last + 1];

        for (int i = last; i >= 0; i--) {
            for (int j = 0; j <= last; j++) {
                mtxNew[i][last - j] = mtx[j][i];
            }
        }
    }
}
