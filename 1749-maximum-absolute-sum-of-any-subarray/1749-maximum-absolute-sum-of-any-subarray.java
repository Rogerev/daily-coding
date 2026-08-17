class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_sum =nums[0];
        int max = nums[0];
        int min = nums[0];    
        int min_sum = nums[0];
        for (int i = 1; i< nums.length; i++){
            max = Math.max(max + nums[i], nums[i]);
            max_sum = Math.max( max, max_sum);

            min = Math.min (min + nums[i], nums[i]);
            min_sum = Math.min(min, min_sum);
        }
        return Math.max(max_sum, Math.abs(min_sum));

    }
}