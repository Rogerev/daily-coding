class Solution {
    public int maximumSum(int[] arr) {
        int max_no_delete = arr[0];
        int max_one_delete = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length ; i++){
            int prev_no_delete = max_no_delete;

            max_no_delete = Math.max( max_no_delete + arr[i], arr[i]);

            max_one_delete= Math.max( max_one_delete +arr[i], prev_no_delete);

            result = Math.max(result , Math.max( max_no_delete, max_one_delete)); 
        }
        return result;        
    }
}

// class Solution {
//     public int maximumSum(int[] arr) {
//         int noDelete=arr[0];
//         int oneDelete=0; 
//         int ans=noDelete;
//         for(int i=1;i<arr.length;i++){
//             int prevNoDelete=noDelete;
//             int prevOneDelete=oneDelete;
//             noDelete=Math.max(prevNoDelete+arr[i],arr[i]);
//             oneDelete=Math.max(prevOneDelete+arr[i],prevNoDelete);
//             ans=Math.max(ans,Math.max(noDelete,oneDelete));
//         }
//         return ans;
//     }
// }