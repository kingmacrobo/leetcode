class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        int k,a,v,c,n;
        sort(num.begin(),num.end());
        n = 99999999;
        for(int w = 0 ; w < num.size() ; ++w){
            if(w>=1&&num[w] == num[w-1]) continue;
            k = target-num[w];
            int it1 = w+1 , it2 = num.size()-1;
            while(it1<it2){
                if(abs(k-num[it1]-num[it2])<n){
                    n = abs(k-num[it1]-num[it2]);
                    a = w;
                    v = it1;
                    c = it2;
                    if(n==0) return target;
                }
                if(num[it1]+num[it2]==k) return target;
                else if(num[it1]+num[it2]<k) ++it1;
                else --it2;
            }
        }
        return num[a]+num[v]+num[c];
    }
};
