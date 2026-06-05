class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) != (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {
            long temp = b;
            int count = 1;

            while (a >= temp + temp) {
                temp += temp;
                count += count;
            }

            a -= temp;
            result += count;
        }

        if (negative) {
           return -result;
        } else {
             return result;
          }
    }
}