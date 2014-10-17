class Solution {
public:
    int findMin(vector<int> &num) {
        int i = 0 , j = num.size()-1;
        if(num[0]<=num[j]) return num[0];
        while(i<=j){
            if((i+j)/2>i&&num[(i+j)/2]<num[(i+j)/2-1]) return num[(i+j)/2];
            if((i+j)/2<j&&num[(i+j)/2]>num[(i+j)/2+1]) return num[(i+j)/2+1];
            if(num[(i+j)/2]<num[i]) j = (i+j)/2-1;
            else i = (i+j)/2+1;
        }
    }
};
