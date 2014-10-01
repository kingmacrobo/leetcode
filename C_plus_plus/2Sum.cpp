class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        vector<int> result,tmp = numbers;
        int a = 0,b = 0;
        sort(tmp.begin(),tmp.end());
        int i = 0 ,j = tmp.size()-1;
        while(i<j){
            if(tmp[i]+tmp[j] == target) break;
            else if (tmp[i]+tmp[j] > target) --j;
            else ++i;
        }
        for(int w = 0 ; (!a||!b)&&w < numbers.size();++w){
            if((!a)&&numbers[w] == tmp[i]) a = w+1;
            else if(numbers[w] == tmp[j]) b = w+1;
        }
        result.push_back(a<b?a:b);
        result.push_back(a>b?a:b);
        return result;
    }
};
