class Solution {
public:
    int findMin(vector<int> &num) {
        int i = 0, j = num.size()-1,k;
        while(i<=j){
            if(i==j||num[i]<num[j]) return num[i];
            k = (i+j)/2;
            if(k+1<=j&&num[k+1]<num[k]) return num[k+1];
            if(k-1>=i&&num[k-1]>num[k]) return num[k];
            if(num[j]<num[k]) i = k+1;
            else if(num[i]<num[k]) j = k-1;
            else{
                num.erase(num.begin()+k);
                --j;
            }
        }
    }
};
