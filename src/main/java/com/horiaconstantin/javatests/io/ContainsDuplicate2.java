package com.horiaconstantin.javatests.io;

import java.util.Arrays;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
        int[] nums = new int[]{99, 99};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k >= nums.length) {
            Arrays.sort(nums);
            for (int j = 0; j < nums.length - 1; j++)
                if (nums[j] == nums[j + 1]) {
                    return true;
                }
        }

        for (int i = 0; i < nums.length - k; i++) {
            int[] window = Arrays.copyOfRange(nums, i, i + k + 1);
            Arrays.sort(window);
            for (int j = 0; j < window.length - 1; j++)
                if (window[j] == window[j + 1]) {
                    return true;
                }
        }
        return false;
    }
}
