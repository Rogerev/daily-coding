class Solution {
    public int findDuplicate(int[] nums) {
        
        int left =1;
        int right = nums.length-1;

        while ( left < right){
            int mid = left + ( right-left)/2;
            int cnt = 0;
            for (int i=0;i< nums.length;i++){
                if( nums[i]<= mid ){
                    cnt++;
                }
            }

            if (cnt <= mid){
                left = mid+1;
            }else{
                right=mid;
            }

        }
        return left;
        
    }
}