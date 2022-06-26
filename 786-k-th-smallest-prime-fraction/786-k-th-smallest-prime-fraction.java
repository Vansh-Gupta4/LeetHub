class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return A[o1[0]] * A[o2[1]] - A[o1[1]] * A[o2[0]];
            }
        };
        int n = A.length;
        // Min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
        for(int i = 0; i < n - 1; i++) {
            pq.add(new int[] {i, n-1});
            if(i == K-1) {
                break;
            }
        }
        while(!pq.isEmpty()) {
            if(--K == 0) {
                break;
            }
            int[] top = pq.poll();
            top[1]--;
            if(top[1] > top[0]) {
                pq.add(top);
            }
        }
        return new int[] {A[pq.peek()[0]], A[pq.peek()[1]]};      
    }
}