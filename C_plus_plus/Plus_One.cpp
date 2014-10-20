class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        int carry = 1;
        for(int i = digits.size()-1;i>=0 ; --i){
            int t= carry+digits[i];
            digits[i] = t%10;
            if(!(carry = t/10)) break;
        }
        if(carry) digits.insert(digits.begin(),carry);
        return digits;
    }
};
