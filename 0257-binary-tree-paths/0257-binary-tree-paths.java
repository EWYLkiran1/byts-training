class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        
        //call funtion is there is more than one node
        getPaths(root, paths, "");
        return paths;
    }
    
    public void getPaths(TreeNode node, List<String> paths, String path){
        if(node.left == null && node.right == null){
            if(path.length() == 0)
                path = path + Integer.toString(node.val);
            else
                path = path + "->" + Integer.toString(node.val);
            paths.add(path);
            return;
        }
        
        if(path.length() == 0)
            path = path + Integer.toString(node.val);
        else
            path = path + "->" + Integer.toString(node.val);
        
        if(node.left != null)
            getPaths(node.left, paths, path);
        
        if(node.right != null)
            getPaths(node.right, paths, path);
    }
}
