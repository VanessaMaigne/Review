import com.sun.tools.javac.util.Pair;

import java.util.*;

public class MediumSolutionImpl implements MediumSolution{
    /**
     * #199 : Binary Tree Right Side View
     */
    public List<Integer> rightSideView(TreeNode root) {
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

    class Pair<A, B>   {
        public A fst;
        public B snd;

        public Pair(A a, B b) {
            this.fst = a;
            this.snd = b;
        }

    }

    // Without Pair but 2 HashMap
    public List<Integer> rightSideView2(TreeNode root) {
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


    /**
     * #200 : Number of Islands
     */
    public int numIslands3(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int result = 0;
        Deque<int[]> queue = new LinkedList<int[]>();
        boolean[][] checkedNode = new boolean[grid.length][grid[0].length];

        int i, j;
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            i = node[0];
            j = node[1];

            if(!checkedNode[i][j]){
                checkedNode[i][j] = true;

                // Island if arounded elements are already checked or water
                if(grid[i][j] == '1' &&
                        ((i+1 >= grid.length || !checkedNode[i+1][j] || grid[i+1][j] == '0')
                                && (i-1 <0 || !checkedNode[i-1][j] || grid[i-1][j] == '0')
                                && (j+1 >= grid[0].length || !checkedNode[i][j+1] || grid[i][j+1] == '0')
                                && (j-1 <0 || !checkedNode[i][j-1] || grid[i][j-1] == '0'))){
                    result++;
                }

                if(i+1<grid.length) queue.add(new int[]{i+1,j});
                if(i-1>=0) queue.add(new int[]{i-1,j});
                if(j+1<grid[0].length) queue.add(new int[]{i,j+1});
                if(j-1>=0) queue.add(new int[]{i,j-1});
            }
        }

        return result;
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int result = 0;
        Deque<int[]> queue = new LinkedList<int[]>();
        boolean[][] checkedNode = new boolean[grid.length][grid[0].length];

        int i, j;
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            i = node[0];
            j = node[1];


            if(!checkedNode[i][j]){
                checkedNode[i][j] = true;

                // Island if arounded elements are already checked or water
                boolean bob1 = (i+1 >= grid.length || !checkedNode[i+1][j] || grid[i+1][j] == '0');
                boolean bob2 = (i-1 <0 || !checkedNode[i-1][j] || grid[i-1][j] == '0');
                boolean bob3 = (j+1 >= grid[0].length || !checkedNode[i][j+1] || grid[i][j+1] == '0');
                boolean bob4 = (j-1 <0 || !checkedNode[i][j-1] || grid[i][j-1] == '0');
                if(grid[i][j] == '1' &&
                        ((i+1 >= grid.length || !checkedNode[i+1][j] || grid[i+1][j] == '0')
                                && (i-1 <0 || !checkedNode[i-1][j] || grid[i-1][j] == '0')
                                && (j+1 >= grid[0].length || !checkedNode[i][j+1] || grid[i][j+1] == '0')
                                && (j-1 <0 || !checkedNode[i][j-1] || grid[i][j-1] == '0'))){
                    result++;
                }

                if(i+1<grid.length) queue.add(new int[]{i+1,j});
                if(j+1<grid[0].length) queue.add(new int[]{i,j+1});
                if(i-1>=0) queue.add(new int[]{i-1,j});
                if(j-1>=0) queue.add(new int[]{i,j-1});
            }
        }

        return result;
    }

