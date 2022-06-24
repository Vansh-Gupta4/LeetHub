class Solution {
    public boolean isPossible(int[] arr) {
        long sum=0;
        PriorityQueue<Long> pq=new  PriorityQueue<>(Collections.reverseOrder());
        for(int el:arr){
            pq.add((long)el);
            sum+=el;
        }
        while(pq.peek()!=1){
            long top=pq.poll();
            sum=sum-top;
            if(sum<=0 || sum>=top){
                return false;
            }
            top=top%sum;
            sum=sum+top;
            pq.add(top>0?top:sum);
        }
        return true;
    }
}