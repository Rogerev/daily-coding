class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        // Frequency of characters in s
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Try the position where we make the string greater.
        // Rightmost position is preferred.
        for (int i = n - 1; i >= 0; i--) {

            // Rebuild the frequency array for this pivot.
            int[] remain = cnt.clone();

            // Try to keep target[0 ... i-1] unchanged.
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (remain[x] == 0) {
                    possible = false;
                    break;
                }

                remain[x]--;
            }

            if (!possible)
                continue;

            // At position i, we need the smallest
            // available character strictly greater than target[i].
            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remain[c] == 0)
                    continue;

                StringBuilder ans = new StringBuilder(target.substring(0, i));

                // Make the first difference here.
                ans.append((char) ('a' + c));

                remain[c]--;

                // Fill the rest in sorted order.
                for (int x = 0; x < 26; x++) {
                    for (int t = 0; t < remain[x]; t++) {
                        ans.append((char) ('a' + x));
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }
}

// class Solution {

//     public String lexGreaterPermutation(String s, String target) {

//         int n = s.length();

//         // Frequency of characters in s
//         int[] count = new int[26];

//         for (char ch : s.toCharArray()) {
//             count[ch - 'a']++;
//         }

//         /*
//          * First, try to match target from left to right.
//          *
//          * If we can match:
//          * target[0], target[1], ..., target[i-1]
//          *
//          * then count[] contains all unused characters.
//          */
//         int matched = 0;

//         while (matched < n) {

//             int c = target.charAt(matched) - 'a';

//             if (count[c] == 0) {
//                 break;
//             }

//             count[c]--;
//             matched++;
//         }

//         /*
//          * Now we need to make the answer strictly greater.
//          *
//          * Start from the rightmost possible position and move left.
//          */
//         for (int pos = Math.min(matched, n - 1); pos >= 0; pos--) {

//             /*
//              * When we move to pos, the character target[pos]
//              * has to become available again.
//              *
//              * This is necessary because it was used while matching
//              * the target prefix.
//              */
//             if (pos < matched) {
//                 count[target.charAt(pos) - 'a']++;
//             }

//             int targetChar = target.charAt(pos) - 'a';

//             // Find the smallest available character > target[pos]
//             for (int c = targetChar + 1; c < 26; c++) {

//                 if (count[c] > 0) {

//                     // Choose this character
//                     count[c]--;

//                     StringBuilder result = new StringBuilder();

//                     // Prefix remains equal to target
//                     result.append(target, 0, pos);

//                     // Make this position slightly larger
//                     result.append((char) ('a' + c));

//                     // Put remaining characters in ascending order
//                     for (int x = 0; x < 26; x++) {
//                         while (count[x] > 0) {
//                             result.append((char) ('a' + x));
//                             count[x]--;
//                         }
//                     }

//                     return result.toString();
//                 }
//             }
//         }

//         return "";
//     }
// }