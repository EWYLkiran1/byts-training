class Solution {
    List <String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set <String> set = new HashSet<>();
        set.addAll(wordDict);
        helper(s, 0, set, "");
        return res;
    }
    boolean helper(String s, int i, Set<String> set, String temp) {
        if (i == s.length()) {
            res.add(temp.substring(1, temp.length()));
            return true;
        }
        boolean res = false;
        for(String word: set) {
            if (i + word.length() <= s.length()) {
                if (word.equals(s.substring(i, i + word.length()))){
                    res |= helper(s, i + word.length(), set, temp + " " + word);
                }
            }
        }
        return res;
    }
}