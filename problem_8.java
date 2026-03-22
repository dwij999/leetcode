class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        // Step 1: Trim leading spaces
        s = s.trim();
        if (s.length() == 0) return 0;

        // Step 2: Handle sign
        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Parse digits
        long result = 0; // use long to detect overflow
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');

            // Step 4: Clamp to 32-bit range
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }

        return (int) result * sign;
    }
}
