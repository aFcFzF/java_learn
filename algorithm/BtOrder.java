class LevelTreeNode extends TreeNode {
    int level = 0;

    public void LevelTreeNode(int level, int val, TreeNode l, TreeNode r) {
        super();
        this.level = level;
    }
}

public class BtOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        // LevelTreeNode nodeTree = new LevelTreeNode(root.val);

        List<LevelTreeNode> queue = new ArrayList<LevelTreeNode>(new LevelTreeNode(root.val));
        List<LevelTreeNode> q1 = new ArrayList<LevelTreeNode>(new LevelTreeNode(root.val));



        while (queue.length > 0) {
            LevelTreeNode node = queue.get(0);
            queue.remove(0);
            if (node.left != null) {
                LevelTreeNode left = new LevelTreeNode(node.left.value)
                queue.add(left);
                q1.add(left);
            }

            if (node.right != null) {
                LevelTreeNode right = new LevelTreeNode(node.right.value)
                queue.add(right);
                q1.add(right);
            }
        }

        for (LevelTreeNode item: q1) {
            int val = item.val;
            int level = item.level;
            // if (result[level] == null) {
            //     result[level] = new ArrayList(val);
            // } else {
            //     result[level].add(val);
            // }
            result[level] == null ? result[level] = new ArrayList(val) : result[level].add(val);
        }

        return result;
    }

    static void main(String[] args) {
        List<List<Integer>> result = new BtOrder();
    }

}

