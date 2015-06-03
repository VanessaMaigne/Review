import com.sun.tools.javac.util.Pair;

import java.util.*;

public class MediumSolutionImpl implements MediumSolution{
    /**
     * #199 : Binary Tree Right Side View
     */
    public List<Integer> rightSideView2(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<Integer>();
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<Pair<TreeNode, Integer>>();
        HashMap<TreeNode, Boolean> map = new HashMap<TreeNode, Boolean>();

        int level = 0;
        queue.add(new Pair(root, level));

        while(!queue.isEmpty()){
            Pair nodeAndLevel = queue.remove();
            TreeNode node = (TreeNode) nodeAndLevel.fst;
            level = (Integer) nodeAndLevel.snd;

            if(map.get(node) == null){
                map.put(node, true);
                if(result.size() > level) result.remove((int)level); // Remove the index, not the value
                result.add(level, node.val);

                if(node.right != null || node.left != null) level++;
                if(node.right != null) queue.addFirst(new Pair(node.right, level));
                if(node.left != null) queue.addFirst(new Pair(node.left, level));
            }
        }
        return result;
    }

    // Without Pair but 2 HashMap
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode, Boolean> mapChecked = new HashMap<TreeNode, Boolean>();
        HashMap<TreeNode, Integer> mapLevel = new HashMap<TreeNode, Integer>();

        int level = 0;
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(mapLevel.get(node) != null) level = mapLevel.get(node);

            if(mapChecked.get(node) == null){
                mapChecked.put(node, true);
                if(result.size() > level) result.remove((int)level); // Remove the index, not the value
                result.add(level, node.val);

                if(node.right != null || node.left != null) level++;
                if(node.right != null) {
                    queue.addFirst(node.right);
                    mapLevel.put(node.right, level);
                }
                if(node.left != null) {
                    queue.addFirst(node.left);
                    mapLevel.put(node.left, level);
                }
            }
        }
        return result;
    }

}
