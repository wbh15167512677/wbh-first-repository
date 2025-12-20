public class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int cur = value(s.charAt(i));

            
            if (i + 1 < s.length()) {
                int next = value(s.charAt(i + 1));
                if (cur < next) {
                    ans -= cur;   
                } else {
                    ans += cur;   
                }
            } else {
                ans += cur;       
            }
        }

        return ans;
    }

    
    private int value(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        
        return 1000;
    }
}