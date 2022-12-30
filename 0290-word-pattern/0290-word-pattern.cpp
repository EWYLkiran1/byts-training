class Solution {
    vector<string> splitBySpace(string s) {
        vector<string> v;
        string word;
        for (auto c : s) {
            if (c != ' ') {
                word += c;
            } else {
                v.push_back(word);
                word = "";
            }
        }
        v.push_back(word);
        return v;
    }
public:
    bool wordPattern(string pattern, string s) {
        vector<string> v = splitBySpace(s);

        if (pattern.length() != v.size()) {
            return false;
        }

        map<char, string> m1;
        map<string, char> m2;
        for (int i = 0; i < pattern.length(); i++) {
            if (m1.find(pattern[i]) == m1.end()) {
                m1[pattern[i]] = v[i];
            } else {
                if (m1[pattern[i]] != v[i]) {
                    return false;
                }
            }

            if (m2.find(v[i]) == m2.end()) {
                m2[v[i]] = pattern[i];
            } else {
                if (m2[v[i]] != pattern[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
};