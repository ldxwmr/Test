package org.example.arr;

/**
 * @Author ldxwmr
 * @Date 2021/11/29 9:58
 */
public class RemoveDuplicates {
    // 双指针解决
    public int removeDuplicates1(int[] nums) {
        // 边界条件判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            /**
             * 如果做指针和右指针的值一样，说明有重复的，
             * 这个时候左指针不动，有指针继续往右移。如果不一样就把有指针指向的值往前挪
             */
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }

    public int removeDuplicates2(int[] nums) {
        int count = 0;// 重复数字的个数
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] == nums[right - 1]) {
                // 如果有重复的，count要加1
                count++;
            } else {
                // 如果没有重复，后面的就往前挪
                nums[right - count] = nums[right];
            }
        }
        // 数组的长度减去重复的个数
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,3,4,5,5,6};
        System.out.println(new RemoveDuplicates().removeDuplicates1(arr));
        System.out.println(new RemoveDuplicates().removeDuplicates2(arr));
    }
}
