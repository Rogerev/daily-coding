class Solution {
    public int minMoves(int[] nums) {
        int max= nums[0];
        for(int i : nums){
            if(i>max){
                max = i;
            }
        }
        int ans =0;
        for (int i : nums){
            ans = ans+max-i;
        }
        return ans;
        
    }
}