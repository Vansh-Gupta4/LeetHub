class Solution {
    public int findPairs(int[] ans, int k) {
		    int count=0;
			Arrays.sort(ans);
			for(int i=0;i<ans.length;i++){
					if(i>0 && ans[i]==ans[i-1])continue;
					for(int j=i+1;j<ans.length;j++){
							if(j>i+1 && ans[j]==ans[j-1])continue;
							if(Math.abs(ans[i]-ans[j])==k){
									count++;
							}
					}
			}
			return count;
    }
}