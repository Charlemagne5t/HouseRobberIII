
public class Solution {
    public int rob(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int result = 0;
        int baseResult = dfs(root.left) + dfs(root.right);
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            right = dfs(root.right.left) + dfs(root.right.right);
        }

        result = Math.max(baseResult, left + right + root.val);
        return result;
    }
}
