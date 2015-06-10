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

    @Test //#143
    public void testReorderList(){
        System.out.print("TEST #143 Reorder List");

        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(1);

        sol.reorderList(l1);
        Assert.assertEquals(l1, l3);

        l1.next = new ListNode(2);
        l3.next = new ListNode(2);
        sol.reorderList(l1);
        Assert.assertEquals(l1, l3);

        l1.next.next = new ListNode(3);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(2);
        sol.reorderList(l1);
        Assert.assertEquals(l1, l3);

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(2);
        l3.next.next.next = new ListNode(3);
        sol.reorderList(l1);
        Assert.assertEquals(l1, l3);

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l3 = new ListNode(1);
        l3.next = new ListNode(5);
        l3.next.next = new ListNode(2);
        l3.next.next.next = new ListNode(4);
        l3.next.next.next.next = new ListNode(3);
        sol.reorderList(l1);
        Assert.assertEquals(l1, l3);
    }

    @Test //#86
    public void testPartitionList(){
        System.out.print("TEST #86 Partition List");

        ListNode result;
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(1);

        result = sol.partition(null, 3);
        Assert.assertEquals(result, null);
        result = sol.partition(l1, 3);
        Assert.assertEquals(result, l3);
        result = sol.partition(l1, 0);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(2);
        l3 = new ListNode(1);
        l3.next = new ListNode(2);
        l3.next.next = new ListNode(2);
        l3.next.next.next = new ListNode(2);
        l3.next.next.next.next = new ListNode(4);
        l3.next.next.next.next.next = new ListNode(3);
        l3.next.next.next.next.next.next = new ListNode(5);
        result = sol.partition(l1, 3);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(2);
        l3 = new ListNode(2);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(2);
        l3.next.next.next = new ListNode(2);
        l3.next.next.next.next = new ListNode(4);
        l3.next.next.next.next.next = new ListNode(3);
        l3.next.next.next.next.next.next = new ListNode(5);
        result = sol.partition(l1, 3);
        Assert.assertEquals(result, l3);
    }

    @Test //#151
    public void testReverseString(){
        System.out.print("TEST #151 Reverse String");

        String result;

        result = sol.reverseWords("");
        Assert.assertEquals(result, "");
        result = sol.reverseWords(" ");
        Assert.assertEquals(result, "");
        result = sol.reverseWords("the");
        Assert.assertEquals(result, "the");
        result = sol.reverseWords("    ");
        Assert.assertEquals(result, "");
        result = sol.reverseWords("the sky ");
        Assert.assertEquals(result, "sky the");
        result = sol.reverseWords("the sky    is blue");
        Assert.assertEquals(result, "blue is sky the");
        result = sol.reverseWords("the sky is blue");
        Assert.assertEquals(result, "blue is sky the");
    }

    @Test //#147
    public void testInsertionSortList(){
        System.out.print("TEST #147 Insertion Sort List");

        ListNode result;
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(1);

        result = sol.insertionSortList(null);
        Assert.assertEquals(result, null);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);
        l1.next = new ListNode(1);
        l3.next = new ListNode(1);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(1);
        l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);


        l1 = new ListNode(2);
        l1.next = new ListNode(1);
        l3.next = new ListNode(2);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(1);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(2);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);

        l1.next = new ListNode(1);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(1);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(1);
        l3.next.next.next = new ListNode(1);
        l3.next.next.next.next = new ListNode(2);
        l3.next.next.next.next.next = new ListNode(3);
        l3.next.next.next.next.next.next = new ListNode(4);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);

        l1 = new ListNode(4);
        l1.next = new ListNode(19);
        l1.next.next = new ListNode(14);
        l1.next.next.next = new ListNode(5);
        l1.next.next.next.next = new ListNode(-3);
        l1.next.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next.next = new ListNode(8);
        l3 = new ListNode(-3);
        l3.next = new ListNode(1);
        l3.next.next = new ListNode(4);
        l3.next.next.next = new ListNode(5);
        l3.next.next.next.next = new ListNode(8);
        l3.next.next.next.next.next = new ListNode(14);
        l3.next.next.next.next.next.next = new ListNode(19);
        result = sol.insertionSortList(l1);
        Assert.assertEquals(result, l3);
    }

    @Test //#98
    public void testBSTTree(){
        System.out.print("TEST #98 BST Tree");

        TreeNode tree = new TreeNode(4);
        boolean result;

        result = sol.isValidBST(null);
        Assert.assertTrue(result);
        result = sol.isValidBST(tree);
        Assert.assertTrue(result);

        tree.right = new TreeNode(20);
        result = sol.isValidBST(tree);
        Assert.assertFalse(result);
        tree.left = new TreeNode(9);
        result = sol.isValidBST(tree);
        Assert.assertFalse(result);

        tree.left = new TreeNode(2);
        result = sol.isValidBST(tree);
        Assert.assertTrue(result);

        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(30);
        tree.right.left = new TreeNode(1);
        tree.right.right = new TreeNode(30);
        result = sol.isValidBST(tree);
        Assert.assertFalse(result);

        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(22);
        result = sol.isValidBST(tree);
        Assert.assertFalse(result);

        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(22);
        result = sol.isValidBST(tree);
        Assert.assertTrue(result);
    }

    @Test //#103
    public void testZizagTree(){
        System.out.print("TEST #103 Zigzag Tree");

        List<List<Integer>>  result;
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

//        result = sol.zigzagLevelOrder(tree);
//        Assert.assertTrue(result);

        tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.right.right = new TreeNode(5);
//        result = sol.zigzagLevelOrder(tree);

        tree = new TreeNode(0);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(1);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(-1);
        tree.left.left.left = new TreeNode(5);
        tree.left.left.right = new TreeNode(1);
        tree.right.left.right = new TreeNode(6);
        tree.right.right.right = new TreeNode(8);
        result = sol.zigzagLevelOrder(tree);
    }
}
