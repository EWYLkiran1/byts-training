class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        int n=nums.length;
        while(i<n){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
     List<Integer>list=new ArrayList<>();
     for(int index=0;index<n;index++){
         if(nums[index]!=index+1){
             list.add(index+1);
         }
     }
      return list;


    }
    public void swap(int [] nums,int first,int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}