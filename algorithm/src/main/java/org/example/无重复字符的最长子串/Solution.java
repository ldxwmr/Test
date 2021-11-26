package org.example.无重复字符的最长子串;

import javax.swing.plaf.SliderUI;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ldxwmr
 * @Date 2021/11/26 10:41
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            Character chars = s.charAt(i);
            if (map.containsKey(chars)) {
                int j = map.get(chars);
                left = Math.max(left,j+1);
            }
            map.put(chars,i);
            int temp = i-left+1;
            max=Math.max(max,temp);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }
}
