class Solution {
    public String getHint(String s, String g) {  
        int x [] = new int [12]; 
        for (int i =0 ; i<s.length(); i++){  
            int a = s.charAt(i)-'0'; int b = g.charAt(i)-'0'; 
            if(a!=b){ 
                 if(x[a]<0)x[10]++; 
                 if(x[b]>0)x[10]++; 
                 x[a]++; x[b]--;
            }
            else x[11]++;
        } 
        return Integer.toString(x[11])+ "A" + Integer.toString(x[10]) +"B"; 
    }
}



