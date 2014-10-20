class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int temp = x,lenth = 1,digits = 1;
        while(temp/10){
            temp /= 10;
            ++lenth;
            digits *= 10;
        }
        for(int i = 0; i< lenth/2 ; ++i){
            if(x%10!=(temp=x/digits)) return false;
            x /= 10;
            x -= temp*digits/10;
            digits /=100;
        }
        return true;
    }
};
