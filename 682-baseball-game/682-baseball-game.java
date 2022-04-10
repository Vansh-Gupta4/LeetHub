class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("C")){
                stack.pop();
            }else  if(ops[i].equals("D")){
                stack.push(2*stack.peek());
            }else  if(ops[i].equals("+")){
               
                int x=stack.pop();
                int y=stack.peek();
                stack.push(x);
                stack.push(x+y);
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        int ans=0;
        while(stack.size()!=0){
            int z=stack.pop();
            ans+=z;
        }
        return ans;
    }
}