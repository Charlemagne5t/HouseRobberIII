import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        List<Integer> list = bfs(root);
        int n = list.size();
        if(n == 1){
            return list.get(0);
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = list.get(0);
        for (int i = 2; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + list.get(i - 1));
        }
        return dp[n];

    }

    private List<Integer> bfs(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelSums = new ArrayList<>();
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            levelSums.add(sum);
        }

        return levelSums;
    }
}
