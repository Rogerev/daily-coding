import java.util.*;

class Solution {

    public int fun(int num ){
        int sum =0;

        while (num > 0){
            int d = num % 10;
            num = num / 10;
            sum = sum +d*d;
        }
        return sum;
    }

    public boolean isHappy(int n) {

        int slow =n, fast =n;

        while ( fast!=1){
            slow = fun (slow);
            fast = fun (fast);
            fast = fun ( fast);

            if (slow == fast && slow != 1){
                return false;
            }
        }
        return true;

    }
}