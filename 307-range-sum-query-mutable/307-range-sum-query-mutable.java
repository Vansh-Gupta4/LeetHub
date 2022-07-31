class NumArray {
    int totalSum=0;
    int[] arr;
    
    public NumArray(int[] nums) {
        int n=nums.length;
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            totalSum+=arr[i];
        }
        
    }
    
    public void update(int index, int val) {
        int prev=arr[index];
        arr[index]=val;
        totalSum=totalSum+val-prev;
    }
    
    public int sumRange(int left, int right) {
        int leftSum=0,rightSum=0;
        for(int i=0;i<left;i++){
            leftSum+=arr[i];
        }
        for(int i=right+1;i<arr.length;i++){
            rightSum+=arr[i];
        }
        return totalSum-leftSum-rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */