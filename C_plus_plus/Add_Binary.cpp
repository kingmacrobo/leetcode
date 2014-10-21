class Solution {
public:
    string addBinary(string a, string b) {
        int la = a.size() , lb = b.size();
        int lenth = la > lb ? lb : la;
        int carry = 0;
        string result;
        for(int i = 1 ; i <= lenth ; ++i){
            result.insert(result.begin(),(a[la-i]-'0'+b[lb-i]-'0'+carry)%2+'0');
            carry = (a[la-i]-'0'+b[lb-i]-'0'+carry)/2;
        }
        if(la>lb){
            for(int i = lenth + 1 ; i <= la ; ++i){
                result.insert(result.begin(),(a[la-i]-+carry)%2+'0');
                carry = (a[la-i]-'0'+carry)/2;                
            }
        }
        if(la<lb){
            for(int i = lenth + 1 ; i <= lb ; ++i){
                result.insert(result.begin(),(b[lb-i]-+carry)%2+'0');
                carry = (b[lb-i]-'0'+carry)/2;                
            }
        }
        if(carry) result.insert(result.begin(),carry+'0');
        return result;
    }
};
