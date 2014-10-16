class Solution {
public:
    string intToRoman(int num) {
        vector<vector<string>> table = 
        {{"","I","II","III","IV","V","VI","VII","VIII","IX"},
         {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
         {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
         {"","M","MM","MMM"}};
        int i = 0;
        string result;
        while(num){
            result.insert(0,table[i++][num%10]);
            num /= 10;
        }
        return result;
    }
};
