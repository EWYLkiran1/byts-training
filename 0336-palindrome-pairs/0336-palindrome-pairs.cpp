class Solution {
/* 
O(n^2*k)
Case 1: word1 + reverse of word2 (word1 != word2)
Case 2:  prefix1 + palindrome1 + reverse of prefix1 (word2)
Case 3: reverse of suffix2 (word1) + palindrome + suffix2 

unordered_map<string, int> wordToIdx{};
Every word: O(n)
    find case 1 in hashmap -- add pair O(k)
        - check that reverse != word
    for every validPrefix: 
        find reverse of Prefix -- add pair O(k^2)
    for every validSuffix; 
        find reverse of suffix -- add pair O(k^2)

 */
public:
    vector<vector<int>> palindromePairs(vector<string>& words) {
        unordered_map<string, int> wordToIdx{};
        auto result = vector<vector<int>>();
        for (int i=0;i<words.size();i++) {
            wordToIdx[words[i]]=i;
        }
        for (int i=0;i<words.size();i++) {
            auto& word = words[i];
            // Case 1
            auto r = word;
            reverse(r.begin(), r.end()); 
            if (r != word) {
                auto it = wordToIdx.find(r);
                if (it != wordToIdx.end()) {
                    result.push_back({i, it->second});
                }
            }
            // Case 2
            for (auto& p : getValidPrefixes(word)) {
                reverse(p.begin(), p.end());
                auto it = wordToIdx.find(p);
                if (it != wordToIdx.end()) {
                    result.push_back({i, it->second});
                }
            }
            // Case 3
            for (auto& s : getValidSuffixes(word)) {
                reverse(s.begin(), s.end());
                auto it = wordToIdx.find(s);
                if (it != wordToIdx.end()) {
                    result.push_back({it->second, i});
                }
            }
        }
        return result;
    }
private: 
    inline vector<string> getValidPrefixes(const string& word) {
        auto prefixes = vector<string>();
        for (int i=0; i<word.length();i++) {
            if (isPalindromeBetween(word, i, word.length()-1)) {
                prefixes.emplace_back(word.substr(0, i));
            }
        }
        return prefixes;
    }
    inline vector<string> getValidSuffixes(const string& word) {
        auto suffixes = vector<string>();
        for (int i=word.length()-1;i>=0;i--) {
            if (isPalindromeBetween(word, 0, i)) {
                suffixes.emplace_back(word.substr(i+1, word.length()-i-1));
            }
        }
        return suffixes;
    }
    // Inclusive valid bound i,j 
    bool isPalindromeBetween(const string& word, int i, int j) {
        while (j > i) {
            if (word[i++] != word[j--]) return false;
        }
        return true;
    }
};