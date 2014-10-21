class Solution {
public:
    int atoi(const char *str) {
        int neg = 1;
        long long result = 0;
        while(*str==' ') ++str;
        if(*str=='-'){ neg = -1;++str;}
        else if(*str=='+')++str;
        if(*str<'0'||*str>'9') return 0;
        while(*str>='0'&&*str<='9'){
            result = result*10+*str++-'0';
            if(result > 2147483647 && neg==1)
                return 2147483647;
            if(result> 2147483648 && neg == -1)
                return -2147483648;
        }
        return result*neg;
    }
};
