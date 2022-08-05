class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        solve(candidates,0,target,list,new ArrayList<>());
        return list;
    }
    public static void solve(int[] arr,int idx,int target, List<List<Integer>> list,List<Integer> tempList){
        if(idx==arr.length){
            if(target==0){
                list.add(new ArrayList <> (tempList));
            }
            return;
        }
       if(arr[idx] <= target){
           tempList.add(arr[idx]);
           solve(arr,idx,target-arr[idx],list,tempList);
           tempList.remove(tempList.size()-1);
       }
        solve(arr,idx+1,target,list,tempList);
    }
}