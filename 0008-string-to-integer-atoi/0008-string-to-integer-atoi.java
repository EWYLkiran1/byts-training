class Solution {
    public int myAtoi(String s) {
        int start = -1, end = -1;
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i)) || s.charAt(i) == '.'){
                break;
            }
            if(s.charAt(i) == ' '){
                continue;
            }
            if(s.charAt(i) == '-' || s.charAt(i) == '+' || Character.isDigit(s.charAt(i))){
                start = i;
                end = i;
                
                i+=1;
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    end=i;
                    i+=1;
                }
                
                break;
            }
        }
        if(start == end && (end == -1 || s.charAt(end) == '-' || s.charAt(end) == '+')){
            return 0;
        }
        int result = 0;
        try{
            result = Integer.parseInt(s.substring(start, end+1));
        } catch (NumberFormatException e){
            if(s.charAt(start) == '-'){
                return -2147483648;
            }
            else{
                return 2147483647;
            }
        }
        return result;
    }
}