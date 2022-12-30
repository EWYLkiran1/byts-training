class Solution {

    private TrieNode root = new TrieNode();

    public class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public void buildTrie(String[] words) {
        for (String word : words) {
            
            TrieNode node = root;

            for (char c : word.toCharArray()) {

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }

            node.word = word;
        }
    }

    private List<String> result = new ArrayList();

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root);
            }
        }

        return result;
    }

    private void dfs(int i, int j, char[][] board, TrieNode node) {
        if (board[i][j] == '#' || node.children[board[i][j] - 'a'] == null) return;

        char c = board[i][j];

        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        if (i < board.length - 1) dfs(i + 1, j, board, node);
        if (i > 0) dfs(i - 1, j, board, node);
        if (j < board[0].length - 1) dfs(i, j + 1, board, node);
        if (j > 0) dfs(i, j - 1, board, node);

        board[i][j] = c;
    }
}