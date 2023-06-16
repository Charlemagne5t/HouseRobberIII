import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return dfs(root, memo);
    }

    private int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int result = 0;
        int baseResult = dfs(root.left, memo) + dfs(root.right, memo);
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left.left, memo) + dfs(root.left.right, memo);
        }
        if (root.right != null) {
            right = dfs(root.right.left, memo) + dfs(root.right.right, memo);
        }

        result = Math.max(baseResult, left + right + root.val);
        memo.put(root, result);

        return result;
    }
}
