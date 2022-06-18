class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(List<Integer> list :wall){
            int prefixSum=0;
            for(int i=0;i<list.size()-1;i++){
                int val=list.get(i);
                prefixSum+=val;
                map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
                max=Math.max(max,map.get(prefixSum));
            }
        }
        return wall.size()-max;
    }
}