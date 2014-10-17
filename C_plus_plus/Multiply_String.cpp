class Solution {
public:
    string multiply(string num1, string num2) {
        string result;
        int carry = 0;
        if(num1.size()==1&&num1[0]=='0'||num2.size()==1&&num2[0]=='0')
            return "0";
        for(int i = 1 ; i < num1.size()+num2.size(); ++i){
            int sum = carry;
            for(int j = 1 ; j <= num1.size(); ++j){
                if(i+1-j>=1&&i+1-j<=num2.size())
                    sum += (num1[num1.size()-j]-'0')*(num2[num2.size()-1-i+j]-'0');
            }
            carry = sum/10;
            result.insert(result.begin(),sum%10+'0');
        }
        if(carry>0) result.insert(result.begin(),carry+'0');
        return result;
    }
};
