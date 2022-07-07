class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
         Arrays.sort(A);
        int count = 0, sum = 0, minPositive = Integer.MAX_VALUE;
        for (int num : A) {
            if (num < 0 && ++count <= K) {
                num = -num;
            }
            sum += num;
            minPositive = Math.min(minPositive, num);
        }
        if (count > K || (K - count) % 2 == 0) {
            return sum;
        } else {
            return sum - minPositive * 2;
        }
    }
}