class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res= new ArrayList<>();

        Arrays.sort(nums);

        int curr = nums[0];

        for( int i = 0;i< nums.length;i++ ){
            if(curr<nums[i]){
                res.add(curr);
                i--;
            }
            curr++;
        }
        return res;
    }
}