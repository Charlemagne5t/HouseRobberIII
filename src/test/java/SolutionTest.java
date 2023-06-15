import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void robTest1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int output = 7;
        Assert.assertEquals(output, new Solution().rob(root));
    }

    @Test
    public void robTest2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        int output = 9;
        Assert.assertEquals(output, new Solution().rob(root));
    }

    @Test
    public void robTest3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        int output = 9;
        Assert.assertEquals(output, new Solution().rob(root));
    }
}
