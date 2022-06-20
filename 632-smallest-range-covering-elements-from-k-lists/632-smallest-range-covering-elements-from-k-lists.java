class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int minx=Integer.MAX_VALUE;
        int maxy=Integer.MIN_VALUE;
        int minRange=Integer.MAX_VALUE;
        PriorityQueue<int[]> pq=new PriorityQueue<>((i,j) -> i[0] - j[0]);
        
        for(int i=0;i<nums.size();i++){
            //get the maximun value from first element of every list 
            if(nums.get(i).get(0)>maxy){
                maxy=nums.get(i).get(0);
            }
            //dumping the value in min heap based on the values
            pq.offer(new int[] {nums.get(i).get(0),i,0});
        }
        while(!pq.isEmpty()){
            //get the min-value from the heap
            int[] min=pq.poll(); 
            int val=min[0];
            int rowNo=min[1];
            int idx=min[2];
            
//compare the value of min value with max value and updayte the minrange which would be storing the answer
            if(maxy-val<minRange){
                minRange=maxy-val;
                res[0]=val;
                res[1]=maxy;
            }
            
//get the next value from the list in which the minimum is found and update the value of min-heap and maxy accordingly. 
            if(rowNo<nums.size() && idx+1<nums.get(rowNo).size()){
                pq.offer(new int[]{nums.get(rowNo).get(idx+1),rowNo,idx+1});
                if(nums.get(rowNo).get(idx+1)>maxy){
                    maxy=nums.get(rowNo).get(idx+1);
                }
            }else{ //If any of the list is traversed, break out of the loop
                break;
            }           
        }
        return res;
    }
}