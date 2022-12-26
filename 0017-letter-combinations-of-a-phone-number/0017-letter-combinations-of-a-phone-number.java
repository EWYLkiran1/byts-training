class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.equals("")) return ans;
        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(1, new String[]{});
        map.put(2, new String[]{"a","b", "c"});
        map.put(3, new String[]{"d","e", "f"});
        map.put(4, new String[]{"g","h", "i"});
        map.put(5, new String[]{"j","k", "l"});
        map.put(6, new String[]{"m","n", "o"});
        map.put(7, new String[]{"p","q", "r", "s"});
        map.put(8, new String[]{"t","u", "v"});
        map.put(9, new String[]{"w","x", "y", "z"});
        for(int i = 0; i<digits.length(); i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            String[] letters = map.get(digit);
            if(ans.size()==0){
                ans.addAll(Arrays.asList(letters));
                continue;
            }
            List<String> sub = new ArrayList<>();
            for(int j = 0; j<ans.size(); j++){
                for(int x = 0; x<letters.length; x++){
                     sub.add(ans.get(j)+letters[x]);
                }
            }
            ans = sub;
        }
        return ans;
    }
}