// https://leetcode.com/problems/reordered-power-of-2/discuss/2481219/Quick-Math
class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] number = sortedDigits(n);

        for (int i = 0; i < 30; ++i) {
            char[] powerOfTwo = sortedDigits(1 << i);
            if (Arrays.equals(number, powerOfTwo))
                return true;
        }
        return false;
    }

    private char[] sortedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits);
        return digits;
    }
}