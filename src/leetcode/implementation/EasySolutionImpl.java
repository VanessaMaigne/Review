import java.util.*;

public class EasySolutionImpl implements EasySolution {
    /**
     * #19 : Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return head;

        else if(head.next == null) return null;

        else {
            int size = 1;
            int i=0;
            ListNode temp = head;
            ListNode last = head;

            while(temp.next != null){
                size++;
                temp = temp.next;
            }

            if(size == n) return head.next; // Remove first element
            else {
                while(last.next != null && i < size-n-1){
                    last = last.next;
                    i++;
                }

                if(last.next != null && last.next.next != null){
                    last.next = last.next.next;
                } else {
                    last.next = null;
                }
            }

            return head;
        }
    }

    // Solution from https://leetcode.com/discuss/37436/my-simple-java-solution
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            if(n-- < 0) {
                slow = slow.next;
            }
        }

        if(n == 0) {
            head = head.next;
        } else if(n < 0) {
            slow.next = slow.next.next;
        } else {
            return null;
        }

        return head;
    }

    /**
     * #125 : Valid Palindrome
     */
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        s = s.toUpperCase();
        boolean isPalindrome = true;
        int i=0, j=s.length()-1;
        while(i<j && isPalindrome){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(j>=i && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(i<j){
                isPalindrome = s.charAt(i) == s.charAt(j);
                i++;
                j--;
            }
        }

        return isPalindrome;
    }

    /**
     * #8 : String to Integer (atoi)
     */
    public int myAtoi(String str) {
        if(str.isEmpty() || str == null) return 0;

        String[] strArray = str.split(" ");
        if(strArray.length == 0) return 0;

        int i=0;
        while(strArray[i].equals("")) i++;
        str = strArray[i];

        char firstChar = str.charAt(0);
        if(!Character.isDigit(firstChar) && firstChar != '+' && firstChar != '-') return 0;

        boolean isNegatif = str.charAt(0) == '-';
        if(str.charAt(0) == '+' || str.charAt(0) == '-')
            str = str.substring(1, str.length());

        if(str.isEmpty() || !Character.isDigit(str.charAt(0))) return 0;

        try{
            int value = Integer.parseInt(str);
            return isNegatif ? -value : value;

        } catch(NumberFormatException e){
            i=0;
            String temp="";
            while(i<str.length() && Character.isDigit(str.charAt(i))){
                temp += str.charAt(i);
                i++;
            }

            if(temp.isEmpty()) return 0;
            else {
                String maxStr = String.valueOf(Integer.MAX_VALUE);
                String minStr = String.valueOf(Integer.MIN_VALUE);

                if(isNegatif){
                    if(temp.length() > minStr.length()-1) return Integer.MIN_VALUE;
                    else if(temp.length() == minStr.length()-1
                            && temp.compareTo(minStr.substring(1, minStr.length())) >= 0) return Integer.MIN_VALUE;
                    else return myAtoi("-"+temp);

                } else {
                    if(temp.length() > maxStr.length()) return Integer.MAX_VALUE;
                    else if(temp.length() == maxStr.length() && temp.compareTo(maxStr) >= 0) return Integer.MAX_VALUE;
                    else return myAtoi(temp);
                }
            }
        }
    }


    /**
     *  #6 : ZigZag Conversion
     *  Pb with the text not clear. ABC, 2 --> ACB ??
     */
    public String convert(String s, int numRows) {
        if(s == null) return null;
        else if(numRows <= 0 || s.length() == 0) return "";
        else if(s.length() <= numRows || numRows == 1) return s;

        String result ="";
        int numberOfCharsInSmallRows = numRows / 2;
        for(int i=1; i<=numRows; i++){
            int j=i;
            if(i%2 ==0){ // even line
                boolean isFullRow = true;
                int gabFullRow = Math.abs(numRows -j) + j/2;
                int gabSmallRow = numRows + numberOfCharsInSmallRows - gabFullRow;
                while(j <= s.length()){
                    result += s.charAt(j-1);
                    j+= isFullRow ? gabFullRow : gabSmallRow;
                    isFullRow = !isFullRow;
                }
            } else { // odd line
                while(j <= s.length()){
                    result += s.charAt(j-1);
                    j+=numRows + numberOfCharsInSmallRows;
                }
            }
        }
        return result;
    }


