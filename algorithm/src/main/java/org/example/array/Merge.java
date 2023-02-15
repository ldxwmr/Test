package org.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Merge {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int[] interval : merge) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }

    }

    public static int[][] merge(int[][] intervals) {
        //获取intervals中的最大值
        int maxVal = 0;
        for (int[] interval : intervals) {
            if (interval[1] > maxVal)
                maxVal = interval[1];
        }

        //新建左右边界数组，数组中包含边界值0~maxVal，即有maxVal + 1个值
        maxVal += 1;
        int[] leftBoundary = new int[maxVal];
        int[] rightBoundary = new int[maxVal];

        for (int[] interval : intervals) {//遍历intervals
            //interval[0]表示当前区间的左边界，在leftBoundary中标记该左边界，+1
            leftBoundary[interval[0]]++;
            //interval[1]表示当前区间的右边界，在leftBoundary中标记该右边界，-1
            rightBoundary[interval[1]]--;
        }

        int left = -1;
        int num = 0;
        List<int[]> result = new ArrayList<>();
        for (int boundary = 0; boundary < maxVal; boundary++) {
            num += leftBoundary[boundary];
            if (left == -1 && num > 0) {
                left = boundary;
            }
            num += rightBoundary[boundary];
            if (left > -1 && num == 0) {
                result.add(new int[]{left, boundary});
                left = -1;
            }
        }

        int[][] resultToArray = new int[result.size()][2];
        int j = 0;
        for (int[] i : result) {
            resultToArray[j++] = i;
        }
        return resultToArray;
    }
}
