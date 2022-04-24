class Solution {
    public int mctFromLeafValues(int[] arr) {
        if(arr == null || arr.length < 2) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int result =0;
        
        stack.push(Integer.MAX_VALUE);
        
        for(int i=0;i<arr.length;i++){
         
            while(stack.peek() <= arr[i]){
                int smallValue = stack.pop();
                result = result + smallValue*Math.min(stack.peek(),arr[i]);
            }
            stack.push(arr[i]);
        }
        
        
        while(stack.size() > 2){
            result = result + stack.pop()*stack.peek();
        }
        
        return result;
    }
}