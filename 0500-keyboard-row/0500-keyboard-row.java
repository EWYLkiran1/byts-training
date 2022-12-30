class Solution {
    public String[] findWords(String[] words) {
    String firstRow = "qwertyuiopQWERTYUIOP";
    String secondRow = "asdfghjklASDFGHJKL";
    String thirdRow = "zxcvbnmZXCVBNM";
    HashSet<Character> nethunter1 = new HashSet<Character>();
    HashSet<Character> nethunter2 = new HashSet<Character>();
    HashSet<Character> nethunter3 = new HashSet<Character>();
    
    for(int i = 0 ; i < firstRow.length() ; i++){
        nethunter1.add(firstRow.charAt(i));
    } 
    for(int i = 0 ; i < secondRow.length() ; i++){
        nethunter2.add(secondRow.charAt(i));
    } 
    for(int i = 0 ; i < thirdRow.length() ; i++){
        nethunter3.add(thirdRow.charAt(i));
    } 
    ArrayList<String> netHunter = new ArrayList<String>();
    for(int i = 0 ; i < words.length ; i++){
        int a = 0, b = 0, c = 0;
        for(int j = 0 ; j < words[i].length() ; j++){
            if(nethunter1.contains(words[i].charAt(j))){
                a++;
            } else if(nethunter2.contains(words[i].charAt(j))){
                b++;
            } else if(nethunter3.contains(words[i].charAt(j))){
                c++;
            }
        }
        if(a == words[i].length() || b == words[i].length() || c == words[i].length()){
            netHunter.add(words[i]);
        }
    }

    String[] h = new String[netHunter.size()];
    for(int i = 0 ; i < netHunter.size() ; i++){
        h[i] = netHunter.get(i);
    }
    return h;
    }
}