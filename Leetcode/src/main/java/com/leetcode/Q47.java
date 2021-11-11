package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        boolean[] records = new boolean[length];
        doTree(nums, records, 0, tmp);
        return result;
    }

    private void doTree(int[] nums, boolean[] records, int deep, List<Integer> tmp) {
        if (deep == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (records[i] || (i > 0 && nums[i] == nums[i - 1] && !records[i - 1])) {
                continue;
            }
            records[i] = true;
            tmp.add(nums[i]);
            doTree(nums, records, deep + 1, tmp);
            records[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }


    // Q46
    /*public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        boolean[] records = new boolean[length];
        doTree(nums, records, tmp);
        return result;
    }

    private void doTree(int[] nums, boolean[] records, List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (records[i]) {
                continue;
            }
            records[i] = true;
            tmp.add(nums[i]);
            doTree(nums, records, tmp);
            records[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }*/
}
