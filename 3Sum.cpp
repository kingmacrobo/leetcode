class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
        vector<vector<int>> result;
        int target,last;
        if(num.size()<3) return result;
        sort(num.begin(),num.end());
        for(int w = 0 ; w < num.size() ; ++w){
            if(w>=1&&num[w] == num[w-1]) continue;
            target = -num[w];
            int it1 = w+1 , it2 = num.size()-1;
            while(it1<it2){
                if(num[it1]+num[it2]==target){
                    int sum = num[it1];
                    while((++it1)<it2&&num[it1]==sum);
                    --it1;
                    sum = num[it2];
                    while((--it2)>it1&&num[it2]==sum);
                    ++it2;
                    vector<int> temp{num[it1],num[it2],-target};
                    sort(temp.begin(),temp.end());
                    result.push_back(temp);
                    ++it1;
                    --it2;
                }
                else if(num[it1]+num[it2]<target) ++it1;
                else --it2;
            }
        }
        return result;
    }
};
