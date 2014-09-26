class Solution {
public:
    int trap(int A[], int n) {
        vector<int> max;
        int result = 0;
        if(n <= 1 ) return 0;
        for(int i = 0 ; i < n ; ++i){
            if(i == 0){ if(A[i]>A[i+1]) max.push_back(i); }
            else if(i == n-1){ if(A[i]>A[i-1]) max.push_back(i); }
            else{ if(A[i]>=A[i-1] && A[i]>=A[i+1]) max.push_back(i); }
        }
        if(max.size()<=1) return 0;
        int start=0,last=0,max2=-1,maxloc=-1;
        for(int i = 1 ; i < max.size(); ++i){
            if(max2<A[max[i]]){
                max2 = A[max[i]];
                maxloc = i;
            }
            if(A[max[start]]<=A[max[i]]){
                last = i;
                for(int j = max[start]+1 ; j <= max[last]-1; ++j) 
                    result += (A[max[start]] - A[j])>0?(A[max[start]] - A[j]):0;
                start = i;
                max2 = -1;
                maxloc = -1;
                continue;
            }
            if(i == max.size()-1){
                for(int j = max[start]+1 ; j <= max[maxloc]-1; ++j)
                    result += (A[max[maxloc]] - A[j])>0?(A[max[maxloc]] - A[j]):0;
                last = i = start = maxloc;
                max2 = -1;
                maxloc = -1;
            }
        }
        return result;
    }
};
