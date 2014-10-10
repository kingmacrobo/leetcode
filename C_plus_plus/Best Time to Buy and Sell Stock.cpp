class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int start,end;
        int max = 0;
        if(prices.size()==0) return 0;
        start = end = prices[0];
        for(int i = 1; i < prices.size(); ++i){
            if(prices[i]>=prices[i-1]){
                end = prices[i];
            }
            else{
                if(max < end - start) max = end - start;
                if(start>prices[i]) start = prices[i];
                end = prices[i];
            }
        }
        if(max < end - start) max = end - start;
        return max;
    }
};
