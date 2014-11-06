class Solution {
public:
    int lengthOfLastWord(const char *s) {
        int len = 0,last = 0;
        while(*s!='\0'){
            len = 0;
            while(*s!='\0' && *s!=' '){
                ++len;
                ++s;
            }
            if(len) last = len;
            if(*s++ == '\0') break;
        }
        return last;
    }
};
