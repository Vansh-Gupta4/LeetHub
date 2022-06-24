class Solution {
   public int findShortestSubArray(int[] nums) {
        if (nums.length == 0 || nums == null){
          return 0;  
        } 
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
           if (!map.containsKey(nums[i])){
               map.put(nums[i], new int[]{1, i, i});  // the1st->Freq,2-> first index of this key, 3rd-> last index of this key
           } else {
               int[] temp = map.get(nums[i]);
               temp[0]++; //freq increase
               temp[2] = i;  //end index updated
           }
        }
        int freq = Integer.MIN_VALUE, res = Integer.MAX_VALUE;
        for (int[] value : map.values()){
            if (value[0] > freq){
                freq = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == freq){
                res = Math.min( value[2] - value[1] + 1, res);
            } 
        }
        return res;
    }
}