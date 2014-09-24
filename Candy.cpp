class Solution {
public:
    int candy(vector<int> &ratings) {
        int result = 0,tmp;
        if(ratings.size()<=1)
            return ratings.size();
        vector<int> record;
        for(int i = 0 ; i < ratings.size() ; ++i){
            if(i==0&&ratings[0]<=ratings[1]){
                record.push_back(0);
                tmp = ratings[0];
                ++i;
                while(i<ratings.size()&&ratings[i]==tmp) ++i;
                --i;
            }
            else if(i==ratings.size()-1&&ratings[i]<=ratings[i-1]){
                record.push_back(i);
            }
            else{
                if(ratings[i]<=ratings[i-1]&&ratings[i]<=ratings[i+1]){
                    record.push_back(i);
                    tmp = ratings[i];
                    ++i;
                    while(i<ratings.size()&&ratings[i]==tmp) ++i;
                    --i;
                    
                }
            }
        }
        result  = record.size();
        for(int i = 0 ; i < record.size(); ++i){
            if(i==0&&record[i]-1>=0){
                int base = 1;
                for(int j = record[i]-1; j >= 0 ; --j){
                    if(ratings[j]>ratings[j+1]) ++base;
                    result += base;
                }
            }
            if(i==record.size()-1&&record[i]+1<=ratings.size()-1){
                int base = 1;
                for(int j = record[i]+1; j <= ratings.size()-1;++j){
                    if(ratings[j] > ratings[j-1]) ++base;
                    result += base;
                }
            }
            if(i+1<=record.size()-1){
                int s,t,base1 = 1,base2 =1,max = 0;
                for(int j = record[i]+1;j<=record[i+1]-1;++j) if(max<ratings[j]) max = ratings[j];
                for(s = record[i]+1;ratings[s]<max;++s){
                    if(ratings[s]>ratings[s-1]) ++base1;
                    result += base1;
                }
                for(t = record[i+1]-1;ratings[t]<max;--t){
                    if(ratings[t]>ratings[t+1]) ++base2;
                    result += base2;
                }
                ++base1;
                ++base2;
                if(t-s+1>1){
                    result += (base1>base2?base1:base2)+(base1<base2?base1:base2)*(t-s);
                }
                else result += base1>base2?base1:base2;
            }
        }
        return result;
    }
};
