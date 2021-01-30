import java.util.List;
import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class pathSum {
    List<List<Integer>> result = new ArrayList<>();
    Integer target = null;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return this.result;
        }

        this.target = targetSum;

        this.dfs(root, new ArrayList<>(), 0);

        return this.result;
    }

    public void dfs(TreeNode node, List<Integer> path, int count) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        Integer val = node.val;

        if (left == null && right == null) {
            if (count + val == this.target) {
                path.add(val);
                result.add(item);
            }

            return;
        }

        if (left != null) {
            this.dfs(left, count);
        }

        if (right != null) {
            this.dfs(right, count);
        }
    }
}