    public int numIslands2(char[][] grid) {
        if (grid.length == 0 || grid == null) {
            return 0;
        }
        int count = 0;
        boolean[][] marked = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    dfs(grid, marked, i, j);
                    count++;
                }
            }
        }

        return count;

    }
    //depth first search
    public void dfs(char[][] grid, boolean[][] marked, int i, int j) {
        //out of bound
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        //visited return
        if (marked[i][j]) {
            return;
        }
        //1 mark, 0 return
        if (grid[i][j] == '1') {
            marked[i][j] = true;
        } else {
            return;
        }
        //left
        dfs(grid, marked, i-1, j);
        //right
        dfs(grid, marked, i+1, j);
        //up
        dfs(grid, marked, i, j-1);
        //down
        dfs(grid, marked, i, j+1);
    }


    /**
     * #148 : Sort List
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;

        // Get head's size
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        temp = head;
        ListNode left = head;
        ListNode right;

        // Use of fusion sort to be in O(nlog(n))
        int i=1;
        while(temp != null && i<size/2){
            temp = temp.next;
            i++;
        }
        right = temp.next;
        temp.next = null;

        left = sortList(left);
        right = sortList(right);

        // Merge
        return mergeListNode(left, right);
    }

    private ListNode mergeListNode(ListNode left, ListNode right){
        ListNode temp;

        if(right.val < left.val){
            temp = right;
            right = left;
            left = temp;
        }
        ListNode tempLeft = left;
        ListNode tempRight = right;

        boolean isComplete = false;
        while(!isComplete && (tempLeft!=null || tempRight!=null)){
            if(tempLeft != null && tempRight != null && tempLeft.next != null){
                if(tempLeft.next.val <= tempRight.val){
                    tempLeft = tempLeft.next;
                } else {
                    temp = tempLeft.next;
                    tempLeft.next = tempRight;
                    tempRight = temp;
                }
            } else if (tempLeft.next == null){
                tempLeft.next = tempRight;
                isComplete = true;
            }
        }
        return left;
    }


    /**
     * #24 : Swap Nodes in Pairs
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode tempResult = result;
        ListNode temp = head;

        while(temp != null && temp.next != null){
            ListNode first = temp;
            ListNode second = temp.next;
            ListNode third = second.next;

            tempResult.next = second;
            tempResult.next.next = first;
            tempResult.next.next.next = third;
            temp = temp.next;
            tempResult = tempResult.next.next;
        }

        return  result.next;
    }

    public ListNode swapPairs3(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode curr = newhead;
        while(curr.next!=null && curr.next.next!=null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            ListNode nextPair = second.next;
            curr.next=second;
            second.next=first;
            first.next=nextPair;
            curr=first;
        }
        return newhead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode result = new ListNode(0);
        result.next = head;

        ListNode tempResult = result;
        ListNode tempHead = head;
        ListNode temp;
        while(tempHead != null && tempHead.next != null){
            if(tempHead.next != null){
                temp = tempHead.next;
                tempResult.next = tempHead.next;
                tempHead.next = tempHead.next.next;
                temp.next = tempHead;
                tempResult = tempHead;
                tempHead = tempHead.next;
            }
        }
        return result.next;
    }


    /**
     * #61 : Rotate List
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k<=0) return head;

        // Get size to avoid Time Limit exceeded
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        k = k%size;

        while(k>0){
            head = moveRight(head);
            k--;
        }
        return head;
    }

    private ListNode moveRight(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode tempHead = head;
        while(tempHead.next != null && tempHead.next.next != null){
            tempHead = tempHead.next;
        }

        ListNode temp = new ListNode(tempHead.next.val);
        tempHead.next = null;
        temp.next = head;

        return temp;
    }


    /**
     * #92 : Reverse Linked List II
     * We suppose 0<=m<=n<=length
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m>n || m<0 || n<0) return null;
        if(head == null || head.next == null) return head;
        if(m==n) return head;

        ListNode temp = head;
        ListNode beginList = head;
        ListNode endList = head;
        ListNode middleList = null;
        ListNode end = null;
        int size = 0;

        while(temp!=null && n>0){
            if(m==1) middleList = temp;
            if(n==1){
                end = endList.next;
                temp.next = null;
                beginList.next = reverseList(middleList);
            }

            if(m>2) beginList = beginList.next;
            if(n>1) endList = endList.next;
            m--;
            n--;
            size++;
            temp = temp.next;
        }

        if(end != null){
            temp = head;
            while(temp != null && temp.next != null){
                temp = temp.next;
            }
            temp.next = end;
        }

        return m+size == 1 ? head.next : head;
    }

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode result = null;
        while(head != null){
            ListNode temp = result;
            result = new ListNode(head.val);
            result.next = temp;
            head = head.next;
        }
        return result;
    }

    public ListNode switchBetween(ListNode head, int m, int n) {
        if(m>n || m<0 || n<0) return null;
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode tempBegin = head;
        ListNode tempEnd = head;
        int valueN;
        int valueM=0;

        while(temp != null && n>0){
            if(m==1){
                valueM = temp.val;
            } else if(n==1){
                valueN = temp.val;
                tempBegin.val = valueN;
                tempEnd.val = valueM;
            }
            if(m>1) tempBegin = tempBegin.next;
            if(n>1)tempEnd = tempEnd.next;
            m--;
            n--;
            temp = temp.next;
        }

        return head;
    }


    /**
     * 143 : Reorder List
     */
    public void reorderList(ListNode head) {
        if(head != null && head.next != null && head.next.next != null) {

            // Reverse head
            ListNode temp = head;
            ListNode reversedHead = null;
            ListNode tempHead;
            int size = 0;
            while(temp != null){
                tempHead = reversedHead;
                reversedHead = new ListNode(temp.val);
                reversedHead.next = tempHead;
                temp = temp.next;
                size++;
            }

            temp = head;
            int i=0;
            tempHead = temp.next;
            ListNode tempReverse;
            while(i<size/2){
                temp.next = reversedHead;
                temp = temp.next;
                tempReverse = reversedHead.next;
                temp.next = tempHead;
                tempHead = tempHead.next;
                reversedHead = tempReverse;
                if(i+1<size/2.) temp = temp.next; // At the end, we switch temp only for odd ListNode
                i++;
            }
            temp.next = null;
        }
    }


    /**
     * #86 : Partition List
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode temp = head;
        ListNode nodesToAddBefore = new ListNode(0);
        ListNode tempNodes = nodesToAddBefore;

        while(temp != null){
            if(temp.next != null && temp.next.val < x){
                tempNodes.next = new ListNode(temp.next.val);
                tempNodes = tempNodes.next;
                temp.next = temp.next.next;
            } else temp = temp.next;
        }

        nodesToAddBefore = nodesToAddBefore.next;
        if(nodesToAddBefore == null) return head;
        if(head.val < x){
            temp = head.next;
            head.next = nodesToAddBefore;
            tempNodes.next = temp;
            return head;
        } else {
            tempNodes.next = head;
            return nodesToAddBefore;
        }
    }


    /**
     * #151 : Reverse Words in a String
     */
    public String reverseWords(String s) {
        s = s.trim();
        if(s.equals("")) return s;

        String result = "";
        String[] strings = s.split(" ");
        if(strings.length <= 0) return "";
        if(strings.length == 1)  return strings[0];

        List<String> stringList = Arrays.asList(strings);
        Collections.reverse(stringList);

        for(String reverseS : stringList){
            if(!reverseS.equals(""))result += reverseS+" ";
        }
        return result.trim();
    }


    /**
     * #147 : Insertion Sort List
     */
//    public ListNode insertionSortList(ListNode head) {
//
//    }
}
