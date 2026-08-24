class Solution {
    public int maximumValue(String[] strs) {
        int n = strs.length, maxValue = 0;

        for(String s : strs){
            if(isInteger(s)){
                maxValue = Math.max(maxValue, Integer.parseInt(s));
            }
            else{
                maxValue = Math.max(maxValue, s.length());
            }
        }
        return maxValue;
    }
    private boolean isInteger(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}