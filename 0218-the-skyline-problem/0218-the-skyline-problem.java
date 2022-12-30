class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(buildings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> indexToPosition = new HashMap<>();
        Map<Integer, Integer> positionToIndex = new HashMap<>();
        int index = 0;
        for (int[] building : buildings) {
            set.add(building[0]);
            set.add(building[1]);
        }

        for (int pos : set) {
            indexToPosition.put(index, pos);
            positionToIndex.put(pos, index);
            index ++;
        }

        SegmentTreeNode root = new SegmentTreeNode(0, set.size() - 1);
        root.init(root, 0, set.size() - 1);
        for (int[] building : buildings) {
            root.update(root, positionToIndex.get(building[0]), positionToIndex.get(building[1]) - 1, building[2]);
        }
        List<SegmentTreeNode> list = new ArrayList<>();
        dfs(list, root);
        for (int i = 0; i < list.size(); i ++) {
            SegmentTreeNode cur = list.get(i);
            int position = indexToPosition.get(cur.start);
            result.add(Arrays.asList(position, cur.height));
            while (i + 1 < list.size() && list.get(i + 1).height == cur.height) {
                i ++;
            }
        }

        return result;
    }

    private void dfs(List<SegmentTreeNode> list, SegmentTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.start == root.end) {
            list.add(root);
            return;
        }
        
        dfs(list, root.left);
        dfs(list, root.right);
    }
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int height;
    public SegmentTreeNode() {}

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.height = 0;
    }

    public void init(SegmentTreeNode root, int start, int end) {
        if (start == end) {
            return;
        } 
        int mid = start + (end - start) / 2;
        root.left = new SegmentTreeNode(start, mid);
        root.right = new SegmentTreeNode(mid + 1, end);
        init(root.left, start, mid);
        init(root.right, mid + 1, end);
    }

    public void update(SegmentTreeNode root, int start, int end, int height) {
        if (root.start > end || root.end < start) {
            return;
        }
        if (root.start == root.end) {
            root.height = Math.max(root.height, height);
            return;
        }
        update(root.left, start, end, height);
        update(root.right, start, end, height);
        root.height = Math.max(root.left.height, root.right.height);
    }
}