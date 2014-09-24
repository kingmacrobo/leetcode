#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    struct point{
        int x;
        int y;
        int sum;
        point(int x,int y):x(x),y(y){}
    };
    static bool compare(const point &a,const point &b){
        return a.sum<b.sum;
    }
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        vector<point> p;
        vector<vector<int>> result;
        if(num.size()<4) return result;
        for(int i = 0 ; i < num.size()-1; ++i){
            for(int j = i+1; j < num.size(); ++j){
                point t(i,j);
                t.sum = num[i]+num[j];
                p.push_back(t);
            }
        }
        sort(p.begin(),p.end(),compare);
        vector<point>::iterator it1 = p.begin(),it2 = p.end()-1;
        while(it1<it2){
            if(it1->sum+it2->sum==target){
                vector<point> p1,p2;
                p1.push_back(*it1);
                p2.push_back(*it2);
                int sum = it1->sum;
                while((++it1)<it2&&it1->sum==sum) p1.push_back(*it1);
                sum = it2->sum;
                while((--it2)>it1&&it2->sum==sum) p2.push_back(*it2);
                for(int i = 0 ; i < p1.size(); ++i){
                    for(int j = 0; j < p2.size(); ++j){
                        if(p1[i].x!=p2[j].x&&p1[i].x!=p2[j].y&&p1[i].y!=p2[j].x&&p1[i].y!=p2[j].y){
                            vector<int> temp;
                            temp.push_back(num[p1[i].x]);
                            temp.push_back(num[p1[i].y]);
                            temp.push_back(num[p2[j].x]);
                            temp.push_back(num[p2[j].y]);
                            sort(temp.begin(),temp.end());
                            vector<vector<int>>::iterator itfind = find(result.begin(),result.end(),temp);
                            if(itfind==result.end()) result.push_back(temp);
                        }
                    }
                }
            }
            else if(it1->sum+it2->sum<target) ++it1;
            else --it2;
        }
        return result;
    }
};
int main()
{
    vector<int> a={};
    Solution st;
    vector<vector<int>> result = st.fourSum(a,0);
    return 0;
}