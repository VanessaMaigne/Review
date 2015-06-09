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

        listResult = sol.rightSideView(null);
        Assert.assertEquals(listResult, new ArrayList<Integer>());
        listResult = sol.rightSideView(tree);
        Assert.assertEquals(listResult, rightSide);

        tree.right = new TreeNode(20);
        listResult = sol.rightSideView(tree);
        Assert.assertEquals(listResult, new ArrayList<Integer>(){{add(3); add(20);}});

        tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        listResult = sol.rightSideView(tree);
        Assert.assertEquals(listResult, new ArrayList<Integer>(){{add(3); add(9);}});

        tree.right = new TreeNode(20);
        listResult = sol.rightSideView(tree);
        Assert.assertEquals(listResult, new ArrayList<Integer>(){{add(3); add(20);}});

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

    @Test //#200
    public void testNumberIsland(){
        System.out.print("TEST #200 Number Islands");

        int result;
        char[][] grid;

//        result = sol.numIslands(null);
//        Assert.assertEquals(result, 0);

//        result = sol.numIslands(new char[0][0]);
//        Assert.assertEquals(result, 0);

//        result = sol.numIslands(new char[][]{{'1'}});
//        Assert.assertEquals(result, 1);
//        result = sol.numIslands(new char[][]{{'0'}});
//        Assert.assertEquals(result, 0);

//        grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        grid = new char[][]{{'1','0','1'},{'1','1','1'},{'1','0','1'}};
        result = sol.numIslands(grid);
        Assert.assertEquals(result, 1);

        grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        result = sol.numIslands(grid);
        Assert.assertEquals(result, 1);

        grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        result = sol.numIslands(grid);
        Assert.assertEquals(result, 3);
    }

    @Test //#148
    public void testSortList(){
        System.out.print("TEST #148 Sort List");

        ListNode result;
        ListNode l1 = new ListNode(7);
        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(5);
        l3.next.next.next.next.next = new ListNode(7);
        l3.next.next.next.next.next.next = new ListNode(10);

        result = sol.sortList(null);
        Assert.assertEquals(result, null);
        result = sol.sortList(l1);
        Assert.assertEquals(result, new ListNode(7));

        l1.next = new ListNode(5);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(10);
        l1.next.next.next.next.next.next = new ListNode(1);
        result = sol.sortList(l1);
        Assert.assertEquals(result, l3);

        l1.next = new ListNode(5);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(10);
        l1.next.next.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next.next.next = new ListNode(10);
        l1.next.next.next.next.next.next.next.next = new ListNode(20);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(10);
        l3.next.next.next.next.next.next.next = new ListNode(10);
        l3.next.next.next.next.next.next.next.next = new ListNode(10);
        l3.next.next.next.next.next.next.next.next.next = new ListNode(20);
        result = sol.sortList(l1);
        Assert.assertEquals(result, l3);
    }

    @Test //#24 && 61
    public void testSwapPairs(){
        System.out.print("TEST #24 && 61 Swap Pairs & Rotate");

        ListNode result;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(4);
        l3.next.next.next = new ListNode(3);
        l3.next.next.next.next = new ListNode(5);

        result = sol.swapPairs(null);
        Assert.assertEquals(result, null);
        result = sol.swapPairs(l1);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l3 = new ListNode(1);
        l3.next = new ListNode(2);
        result = sol.rotateRight(l1, 2);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l3 = new ListNode(2);
        l3.next = new ListNode(1);
        result = sol.rotateRight(l1, 1);
        Assert.assertEquals(result, l3);
        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        result = sol.rotateRight(l1, 3);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l3 = new ListNode(2);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(1);
        result = sol.rotateRight(l1, 2000000000);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l3 = new ListNode(4);
        l3.next = new ListNode(5);
        l3.next.next = new ListNode(1);
        l3.next.next.next = new ListNode(2);
        l3.next.next.next.next = new ListNode(3);
        result = sol.rotateRight(l1, 2);
        Assert.assertEquals(result, l3);
    }

    @Test //#92
    public void testReverseList(){
        System.out.print("TEST #92 Reverse List");

        ListNode result;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        result = sol.reverseBetween(null, 1, 2);
        Assert.assertEquals(result, null);
        result = sol.reverseBetween(null, -1, 4);
        Assert.assertEquals(result, null);
        result = sol.reverseBetween(null, 1, -4);
        Assert.assertEquals(result, null);
        result = sol.reverseBetween(l1, 1, -4);
        Assert.assertEquals(result, null);
        result = sol.reverseBetween(l1, 4, 2);
        Assert.assertEquals(result, null);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(2);
        l3.next.next.next.next = new ListNode(5);
        result = sol.reverseBetween(l1, 2, 4);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l3 = new ListNode(5);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(2);
        l3.next.next.next.next = new ListNode(1);
        result = sol.reverseBetween(l1, 1, 5);
        Assert.assertEquals(result, l3);

        l1 = l1.next;
        l3 = new ListNode(5);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(3);
        l3.next.next.next = new ListNode(1);
        l3.next.next.next.next = new ListNode(2);
        result = sol.reverseBetween(l1, 4, 5);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(3);
        l1.next = new ListNode(5);
        l3 = new ListNode(3);
        l3.next = new ListNode(5);
        result = sol.reverseBetween(l1, 1, 1);
        Assert.assertEquals(result, l3);



    }
}
