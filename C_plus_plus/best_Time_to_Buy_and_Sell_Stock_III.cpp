class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int max = 0,min;
        vector<int> pre,back;
        if(prices.size()==0) return 0;
        min = prices.front();
        pre.push_back(0);
        for(int i = 1 ; i < prices.size() ; ++i){
            min = min<prices[i]?min:prices[i];
            max = max>prices[i]-min?max:prices[i]-min;
            pre.push_back(max);
        }
        min = prices.back();
        max = 0;
        back.push_back(0);
        for(int i = prices.size()-2 ; i >= 0 ; --i){
            min = min<prices[i]?prices[i]:min;
            max = max>min-prices[i]?max:min-prices[i];
            back.push_back(max);
        }
        max = pre.back();
        for(int i = 0 ; i < prices.size()-1; ++i){
            int tt = pre[i]+back[prices.size()-i-1-1];
            if(max < tt) max = tt;
        }
        return max;
    }
};
