class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i: nums){
            q.add(i);
        }
        while(k>1){
            q.poll();
            k--;
        }
        return q.poll();
    }
}