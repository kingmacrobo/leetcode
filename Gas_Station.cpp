class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
        int n = gas.size(),lenth=0;
        int result = -1,tank = 0,flag = 1;
        for(int i = 0 ; i < 2*n ; ++i){
            tank += gas[i%n]-cost[i%n];
            if(i<n){
                if(tank<0){
                    result = -1;
                    flag = 1;
                    lenth = 0;
                    tank = 0;
                }
                else{
                    ++lenth;
                    if(flag){
                        result = i;
                        flag = 0;
                    }
                }
            }
            else{
                if(result==-1||lenth==n) break;
                if(tank>=0) ++lenth;
                else return -1;
            }
        }
        return result;
    }
};
