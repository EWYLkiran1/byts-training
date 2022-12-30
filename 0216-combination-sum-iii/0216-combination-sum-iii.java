class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, ans, new ArrayList<>(), 0, 1);
        return ans;
    }
    public void dfs(int k, int n, List<List<Integer>> ans, List<Integer> curList, int sum, int start) {
        if(curList.size() > k || sum > n) return;
        if(curList.size() == k && sum == n) ans.add(new ArrayList(curList));
        if(curList.size() == k && sum > n) return;
        for(int i = start; i <= 9; i++){
            curList.add(i);
            dfs(k, n, ans, curList, sum+i, i+1);
            curList.remove(curList.size()-1);
        }
    }
}