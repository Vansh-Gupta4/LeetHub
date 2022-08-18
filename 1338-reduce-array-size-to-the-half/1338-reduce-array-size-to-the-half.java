class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[] freq=new int[map.values().size()];
        
        int i=0;
        for(int val:map.values()){
            freq[i]=val;
            i++;
        }
        Arrays.sort(freq);
        int minToRemove=arr.length/2;
        int count=0;
        int j=freq.length-1;
        while(minToRemove>0){
            minToRemove-=freq[j];
            j--;
            count++;
        }
        return count;
    }
}