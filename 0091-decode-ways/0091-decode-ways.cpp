class Solution {
public:
    int numDecodings(string prefix, string suffix, unordered_map<string, int>& memo){
        if(memo.find(prefix)!=memo.end())return memo[prefix];
        if(suffix=="") return 1;
        if(suffix[0]=='0') return 0;
        if(suffix.size()==1) return 1;

        int c1=0, c2=0;
        c1 = numDecodings(prefix+suffix[0], suffix.substr(1), memo);
        if(suffix.size()>=2 && (suffix[0]=='1' && suffix[1]-'0'<=9) || ( suffix[0]=='2' && suffix[1]-'0'<=6) ) {
            c2 = numDecodings(prefix+suffix[0]+suffix[1], suffix.substr(2), memo);
        }
        memo[prefix] = c1+c2;
        return memo[prefix];  
    }
    int numDecodings(string s) {
        unordered_map<string, int> memo;
        return numDecodings("", s, memo);
    }
};
