class Solution {
public:
    bool isPalindrome(string s) {
        if(s.size()==0) return true;
        int i = 0, j = s.size()-1;
        while(i<=j){
            while(i<=j&&!isAlphanumeric(s[i])) ++i;
            while(i<=j&&!isAlphanumeric(s[j])) --j;
            if(i>j) return true;
            if(abs(s[i]-s[j])==0||abs(s[i]-s[j])==abs('a'-'A')){
                ++i;
                --j;
            }
            else return false;
        }
        return true;
    }
    bool isAlphanumeric(char c){
        if(c<='9'&&c>='0'||c<='z'&&c>='a'||c<='Z'&&c>='A') return true;
        return false;
    }
};
