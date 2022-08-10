class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList < Integer > numbers = new ArrayList < > ();
        for (int i = 1; i < n; i++) {  //(n-1)! nikal lia and 1se n-1 al mai daal dia
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);     //nth no. ko bhi al mai daal diya
        String ans = "";
        k = k - 1;  //as ArrayList is 0th based indexing
        while (true) {
            ans = ans + "" + numbers.get(k / fact);
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
   
}