class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int ele=0;
        for(int num:nums){
            if(count==0){
                ele=num;

            }
            if(num==ele) count+=1;
            else count-=1;


        }
        return ele;
    }
}