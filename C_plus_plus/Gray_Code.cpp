class Solution {
public:
    vector<int> grayCode(int n) {
        if(!n) return vector<int>(1,0); 
        vector<bool> hash(1<<n,false);
        vector<int> result;
        result.push_back(0);
        hash[0] = true;
        int val = 0,tt;
        for(int i = 0 ; i < n ; ++i){
            if((val&(1<<i))>0) tt = val&(~(1<<i));
            else tt = val|(1<<i);
            if(!hash[tt]){
                val = tt;
                result.push_back(val);
                hash[val] = true;
                i = -1;
                continue;
            }
        }
        return result;
    }
};
