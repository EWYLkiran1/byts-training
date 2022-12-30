class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        // use a bitmask to strong the counter of each words, since int is 32 bits can store 26 letters 
        HashMap <Integer, Integer> map = new HashMap<>();// first Integer store the index of word i
        // build a bitmask for all word in words 
        for(int i=0; i<words.length; ++i){
            int bitmask = 0;
            for(int j=0; j<words[i].length(); ++j){
                int mask = 1 << words[i].charAt(j) -'a'; // shift 1 to the left words[i].charAt(i) -'a' times
                bitmask |= mask; // store the information at words[i].charAt(j) into bitmap using or operation 
            }
            map.put(i, bitmask);
        }
        // traversal the entire array to find the Maximum Product of Word Lengths
        for(int i=0; i<words.length; ++i){
            for(int j=1; j<words.length; ++j){
                if(words[i].length() * words[j].length() > res && (map.get(i) & map.get(j)) == 0) // if words[i] does not share any letter with words[j], then the bitmask information is completely different. so the and operation should return 0 
                    res = words[i].length() * words[j].length();
            }
        }
        return res; 
    }
}

// Time O(N*2)
// Space O(N)