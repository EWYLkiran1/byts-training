class Solution {
public:
    string decodeString(string s) {
        int n = s.size();
        function<int(string&, int&)> parseInt = [&](string &str, int &i) {
            int num = 0;
            while (i < n && isdigit(str[i])) {
                num = num * 10 + (str[i++] - '0');
            }
            return num;
        };
        int num = 0;
        int i = 0;
        string str;
        stack<string> strs;
        stack<int> nums;
        while (i < n) {
            if (isdigit(s[i])) {
                num = parseInt(s, i);// parsing
            } else if (s[i] == '[') {// push num and str
                nums.push(num);
                strs.push(str);
                ++i;
                str = "";
            } else if (s[i] == ']') {// pop num, and repeatable appending str
                int times = nums.top();
                nums.pop();
                for (int j = 0; j < times; ++j) {
                    strs.top() += str;
                }
                str = strs.top();// update the untreated string for future modification
                strs.pop();
                ++i;
            } else {
                str.push_back(s[i++]);// appending letters
            }
        }
        return str;
    }
};