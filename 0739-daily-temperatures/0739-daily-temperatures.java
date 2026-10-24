class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] warmerDays = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                warmerDays[i] = st.peek() - i;
            }
            st.push(i);
        }
        return warmerDays;
    }
}