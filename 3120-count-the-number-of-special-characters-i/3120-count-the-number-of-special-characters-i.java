class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;

        HashSet<Character> set = new HashSet<>();

        for( char ch : word.toCharArray()){
            set.add(ch);
        }
        for (char ch = 'a';ch<='z';ch++){
            if (set.contains(ch) && set.contains((char)(ch-'a'+'A'))){
                count++;

            }
        }
        return count;
    }
}