    /**
     * #205 : Isomorphic Strings
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int i=0;
        boolean isIsomorphic = true;
        HashMap<Character, Character> mapLeftToRight = new HashMap<Character, Character>();
        HashMap<Character, Character> mapRightToLeft = new HashMap<Character, Character>();

        while(i<s.length() && isIsomorphic){
            if(mapLeftToRight.get(s.charAt(i)) != null){
                isIsomorphic = t.charAt(i) == mapLeftToRight.get(s.charAt(i));
            } else {
                mapLeftToRight.put(s.charAt(i), t.charAt(i));
                if(mapRightToLeft.get(t.charAt(i)) != null) isIsomorphic = false;
                else mapRightToLeft.put(t.charAt(i), s.charAt(i));
            }
            i++;
        }
        return isIsomorphic;
    }


    /**
     * #206 : Reverse Linked List
     */
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        else {
            ListNode result = null;

            while(head != null){
                ListNode t = result;
                result = new ListNode(head.val);
                result.next = t;
                head = head.next;
            }

            return result;
        }
    }

    // Solution from https://leetcode.com/discuss/37804/iteratively-and-recursively-java-solution
    public ListNode reverseList2(ListNode head) {
        if(head == null) return head;

        ListNode next = head.next;
        head.next = null;

        while(next != null){
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        return head;
    }


    /**
     * #203 : Remove Linked List Elements
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;

        ListNode temp = head;

        while(temp != null){
            if(temp.val == val){
                temp = temp.next;
                head = temp;
            } else if(temp.next != null && temp.next.val == val) temp.next = temp.next.next;
            else temp = temp.next;
        }

        if(head != null && head.next == null && head.val == val) return null;
        else return head;
    }


    /**
     * #204 : Count Primes
     */
    public int countPrimes(int n) { // n excluded
        if(n <= 2) return 0;

        int number = 1;
        for(int i=3; i<n; i+=2){
            if(isPrimeNumber((long) i))
                number++;
        }
        return number;
    }

    public boolean isPrimeNumber(final Long n){
        if(n==2) return true;
        if(n <= 1 || n%2 == 0) return false;
        int i=3;

        boolean isPrime = true;
        while(isPrime && i<=Math.sqrt(n)){
            if(n%i == 0) isPrime = false;
            i+=2;
        }
        return isPrime;
    }

    // Version with Eratosthene crible
    public int countPrimes2(int n){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(2);

        for(int i=3; i<=n; i+=2){
            int j=0;
            boolean isPrime = true;
            while(j<numbers.size() && isPrime){
                if(i%numbers.get(j) == 0) isPrime = false;
                j++;
            }
            if(isPrime)
                numbers.add(i);
        }

        return numbers.size();
    }


    /**
     * #102 : Binary Tree Level Order Traversal
     * BFS
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nodeList = new ArrayList<Integer>();

        Deque<TreeNode> mainQueue = new LinkedList<TreeNode>();
        Deque<TreeNode> childrenQueue = new LinkedList<TreeNode>();

        mainQueue.add(root);
        while(!mainQueue.isEmpty()){
            TreeNode node = mainQueue.remove();
            nodeList.add(node.val);

            if(node.left != null) childrenQueue.add(node.left);
            if(node.right != null) childrenQueue.add(node.right);

            if(mainQueue.isEmpty()){
                result.add(nodeList);
                mainQueue = childrenQueue;
                childrenQueue = new LinkedList<TreeNode>();
                nodeList = new ArrayList<Integer>();
            }
        }
        return result;
    }


    /**
     * #189 : Rotate Array
     */
    public void rotate(int[] nums, int k) {
        if(nums != null && k > 0){
            int[] result = new int[nums.length];
            for(int i=0; i<nums.length; i++){
                int newPosition = i+k >= nums.length ? (i+k)%nums.length : i+k;
                result[newPosition] = nums[i];
            }
            for(int i=0; i<nums.length; i++){
                nums[i] = result[i];
            }
        }
    }


    /**
     * #14 : Longest Common Prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0].toLowerCase();

        String prefix = "";
        boolean isValidPrefix = true;
        int j=1;
        while(j<=strs[0].length() && isValidPrefix){
            prefix = strs[0].toLowerCase().substring(0, j);
            int i=1;
            while(i<strs.length && isValidPrefix){
                if(j<=strs[i].length()) isValidPrefix = prefix.equals(strs[i].toLowerCase().substring(0, j));
                else isValidPrefix = false;
                i++;
            }
            j++;
        }

        if(isValidPrefix) return prefix;
        else if(prefix.length() > 0 ) return prefix.substring(0, prefix.length()-1);
        else return "";
    }


    /**
     * #109 : Binary Tree Level Order Traversal II
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> nodeList = new ArrayList<Integer>();

        Deque<TreeNode> mainQueue = new LinkedList<TreeNode>();
        Deque<TreeNode> childrenQueue = new LinkedList<TreeNode>();

        mainQueue.add(root);
        while(!mainQueue.isEmpty()){
            TreeNode node = mainQueue.remove();
            nodeList.add(node.val);

            if(node.left != null) childrenQueue.add(node.left);
            if(node.right != null) childrenQueue.add(node.right);

            if(mainQueue.isEmpty()){
                result.add(0, nodeList);
                mainQueue = childrenQueue;
                childrenQueue = new LinkedList<TreeNode>();
                nodeList = new ArrayList<Integer>();
            }
        }

        return result;
    }

    // Solution from https://leetcode.com/discuss/27826/my-java-implementation-using-arraylist
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        traverse(list, 0 , root);
        return list;
    }

    private void traverse(List<List<Integer>> list, int level, TreeNode node){
        if(node == null) return;
        if(list.size() - 1 < level) list.add(0, new ArrayList<Integer>());
        list.get(list.size() - level - 1).add(node.val);
        traverse(list, level + 1, node.left);
        traverse(list, level + 1, node.right);
    }
}
