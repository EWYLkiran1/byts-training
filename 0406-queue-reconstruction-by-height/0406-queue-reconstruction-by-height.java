class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = people.length;
        int[][] res = new int[n][];
        int[] bit = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1), used = get(bit, mid + 1);
                if (mid + 1 - used <= people[i][1]) lo = mid + 1;
                else hi = mid;
            }
            res[lo] = people[i];
            add(bit, lo + 1);
        }
        return res;
    }
    private int get(int[] bit, int i) {
        int res = 0;
        for (; 0 < i; i -= i & -i) res += bit[i];
        return res;
    }
    private void add(int[] bit, int i) {
        for (; i < bit.length; i += i & -i) bit[i]++;
    }
}