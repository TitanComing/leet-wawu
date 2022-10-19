package org.peng.array;

/*给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

        示例:

        输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]*/
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int loop = 0; //循环次数
        int start = 0; //每圈循环的起点 [start,start]
        int count = 1; //填充数字
        int i, j;

        while (loop++ < n / 2) {
            //上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            //右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            //下侧从右往左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            //左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }
        return res;
    }
}
