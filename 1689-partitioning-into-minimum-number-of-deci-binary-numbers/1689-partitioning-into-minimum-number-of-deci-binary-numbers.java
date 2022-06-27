class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++){
            char ch=n.charAt(i);
            max=Math.max(max,ch-'0');
        }
        return max;
    }
}