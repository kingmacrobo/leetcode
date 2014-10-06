class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        unordered_map<int,int> hash;
        int max = 0,count,j;
        unordered_map<int,int>::iterator it;
        for(int i = 0 ; i < num.size(); ++i) hash.insert({num[i],-1});
        for(int i = 0 ; i < num.size(); ++i){
            if(hash.find(num[i])->second!=-1) continue;
            count = 1;
            j = num[i]+1;
            while((it=hash.find(j++))!=hash.end()){
                if(it->second > 0){
                    count += it->second;
                    break;
                }
                it->second = 0;
                ++count;
            }
            hash.find(num[i])->second = count;
            if(max < count) max = count;
        }
        return max;
    }
};
