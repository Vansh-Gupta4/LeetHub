class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        int xCurr=startFuel;
        int count=0;
        
          // Max Heap on the basis of fuel value
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->(b-a));
        int i = 0, n = stations.length;
        while (xCurr < target) {
            while (i < n && stations[i][0] <= xCurr) {
                pq.offer(stations[i++][1]);
            }
            if (pq.isEmpty()) return -1;
            xCurr += pq.poll();
            count++;
        }
        return count;
    }
}