import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MediumSolutionTest {
    MediumSolution sol = new MediumSolutionImpl();

    @Test //#199
    public void testRightSideViewTree(){
        System.out.print("TEST #199 Tree Right Side View");

        TreeNode tree = new TreeNode(3);
        List<Integer> listResult;
        List<Integer> rightSide  = new ArrayList<Integer>(){{add(3);}};

//        listResult = sol.rightSideView(null);
//        Assert.assertEquals(listResult, new ArrayList<Integer>());
//        listResult = sol.rightSideView(tree);
//        Assert.assertEquals(listResult, rightSide);

//        tree.right = new TreeNode(20);
//        listResult = sol.rightSideView(tree);
//        Assert.assertEquals(listResult, new ArrayList<Integer>(){{add(3); add(20);}});

        tree = new TreeNode(3);
        tree.left = new TreeNode(9);
//        listResult = sol.rightSideView(tree);
//        Assert.assertEquals(listResult, new ArrayList<Integer>(){{add(3); add(9);}});

        tree.right = new TreeNode(20);
//        listResult = sol.rightSideView(tree);
//        Assert.assertEquals(listResult, new ArrayList<Integer>(){{add(3); add(20);}});

        tree.left.left = new TreeNode(10);
        tree.left.right = new TreeNode(11);
        tree.left.right.right = new TreeNode(12);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        rightSide.add(20);
        rightSide.add(7);
        rightSide.add(12);
        listResult = sol.rightSideView(tree);
        Assert.assertEquals(listResult, rightSide);

    }
}
