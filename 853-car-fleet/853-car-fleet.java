class Solution {
     public int carFleet(int target, int[] pos, int[] speed) {
        int N = pos.length, res = 0;
        double[][] cars = new double[N][2];
        for (int i = 0; i < N; ++i)
            cars[i] = new double[] {pos[i], (double)(target - pos[i]) / speed[i]};
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double cur = 0;
        for (int i = N - 1; i >= 1 ; --i) {
            if (cars[i][1] >= cars[i-1][1] ) {
               cars[i-1][1]  = cars[i][1];
                
            }else{
                res++;
            }
        }
        return res+1;
    }
}