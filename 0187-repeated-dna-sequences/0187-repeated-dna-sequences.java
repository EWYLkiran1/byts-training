class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> li = new ArrayList<>();
        HashMap<String,Integer> mp = new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String str=s.substring(i,i+10);
            if(s.substring(i).contains(str)){
            mp.put(str,mp.getOrDefault(str,0)+1);
            }
            
        }
        for(String ele:mp.keySet()){
            if(mp.get(ele)>1){
                li.add(ele);
            }
        }
        return li;
    }
}