import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EasySolutionTest {

    EasySolution sol = new EasySolutionImpl();

    @Test //#19
    public void testListNode(){
        System.out.print("TEST #19 List Node");
        ListNode node = new ListNode(1);
        ListNode resultNode = new ListNode(1);
        ListNode listNode;

        listNode = sol.removeNthFromEnd(null, 2);
        Assert.assertEquals(listNode, null);
        listNode = sol.removeNthFromEnd(node, 1);
        Assert.assertEquals(listNode, null);
        listNode = sol.removeNthFromEnd(node, 2);
        Assert.assertEquals(listNode, null);
        listNode = sol.removeNthFromEnd(node, -1);
        Assert.assertEquals(listNode, node);
        node.next = new ListNode(2);
        listNode = sol.removeNthFromEnd(node, 1);
        Assert.assertEquals(listNode, new ListNode(1));
        node.next = new ListNode(2);
        listNode = sol.removeNthFromEnd(node, 2);
        Assert.assertEquals(listNode, new ListNode(2));

        node.next.next = new ListNode(3);
        resultNode.next = new ListNode(2);
        listNode = sol.removeNthFromEnd(node, 1);
        Assert.assertEquals(listNode, resultNode);
        node.next.next = new ListNode(3);
        resultNode.next = new ListNode(3);
        listNode = sol.removeNthFromEnd(node, 2);
        Assert.assertEquals(listNode, resultNode);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        resultNode = new ListNode(2);
        resultNode.next = new ListNode(3);
        listNode = sol.removeNthFromEnd(node, 3);
        Assert.assertEquals(listNode, resultNode);

        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        resultNode = new ListNode(1);
        resultNode.next = new ListNode(2);
        resultNode.next.next = new ListNode(3);
        resultNode.next.next.next = new ListNode(5);
        resultNode.next.next.next.next = new ListNode(6);
        listNode = sol.removeNthFromEnd(node, 3);
        Assert.assertEquals(listNode, resultNode);
    }

    @Test  //#125
    public void testIsPalindrome(){
        System.out.print("TEST #125 Palindrome");
        boolean isPalindrome;

        isPalindrome = sol.isPalindrome("");
        Assert.assertTrue(isPalindrome);
        isPalindrome = sol.isPalindrome(".,");
        Assert.assertTrue(isPalindrome);
        isPalindrome = sol.isPalindrome(".,=,aa!");
        Assert.assertTrue(isPalindrome);
        isPalindrome = sol.isPalindrome(".,aa!=");
        Assert.assertTrue(isPalindrome);
        isPalindrome  = sol.isPalindrome("A man, a plan, a canal: Panama");
        Assert.assertTrue(isPalindrome);
        isPalindrome  = sol.isPalindrome("race a car");
        Assert.assertFalse(isPalindrome);
        isPalindrome  = sol.isPalindrome("ka24y42ak");
        Assert.assertTrue(isPalindrome);
        isPalindrome  = sol.isPalindrome("k!a24y42a=k");
        Assert.assertTrue(isPalindrome);
        isPalindrome  = sol.isPalindrome("k!a24y42ak");
        Assert.assertTrue(isPalindrome);
        isPalindrome  = sol.isPalindrome("ka24y43ak");
        Assert.assertFalse(isPalindrome);
    }


    @Test  //#8
    public void testAtoi(){
        System.out.print("TEST #8 Atoi");
        int result;

        result = sol.myAtoi("         ");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("    +0 123");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("   +0 123");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("+");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("+-");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("+-2");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("0000003");
        Assert.assertEquals(result, 3);
        result = sol.myAtoi("   0000003azeaze");
        Assert.assertEquals(result, 3);
        result = sol.myAtoi("   -0000003azeaze");
        Assert.assertEquals(result, -3);
        result = sol.myAtoi(" eé4KJ");
        Assert.assertEquals(result, 0);
        result = sol.myAtoi("4653");
        Assert.assertEquals(result, 4653);
        result = sol.myAtoi("  4653 ");
        Assert.assertEquals(result, 4653);
        result = sol.myAtoi("  4653aze rreer");
        Assert.assertEquals(result, 4653);
        result = sol.myAtoi(" +4653");
        Assert.assertEquals(result, 4653);
        result = sol.myAtoi("-4653sdqsd");
        Assert.assertEquals(result, -4653);
        result = sol.myAtoi("2147483648998336648849947363");
        Assert.assertEquals(result, Integer.MAX_VALUE);
        result = sol.myAtoi("-21474836482392387487976784");
        Assert.assertEquals(result, Integer.MIN_VALUE);
        result = sol.myAtoi("    -21474836482392387487976784");
        Assert.assertEquals(result, Integer.MIN_VALUE);
        result = sol.myAtoi("    -0000000000000000000000000000000000000067");
        Assert.assertEquals(result, -67);
        result = sol.myAtoi("00000000000000000000000000000000000000670000");
        Assert.assertEquals(result, 670000);
        result = sol.myAtoi("2147493647");
        Assert.assertEquals(result, Integer.MAX_VALUE);
        result = sol.myAtoi("2147483648");
        Assert.assertEquals(result, Integer.MAX_VALUE);
        result = sol.myAtoi("-2147484648");
        Assert.assertEquals(result, Integer.MIN_VALUE);
        result = sol.myAtoi("-2147483649");
        Assert.assertEquals(result, Integer.MIN_VALUE);
        result = sol.myAtoi("-243599ke");
        Assert.assertEquals(result, -243599);
        result = sol.myAtoi("2140483647");
        Assert.assertEquals(result, 2140483647);
        result = sol.myAtoi("+99ke");
        Assert.assertEquals(result, 99);
        result = sol.myAtoi("-21474836489077");
        Assert.assertEquals(result, Integer.MIN_VALUE);
        result = sol.myAtoi("2147483647");
        Assert.assertEquals(result, 2147483647);
        result = sol.myAtoi("-2147483648");
        Assert.assertEquals(result, Integer.MIN_VALUE);
        result = sol.myAtoi("2147483647");
        Assert.assertEquals(result, Integer.MAX_VALUE);
        result = sol.myAtoi("      -11919730356x");
        Assert.assertEquals(result, Integer.MIN_VALUE);
    }

    @Test  //#6
    public void testConvertZigzag(){
        System.out.print("TEST #6 Convert Zigzag");
        String result;

        result = sol.convert(null, 3);
        Assert.assertEquals(result, null);
        result = sol.convert("", 3);
        Assert.assertEquals(result, "");
        result = sol.convert("", -1);
        Assert.assertEquals(result, "");
        result = sol.convert("ABC", 0);
        Assert.assertEquals(result, "");
        result = sol.convert("A", 3);
        Assert.assertEquals(result, "A");
        result = sol.convert("ABCDE", 5);
        Assert.assertEquals(result, "ABCDE");
        result = sol.convert("ABCDE", 1);
        Assert.assertEquals(result, "ABCDE");

        result = sol.convert("ABCDE", 2);
        Assert.assertEquals(result, "ADBCE");
        result = sol.convert("PAYPALISHIRING", 3);
        Assert.assertEquals(result, "PAHNAPLSIIGYIR");
        result = sol.convert("ABCDEFGHIJKLMNOP", 4);
        Assert.assertEquals(result, "AGMBEHKNCIODFJLP");
        result = sol.convert("ABCDEFGHIJKLMNOPQ", 5);
        Assert.assertEquals(result, "AHOBFIMPCJQDGKNEL");
        result = sol.convert("ABCDEFGHIJKLMNOPQRSTUVW", 6);
        Assert.assertEquals(result, "AJSBGKPTCLUDHMQVENWFIOR");
    }

    @Test  //#205
    public void testIsomorphicString(){
        System.out.print("TEST #205 Isomorphic String");
        boolean result;

        result = sol.isIsomorphic("egg", "add");
        Assert.assertTrue(result);
        result = sol.isIsomorphic("foo", "bar");
        Assert.assertFalse(result);
        result = sol.isIsomorphic("paper", "title");
        Assert.assertTrue(result);
        result = sol.isIsomorphic("ab", "aa");
        Assert.assertFalse(result);
    }

    @Test  //#206
    public void testRevertListNode(){
        System.out.print("TEST #206 Revert List Node");
        ListNode result;
        ListNode node = new ListNode(1);
        ListNode resultNode = new ListNode(2);

        result = sol.reverseList(null);
        Assert.assertEquals(result, null);
        result = sol.reverseList(node);
        Assert.assertEquals(result, new ListNode(1));
        node.next = new ListNode(2);
        resultNode.next = new ListNode(1);
        result = sol.reverseList(node);
        Assert.assertEquals(result, resultNode);

        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        resultNode = new ListNode(4);
        resultNode.next = new ListNode(3);
        resultNode.next.next = new ListNode(2);
        resultNode.next.next.next = new ListNode(1);
        result = sol.reverseList(node);
        Assert.assertEquals(result, resultNode);
    }

    @Test  //#203
    public void testRemoveListNode(){
        System.out.print("TEST #203 Remove List Node");
        ListNode result;
        ListNode node = new ListNode(1);
        ListNode resultNode;

        result = sol.removeElements(null, 3);
        Assert.assertEquals(result, null);
        result = sol.removeElements(node, 3);
        Assert.assertEquals(result, new ListNode(1));
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, null);
        node.next = new ListNode(1);
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, null);

        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, null);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, null);

        node.next = new ListNode(2);
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, new ListNode(2));

        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, new ListNode(3));

        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        result = sol.removeElements(node, 1);
        Assert.assertEquals(result, new ListNode(3));


        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(3);
        resultNode = new ListNode(1);
        resultNode.next = new ListNode(1);
        resultNode.next.next = new ListNode(4);
        result = sol.removeElements(node, 3);
        Assert.assertEquals(result, resultNode);
    }

    @Test  //#204
    public void testCountPrimes(){
        System.out.print("TEST #204 Count Primes");
        int result;

        result = sol.countPrimes(0);
        Assert.assertEquals(result, 0);
        result = sol.countPrimes(1);
        Assert.assertEquals(result, 0);
        result = sol.countPrimes(2);
        Assert.assertEquals(result, 0);
        result = sol.countPrimes(3);
        Assert.assertEquals(result, 1);
        result = sol.countPrimes(10);
        Assert.assertEquals(result, 4);
        result = sol.countPrimes(11);
        Assert.assertEquals(result, 4);
        result = sol.countPrimes(12);
        Assert.assertEquals(result, 5);
        result = sol.countPrimes(499979);
        Assert.assertEquals(result, 41537);
        result = sol.countPrimes(999983);
        Assert.assertEquals(result, 78497);
        result = sol.countPrimes(1500000);
        Assert.assertEquals(result, 114155);
    }

    @Test  //#102
    public void testBinaryTree(){
        System.out.print("TEST #102 Binary Tree");
        TreeNode tree = new TreeNode(3);
        List<List<Integer>> listResult;

        List<List<Integer>> treeList = new ArrayList<List<Integer>>();
        ArrayList<Integer> head = new ArrayList<Integer>() {{ add(3); }};
        treeList.add(head);

        listResult = sol.levelOrder(null);
        Assert.assertEquals(listResult, new ArrayList<List<Integer>>());
        listResult = sol.levelOrder(tree);
        Assert.assertEquals(listResult, treeList);

        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.left.left = new TreeNode(10);
        tree.left.right = new TreeNode(11);
        tree.left.right.right = new TreeNode(12);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        treeList.add(new ArrayList<Integer>() {{ add(9); add(20);}});
        treeList.add(new ArrayList<Integer>() {{ add(10); add(11); add(15); add(7); }});
        treeList.add(new ArrayList<Integer>() {{ add(12);}});
        listResult = sol.levelOrder(tree);
        Assert.assertEquals(listResult, treeList);
    }

    @Test  //#189
    public void testRotateArray(){
        System.out.print("TEST #189 Rotate Array");
        int[] nums;
        int[] result = new int[]{5,6,7,1,2,3,4};

        nums = null;
        sol.rotate(nums, 3);
        Assert.assertEquals(nums, null);

        nums = new int[]{1,2,3,4,5,6,7};
        sol.rotate(nums, 0);
        Assert.assertEquals(nums, nums);

        sol.rotate(nums, nums.length);
        Assert.assertEquals(nums, nums);

        sol.rotate(nums, 3);
        for(int i=0; i<nums.length; i++){
            Assert.assertEquals(result[i], nums[i]);
        }
    }
}
