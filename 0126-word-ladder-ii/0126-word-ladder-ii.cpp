class Solution {
private:
    void dfs(string word,string beginWord,vector<string> &sequence,vector<vector<string>> &ans,unordered_map<string,int> &mp){
        if(word==beginWord){
            ans.push_back(sequence);
            return;
        }
        
        int steps=mp[word];
        int wordSize=beginWord.size();
        for(int i=0;i<wordSize;i++){
            char origChar=word[i];
            for(char c='a';c<='z';c++){
                word[i]=c;
                if(mp[word]+1==steps){
                    sequence.push_back(word);
                    dfs(word,beginWord,sequence,ans,mp);
                    sequence.pop_back();
                }
            }
                word[i]=origChar;
        }
        
        
    }
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> st(wordList.begin(),wordList.end());
        unordered_map<string,int> mp;
        mp[beginWord]=1;
        queue<string> q;
        q.push(beginWord);
        st.erase(beginWord);
        vector<vector<string>> ans;
        int wordSize=beginWord.size();
        //doing bfs
        while(!q.empty()){
            string word=q.front();
            int steps=mp[word];
            q.pop();
            if(word==endWord)
                break;
            // traverse
            for(int i=0;i<wordSize;i++){
                char origChar=word[i];
                for(char c='a';c<='z';c++){
                    word[i]=c;
                    if(st.find(word)!=st.end()){
                        st.erase(word);
                        mp[word]=steps+1;
                        q.push(word);
                    }     
                }
                word[i]=origChar;
            }
        }
        
        if(mp[endWord]!=0){
            vector<string> sequence;
            sequence.push_back(endWord);
            dfs(endWord,beginWord,sequence,ans,mp);
            int ansSize=ans.size();
            for(int i=0;i<ansSize;i++){
                reverse(ans[i].begin(),ans[i].end());
            }
        }
        return ans;
    }
};