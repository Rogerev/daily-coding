import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        char[] arr = s.toCharArray();

        // Step 1: Sort the first half in place
        Arrays.sort(arr, 0, halfLen);

        // Step 2: Mirror the sorted left half to the right half
        for (int i = 0; i < halfLen; i++) {
            arr[n - 1 - i] = arr[i];
        }

        return new String(arr);
    }
}