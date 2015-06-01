import org.junit.Assert;
import org.junit.Test;

public class EasySolutionTest {

    EasySolution sol = new EasySolutionImpl();

    @Test //#19
    public void testListNode(){
        System.out.print("TEST #19 LIST NODE : ");
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
        System.out.print("TEST #125 PALINDROME : ");
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
        System.out.print("TEST #8 ATOI : ");
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
        System.out.print("TEST # CONVERT ZIZAG : ");
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
}
