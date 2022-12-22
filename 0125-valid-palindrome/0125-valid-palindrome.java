class Solution {
    // we are checking for the flase conditions and here are the parameters
    // if character is not alphanumeric we will increase the left pointer
    // if character is not alphanumeric we will decrese the right pointer
    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        char startChar;
        char endChar;
                    
        
        while(start < end)  {
                 
            startChar = s.charAt(start);
            endChar = s.charAt(end);
            
            //checks for the alphanumeric conditions in the given string
            if(!Character.isLetterOrDigit(startChar)){
                start++;
            }
            
             else if(!Character.isLetterOrDigit(endChar)){
                end--;
            }
            // tolower is the function which coverts the string into lowercases
            else if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)){
            // if the left and right elements are not same we will return false
                return false;
            }
            //else condition will be just to increase and decrease the pointers respectively
            else  {
                start++;
                end--;
            }
          
        }
        
        return true;
    }
}