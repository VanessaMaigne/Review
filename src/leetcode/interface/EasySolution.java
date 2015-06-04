import java.util.List;

public interface EasySolution {

    public ListNode removeNthFromEnd(ListNode head, int n); //#19 : Remove Nth Node From End of List
    public ListNode removeNthFromEnd2(ListNode head, int n);

    public boolean isPalindrome(String s); //#125 : Valid Palindrome

    public int myAtoi(String str); //#8 : String to Integer (atoi)

    // Not correct
    public String convert(String s, int numRows); //#6 : ZigZag Conversion

    public boolean isIsomorphic(String s, String t); //#205 : Isomorphic Strings

    public ListNode reverseList(ListNode head); //#206 : Reverse Linked List
    public ListNode reverseList2(ListNode head);

    public ListNode removeElements(ListNode head, int val); //#203 : Remove Linked List Elements

    public int countPrimes(int n); //#204 : Count Primes
    public int countPrimes2(int n);

    public List<List<Integer>> levelOrder(TreeNode root); //#102 : Binary Tree Level Order Traversal

    public void rotate(int[] nums, int k); //#189 : Rotate Array

    public String longestCommonPrefix(String[] strs); //#14 : Longest Common Prefix

    public List<List<Integer>> levelOrderBottom(TreeNode root); //#109 : Binary Tree Level Order Traversal II

    public boolean isSymmetric(TreeNode root); //#101 : Symmetric Tree

    public boolean isSameTree(TreeNode p, TreeNode q); //#100 : Same Tree

    public boolean hasPathSum(TreeNode root, int sum); //#112 : Path Sum
}
