class Solution {
    public int removeCoveredIntervals(int[][] A) {
        Arrays.sort(A, (a, b) ->(a[0]==b[0]?b[1]-a[1]: a[0] - b[0]));
        int res = 0, prevRange = -1;
        for (int[] v : A) {
            if (prevRange>= v[1]) {
                res++;
            }
            prevRange = Math.max(prevRange, v[1]);
        }
        return A.length-res;

    }
}