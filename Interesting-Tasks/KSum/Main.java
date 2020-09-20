package com.sakerini;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort !!!!
        return kSum(nums, target, 0, 4);
    }


    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int pointToStart = start, pointToEnd = nums.length - 1;
        while (pointToStart < pointToEnd) {
            int sum = nums[pointToStart] + nums[pointToEnd];
            if (sum < target || (pointToStart > start && nums[pointToStart] == nums[pointToStart - 1]))
                ++pointToStart;
            else if (sum > target || (pointToEnd < nums.length - 1 && nums[pointToEnd] == nums[pointToEnd + 1]))
                --pointToEnd;
            else
                result.add(Arrays.asList(nums[pointToStart++], nums[pointToEnd--]));
        }
        return result;
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        /*
        Check if the sum of k smallest values is greater than target,
        or the sum of k largest values is smaller than target.
        Since the array is sorted, the smallest value is nums[start],
        and largest - the last element in nums.
        If so, no need to continue - there are no k elements that sum to target.
         */
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return result;

        if (k == 2)
            return twoSum(nums, target, start);

        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(set);
                }
        return result;
    }

    public static void main(String[] args) {

    }
}
