package org.example.array;

import static org.example.array.Util.printArray;

/**
 * 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Rotate {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = arr1;
        int[] arr3 = new int[3];
        arr3 = arr1;
        int[] arr4 = new int[3];
        for (int i = 0; i < arr1.length; i++) {
            arr4[i] = arr1[i];
        }
        arr1[0] = 0;


        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};


        rotate(matrix);
        printArray(matrix);
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] matrixNew = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrixNew[i][j] = matrix[i][j];
            }
        }
        int z = 0;
        for (int j = matrix.length - 1; j >= 0; j--) {
            for (int i = 0; i < length; i++) {
                matrix[i][j] = matrixNew[z][i];
            }
            z++;
        }
    }
}
