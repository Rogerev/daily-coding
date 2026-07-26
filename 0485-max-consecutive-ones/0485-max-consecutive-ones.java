class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount =0 ;
        int currCount = 0;

        for ( int n : nums){
            if (n == 1){
                currCount ++;
                
            }
            else {
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }
        }
        return maxCount> currCount? maxCount : currCount;        
    }
}