/*************************************************************************
	> File Name: Trapping_Rain_Water.cpp
	> Author: QilongZhang
	> Mail: Speknight4534@gmail.com
	> Created Time: 2014年09月26日 星期五 10时53分01秒
 ************************************************************************/

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution{
public:
    int trap(int A[], int n){
        vector<int> S(n), E(n);
        int ret=0, pt=0;
        for(pt=0; pt<n; ++pt){
            if(pt==0){
                S[pt]=A[pt];
            }
            else{
                S[pt]=max(S[pt-1], A[pt]);
            }   
        }
        for(pt=n-1; pt>=0; --pt){
            if(pt==n-1){
                E[pt]=A[pt];
            }
            else{
                E[pt]=max(E[pt+1], A[pt]);
            }
        }
        for(pt=0; pt<n; ++pt){
            ret+=min(S[pt], E[pt])-A[pt];
        }
        return ret;
    }
};

int main(){
    int A[]={0,1,0,2,1,0,1,3,2,1,2,1};
    Solution st;
    cout<<st.trap(A, 12);
    return 0;
}
