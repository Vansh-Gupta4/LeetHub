class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n=arr.length;
        HashSet<Integer> set = new HashSet<Integer>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
            set.add(i);
        }
        // FINDING THE COMMON DIFFERENCE
        int diff = (max - min);
        if (diff % (n - 1) != 0) {
            return false;
        }
        diff /= n - 1;
        int count = 0;
 
        // CHECK IF PRESENT IN THE HASHSET OR NOT
        while (--n > 0) {
            if (!set.contains(min)) {
                return false;
            }
            min += diff;
        }
        return true;
    }
}