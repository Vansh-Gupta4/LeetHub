class Solution {
    public int reachNumber(int n) {
    n = Math.abs(n);

    int ans = 0;
 
    while (getsum(ans) < n ||((getsum(ans) - n) & 1) > 0)
        ans++;
 
    return ans;
    }
    static int getsum(int x){
    return (x * (x + 1)) / 2;
    }
}