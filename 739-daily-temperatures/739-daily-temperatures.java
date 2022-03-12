class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int nge[] = new int[arr.length];

        for (int i = 0; i <arr.length; i++){
            if (!s.empty()){
                while (!s.empty() && arr[s.peek()] < arr[i]){
                   int idx = s.pop();
                   nge[idx] = i - idx;
                }
            }
            s.push(i);
        }
        return nge;
    }
}