class Solution {
    public int maxProfit(int[] prices) {
        int LeastSoFar=Integer.MAX_VALUE;
        int OverallProfit=0;
        int ProfitIfSoldToday=0;

        for (int i = 0; i <prices.length ; i++) {
            if (prices[i]<LeastSoFar){
                LeastSoFar=prices[i];
            }
            ProfitIfSoldToday=prices[i]-LeastSoFar;
            if (ProfitIfSoldToday>OverallProfit){
                OverallProfit=ProfitIfSoldToday;
            }
        }
        return OverallProfit;
    }
}