class Solution {
public:
    vector<char> table;
    string getPermutation(int n, int k) {
        for(int w = 0 ; w <= n ; ++w)
            table.push_back(w+'0');
        return dp(n,k);
    }
    string dp(int n , int k){
        int t = 1,i,last;
        string result;
        if(k==0){
            for(int j = n ; j>=1 ; --j)
                result.push_back(table[j]);
            return result;
        }
        for(i = 1 ; i <= n ; ++i){
            last = t;
            t *= i;
            if(k<=t) break;
        }
        for(int j = n-i ; j >= 1 ; --j){
            result.insert(result.begin(),table[j]);
            table.erase(table.begin()+j);
        }
        t = k/last + ((k%last)?1:0);
        result.push_back(table[t]);
        table.erase(table.begin()+t);
        return result+dp(i-1,k%last);
    }
};
