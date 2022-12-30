class Solution {
public:
    bool isValidSerialization(string preorder) {
        vector<pair<string, int>> S;
        int L = preorder.size();
        for (int i = 0; i < L; ++i) {
            string tmp;
            while (i < L && preorder[i] != ',') {
                tmp.push_back(preorder[i]);
                i++;
            }
            S.push_back({tmp, 0});
            while (S.size() != 0 && (S.back().first == "#" || S.back().second == 2)) {
                S.pop_back();
                if (S.size() != 0) S[S.size()-1].second++;
            }
            if (i != L && S.size() == 0)
                return false;
        }
        return S.size() == 0;
    }
};