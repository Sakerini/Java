class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> outputArray = new LinkedList();

        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        outputArray.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return outputArray;
    }


    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int a_pointer = i + 1;
            int b_pointer = nums.length - 1;
            
            while (a_pointer < b_pointer) {
                int current_sum = nums[i] + nums[a_pointer] + nums[b_pointer];
                if (current_sum > target) {
                    b_pointer -= 1;
                } else
                    a_pointer += 1;
                
                if (Math.abs(current_sum - target) < Math.abs(result - target)) {
                    result = current_sum
                }
            }
        }
        return result;
    }

}
