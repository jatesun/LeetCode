package com.jatesun.array;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例2
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 */
public class GenerateMatrix_59 {
    public static void main(String[] args) {
        GenerateMatrix_59 generateMatrix = new GenerateMatrix_59();
        int[][] result = generateMatrix.generateMatrix(3);
        System.out.println(Arrays.deepToString(result));
    }

    /**
     * 直观算法很简单，就是用算法模拟螺旋矩阵构造的过程.
     * 其中分为左→右，上→下，右→左，下→上，循环往复。结束的标志为四个划线的起始位置都相同
     * 划线的规则都是左闭右开。每个方向都有当前行，当前开始的元素，当前结束标志的元素。
     * 时间复杂度（显而易见的为O(n)），本题讲的是边界的计算。
     */
    public int[][] generateMatrix(int n) {
        int curVal = 1;
        int[][] result = new int[n][n];
        int leftRow = 0;//从第一行开始
        int leftStart = 0;//开始
        int leftEnd = n - 1;//结束
        //------------
        int upCol = n - 1;//从最后一列开始
        int upStart = 0;//
        int upEnd = n - 1;
        //-----------右-左
        int rightRow = n - 1;
        int rightStart = n - 1;
        int rightEnd = 0;
        //---------------下上
        int downCol = 0;
        int downStart = n - 1;
        int downEnd = 0;
        //todo 判断是否结束
        while (true) {
            if (leftRow >= upCol) {//说明结束了
                if (n % 2 == 1) {
                    result[leftRow][upCol] = n * n;
//                    System.out.println("数组索引" + leftRow + "," + upCol + "的值为" + n * n);
                }
                break;
            }
            //画左-右
            for (int j = leftStart; j < leftEnd; j++) {
                result[leftRow][j] = curVal;
//                System.out.println("数组索引" + leftRow + "," + j + "的值为" + result[leftRow][j]);
                curVal++;
            }
            //重新计算
            leftRow++;
            leftStart++;
            leftEnd--;
            //-----------------------画上下。
            for (int k = upStart; k < upEnd; k++) {
                result[k][upCol] = curVal;
//                System.out.println("数组索引" + k + "," + upCol + "的值为" + result[k][upCol]);
                curVal++;
            }
            upCol--;
            upStart++;
            upEnd--;
            //-------------------------右左
            for (int m = rightStart; m > rightEnd; m--) {
                result[rightRow][m] = curVal;
//                System.out.println("数组索引" + rightRow + "," + m + "的值为" + result[rightRow][m]);
                curVal++;
            }
            rightRow--;
            rightStart--;
            rightEnd++;
            //------------------------下上
            for (int i = downStart; i > downEnd; i--) {
                result[i][downCol] = curVal;
//                System.out.println("数组索引" + i + "," + downCol + "的值为" + result[i][downCol]);
                curVal++;
            }
            downCol++;
            downStart--;
            downEnd++;

        }
//        return null;
        return result;
    }
}
