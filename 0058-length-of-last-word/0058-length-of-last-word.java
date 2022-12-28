class Solution {
    public int lengthOfLastWord(String s) {
        String[] strList = s.split(" ");
        return strList[strList.length - 1].length();   
    }
}